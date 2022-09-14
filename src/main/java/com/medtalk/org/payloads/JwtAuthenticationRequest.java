package com.medtalk.org.payloads;


import lombok.Data;

@Data
public class JwtAuthenticationRequest {

    private String username;
    private  String password;
}
