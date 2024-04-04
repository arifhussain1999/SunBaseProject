package com.example.Crud.Controller;

import com.example.Crud.DTO.Request.CustomerRequest;
import com.example.Crud.DTO.Response.CustomerResponse;
import com.example.Crud.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
@CrossOrigin
public class CustomerController {

   @Autowired
   CustomerService customerService;

    @PostMapping("/add-customer")
    public ResponseEntity addCustomer(@RequestBody CustomerRequest customerRequest){

            CustomerResponse customerResponse = customerService.addCustomer(customerRequest);
            return new ResponseEntity<>(customerResponse, HttpStatus.CREATED);

    }

    @PutMapping("/update-customer")
    public ResponseEntity updateCustomer(@RequestParam("id") int id, @RequestBody CustomerRequest customerRequest){

        try {
            CustomerResponse customerResponce = customerService.updateCustomer(id, customerRequest);
            return new ResponseEntity(customerResponce, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete-customer")
    public ResponseEntity deleteCustomer(@RequestParam("id") int id){
        try {
           CustomerResponse customerResponse= customerService.deleteCustomer(id);
            return new ResponseEntity(customerResponse,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get-customer")
    public ResponseEntity getCustomer(@RequestParam("id") int id){
        try {
            CustomerResponse customerResponse= customerService.getCustomer(id);
            return new ResponseEntity(customerResponse,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/find-by-search/{search}")
    public ResponseEntity findBySearch(@PathVariable("search") String search,@RequestParam("value") String value) {
        try {
            List<CustomerResponse> customerResponseList = customerService.getCustomersBy(search,value);
            return new ResponseEntity<>(customerResponseList, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
