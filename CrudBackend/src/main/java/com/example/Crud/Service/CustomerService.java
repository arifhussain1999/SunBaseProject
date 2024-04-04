package com.example.Crud.Service;

import com.example.Crud.DTO.Request.CustomerRequest;
import com.example.Crud.DTO.Response.CustomerResponse;

import java.util.List;

public interface CustomerService {

    CustomerResponse addCustomer(CustomerRequest customerRequest);

    CustomerResponse updateCustomer(int id, CustomerRequest customerRequest);

    CustomerResponse deleteCustomer(int id);

    CustomerResponse getCustomer(int id);

    List<CustomerResponse> getCustomersBy(String search, String value);
}
