package com.example.Crud.Transformer;

import com.example.Crud.DTO.Request.CustomerRequest;
import com.example.Crud.DTO.Response.CustomerResponse;
import com.example.Crud.Model.Customer;

public class CustomerTransformer {

    public static Customer CustomerRequestToCustomer(CustomerRequest customerRequest){
        return Customer.builder()
                .email(customerRequest.getEmail())
                .phone(customerRequest.getPhone())
                .state(customerRequest.getState())
                .city(customerRequest.getCity())
                .address(customerRequest.getAddress())
                .firstName(customerRequest.getFirstName())
                .lastName(customerRequest.getLastName())
                .street(customerRequest.getStreet())
                .build();

    }

    public static CustomerResponse customerToCustomerResponse(Customer customer){
        return CustomerResponse.builder()
                .uId(customer.getUId())
                .joinedOn(customer.getJoinedOn())
                .email(customer.getEmail())
                .phone(customer.getPhone())
                .state(customer.getState())
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .address(customer.getAddress())
                .city(customer.getCity())
                .street(customer.getStreet())
                .build();
    }

    public static Customer customerFromCustomerDto(Customer user,CustomerRequest dto){
        user.setAddress(dto.getAddress());
        user.setCity(dto.getCity());
        user.setEmail(dto.getEmail());
        user.setPhone(dto.getPhone());
        user.setStreet(user.getStreet());
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setState(dto.getState());
        return user;

    }
}
