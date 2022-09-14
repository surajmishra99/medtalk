package com.medtalk.org.controllers;


import com.medtalk.org.payloads.JwtAuthenticationRequest;
import com.medtalk.org.payloads.JwtAuthenticationResponse;
import com.medtalk.org.jwt.JwtTokenHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class JwtController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserDetailsService userDetailsService;
   @Autowired
    private JwtTokenHelper jwtTokenHelper;


    @PostMapping("/authenticate")
        public ResponseEntity<JwtAuthenticationResponse>createToken(
                @RequestBody JwtAuthenticationRequest request)
        {
            this.authenticate(request.getUsername(), request.getPassword());
            UserDetails userDetails=this.userDetailsService.loadUserByUsername(request.getUsername());
           String token= this.jwtTokenHelper.generateToken(userDetails);

           JwtAuthenticationResponse response = new JwtAuthenticationResponse();
           response.setToken(token);
           return new ResponseEntity<>(response, HttpStatus.OK);
        }
        private void authenticate(String username,String password){

            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken=new UsernamePasswordAuthenticationToken(username, password);

            try {
                this.authenticationManager.authenticate(usernamePasswordAuthenticationToken);
            }catch (DisabledException e) {
                System.out.println("user disable");

            }
        }


}
