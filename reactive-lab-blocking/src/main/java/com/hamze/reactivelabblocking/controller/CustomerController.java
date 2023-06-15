package com.hamze.reactivelabblocking.controller;

import com.hamze.reactivelabblocking.domain.entity.CustomerEntity;
import com.hamze.reactivelabblocking.service.internal.api.ICustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/reactive-lab/rest/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final ICustomerService customerService;

    @PostMapping(path = "/create")
    public ResponseEntity<CustomerEntity> createCustomer(@RequestBody Map<String, Object> requestBody) {

        CustomerEntity customer = new CustomerEntity();
        customer.setCustomerId((Integer) requestBody.get("customerId"));
        customer.setFirstName((String) requestBody.get("firstName"));
        customer.setLastName((String) requestBody.get("lastName"));
        customer.setNationalId((String) requestBody.get("nationalId"));

        return ResponseEntity.ok(customerService.save(customer));
    }

    @PostMapping(path = "/update")
    public ResponseEntity<CustomerEntity> updateCustomer(@RequestBody Map<String, Object> requestBody) {

        CustomerEntity customer = customerService.findById((Integer) requestBody.get("customerId"));

        customer.setCustomerId((Integer) requestBody.get("customerId"));
        customer.setFirstName((String) requestBody.get("firstName"));
        customer.setLastName((String) requestBody.get("lastName"));
        customer.setNationalId((String) requestBody.get("nationalId"));

        return ResponseEntity.ok(customerService.save(customer));
    }

    @PostMapping(path = "/get")
    public ResponseEntity<CustomerEntity> getCustomer(@RequestBody Map<String, Object> requestBody) {

        CustomerEntity customer = customerService.findById((Integer) requestBody.get("customerId"));

        return ResponseEntity.ok(customer);

    }

}
