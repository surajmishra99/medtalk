package com.medtalk.org.jwt;

import com.sun.net.httpserver.Filter;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Component

public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private JwtTokenHelper jwtTokenHelper;





    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {


            String requestToken = request.getHeader("Authorization");
            System.out.println("requestToken ");


            String username=null;
            String token = null;

            //get jwt token from request

            if (requestToken != null && requestToken.startsWith("Bearer ")) {
                token=requestToken.substring(7);

                try {
                    username = this.jwtTokenHelper.getUsernameFromToken(token);
                }catch (IllegalArgumentException e) {

                    System.out.println("unable to get jwt token");

                }catch (ExpiredJwtException e) {

                    System.out.println("jwt token has expired");

                }catch (MalformedJwtException e) {
                    System.out.println("jwt token is invalid");

                }

            }else {

                System.out.println("This toke does not start with Bearer");
            }

          //Validate

            if(username != null&& SecurityContextHolder.getContext().getAuthentication() == null){

               UserDetails userDetails= this.userDetailsService.loadUserByUsername(username);

                if(Boolean.TRUE.equals(this.jwtTokenHelper.validateToken(token,userDetails))){

                    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken=new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                }else {

                    System.out.println("invalid jwt token");
                }

            }else {
                System.out.println("Username not null or context not null");
            }


        chain.doFilter(request, response);




    }
}


