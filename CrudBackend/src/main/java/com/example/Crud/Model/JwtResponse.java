package com.example.Crud.Model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class JwtResponse {

    private String jwtToken;
    private String username;
}
