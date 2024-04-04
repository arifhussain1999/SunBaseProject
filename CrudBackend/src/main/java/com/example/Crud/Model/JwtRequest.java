package com.example.Crud.Model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class JwtRequest {

    private String email;
    private String password;
}
