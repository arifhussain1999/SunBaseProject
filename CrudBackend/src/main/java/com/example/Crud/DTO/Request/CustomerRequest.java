package com.example.Crud.DTO.Request;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class CustomerRequest {

    String firstName;

    String lastName;
    String street;
    String address;
    String city;
    String state;
    String phone;
    String email;
}
