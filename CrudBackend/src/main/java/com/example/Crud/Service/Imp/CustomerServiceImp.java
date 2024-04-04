package com.example.Crud.Service.Imp;

import com.example.Crud.DTO.Request.CustomerRequest;
import com.example.Crud.DTO.Response.CustomerResponse;
import com.example.Crud.Exception.CustomerNotFoundException;
import com.example.Crud.Model.Customer;
import com.example.Crud.Repository.CustomerRepository;
import com.example.Crud.Service.CustomerService;
import com.example.Crud.Transformer.CustomerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImp implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public CustomerResponse addCustomer(CustomerRequest customerRequest){
        Customer customer = CustomerTransformer.CustomerRequestToCustomer(customerRequest);

        customer.setUId(String.valueOf(UUID.randomUUID()));
        Customer savedCustomer=customerRepository.save(customer);

        CustomerResponse customerResponse = CustomerTransformer.customerToCustomerResponse(savedCustomer);
        customerResponse.setMessage("Customer has been added");

        return customerResponse;
    }

    @Override
    public CustomerResponse updateCustomer(int id, CustomerRequest customerRequest){
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if (optionalCustomer.isEmpty()) {
            //Instead of Throwing an error you can Save it as it was written in that doc..
            CustomerResponse dto = addCustomer(customerRequest);
            dto.setMessage("We Didn't Found Anything Related to this Id so. We have created Your Account");
            return dto;
        }

        Customer customer = optionalCustomer.get();
        customer = CustomerTransformer.customerFromCustomerDto(customer, customerRequest);

        Customer savedUser = customerRepository.save(customer);

        CustomerResponse customerResponse = CustomerTransformer.customerToCustomerResponse(savedUser);
        customerResponse.setMessage("Customer With name:" + customer.getFirstName() + " has been Updated");
        return customerResponse;
    }

    @Override
    public CustomerResponse deleteCustomer(int id){
        Optional<Customer> optionalUser = customerRepository.findById(id);
        if (optionalUser.isEmpty()) throw new CustomerNotFoundException("User with id " + id + " is Not Found");

        customerRepository.deleteById(id); //this wll delete the User
        Customer customer = optionalUser.get();
        CustomerResponse customerResponse = CustomerTransformer.customerToCustomerResponse(customer);
        customerResponse.setMessage("User with id:" + customer.getId() + " has been deleted Successfully!!");
        return customerResponse;
    }

    @Override
    public CustomerResponse getCustomer(int id){
        Optional<Customer>optionalUser=customerRepository.findById(id);
        if(optionalUser.isEmpty())throw new CustomerNotFoundException("Unable to find user with userId: "+id);

        Customer customer=optionalUser.get();
        CustomerResponse customerResponse=CustomerTransformer.customerToCustomerResponse(customer);
        customerResponse.setMessage("User is Found");
        return customerResponse;
    }

    @Override
    public List<CustomerResponse> getCustomersBy(String search, String value){
        List<Customer> customerList;
        switch (search) {
            case "city": {
                customerList = customerRepository.findByCity(value);
                break;
            }
            case "phone": {
                customerList = customerRepository.findByPhone(value);
                break;
            }
            case "first": {
                customerList = customerRepository.findByFirstName(value);
                break;
            }
            case "email": {
                customerList = customerRepository.findByEmail(value);
                break;
            }
            default: {
                customerList =customerRepository.findAll();
            }
        }

        //else I'll have the value..

        //let's Convert the  Every Customer to CustomerResponce dto using our Transformer Function and I've actually Used
        List<CustomerResponse> customerResponseList = customerList.stream()
                .map(ele -> CustomerTransformer.customerToCustomerResponse(ele))
                .collect(Collectors.toList());

        return customerResponseList;
    }
}
