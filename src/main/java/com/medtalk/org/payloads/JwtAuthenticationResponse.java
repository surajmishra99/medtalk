package com.medtalk.org.payloads;


import lombok.Data;

@Data
public class JwtAuthenticationResponse {

    private String token;
}
