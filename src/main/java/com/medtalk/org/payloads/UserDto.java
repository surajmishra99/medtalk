package com.medtalk.org.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {

    private int id;

    @NotEmpty
    @Size(min = 4,message = "Name must contains min of 4 characters !!")
    private String name;

    @Email(message = "User Email address is not valid !!")
    private String email;

    @NotEmpty
    @Size(min = 4,max = 12,message = "Password must contains min of 4 characters and max of 12 characters !!")
//    @Pattern(regexp = )
    private String password;

    @NotEmpty
    @Size(min = 5,max = 150,message = "About must contains min of 5 characters and max of 150 characters !!")
    private String about;
}
