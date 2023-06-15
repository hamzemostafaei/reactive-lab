package com.hamze.reactivelabblocking.controller;

import com.hamze.reactivelabblocking.domain.entity.CustomerEntity;
import com.hamze.reactivelabblocking.repository.api.ICustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/reactive-lab/rest/customer")
@RequiredArgsConstructor
public class CustomerController {

    @Autowired
    private ICustomerRepository customerRepository;

    @PostMapping(path = "/create")
    public ResponseEntity<CustomerEntity> createCustomer(@RequestBody Map<String, Object> requestBody) {

        CustomerEntity customer = new CustomerEntity();
        customer.setCustomerId((Integer) requestBody.get("customerId"));
        customer.setFirstName((String) requestBody.get("firstName"));
        customer.setLastName((String) requestBody.get("lastName"));
        customer.setNationalId((String) requestBody.get("nationalId"));

        return ResponseEntity.ok(customerRepository.save(customer));
    }

    @PostMapping(path = "/update")
    public ResponseEntity<CustomerEntity> updateCustomer(@RequestBody Map<String, Object> requestBody) {

        Optional<CustomerEntity> customerOptional = customerRepository.findById((Integer) requestBody.get("customerId"));

        if(customerOptional.isPresent()){
            CustomerEntity customer = customerOptional.get();
            customer.setCustomerId((Integer) requestBody.get("customerId"));
            customer.setFirstName((String) requestBody.get("firstName"));
            customer.setLastName((String) requestBody.get("lastName"));
            customer.setNationalId((String) requestBody.get("nationalId"));

            return ResponseEntity.ok(customerRepository.save(customer));
        }

       return null;
    }

}
