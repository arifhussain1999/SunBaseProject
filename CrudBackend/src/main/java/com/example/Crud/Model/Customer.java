package com.example.Crud.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder

public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(nullable = false)
    String uId;

    @CreationTimestamp
    Date joinedOn;

    @Size(min = 4,max = 15)
    @Column(nullable = false)
    String firstName;

    @Size(min = 4,max = 15)
    @Column(nullable = false)
    String lastName;

    @Column(nullable = false)
    String street;

    @Column(nullable = false)
    String address;

    @Column(nullable = false)
    String city;

    @Column(nullable = false)
    String state;

    @Column(nullable = false, unique = true)
    String phone;

    @Column(nullable = false, unique = true)
    String email;
}
