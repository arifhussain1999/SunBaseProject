package com.example.Crud.Repository;

import com.example.Crud.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {


    List<Customer> findByFirstName(String firstName);
    List<Customer> findByPhone(String mobile);

    List<Customer> findByEmail(String email);
    List<Customer> findByCity(String city);
}
