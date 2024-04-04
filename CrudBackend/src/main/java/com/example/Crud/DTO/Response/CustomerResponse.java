package com.example.Crud.DTO.Response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class CustomerResponse {
    String firstName;
    String uId;
    Date joinedOn;
    String lastName;
    String street;
    String address;
    String city;
    String message;
    String state;
    String phone;
    String email;
}
