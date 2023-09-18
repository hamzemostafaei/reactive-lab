package com.hamze.reactivelabblocking.controller;

import com.github.benmanes.caffeine.cache.Cache;
import com.hamze.reactivelabblocking.domain.entity.CustomerEntity;
import com.hamze.reactivelabblocking.repository.api.ICustomerRepository;
import com.hamze.reactivelabblocking.service.internal.api.ICustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/reactive-lab/rest/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final ICustomerService customerService;

    private final ICustomerRepository customerRepository;

    @Autowired
    private CacheManager cacheManager;

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

//        CustomerEntity customer = customerService.findById((Integer) requestBody.get("customerId"));
        CustomerEntity customer = findById((Integer) requestBody.get("customerId"));

        return ResponseEntity.ok(customer);

    }

    @Cacheable(value = "bpms", key = "#customerId")
    public CustomerEntity findById(Integer customerId) {

        Optional<CustomerEntity> customerOptional = customerRepository.findById(customerId);

        return customerOptional.orElse(null);
    }

    @GetMapping(value = "/test/inspectCache")
    public @ResponseBody Object inspectCache() {

        CaffeineCache caffeineCache = (CaffeineCache) cacheManager.getCache("bpms");
        Cache<Object, Object> nativeCache = caffeineCache.getNativeCache();

        for (Map.Entry<Object, Object> entry : nativeCache.asMap().entrySet()) {

            System.out.println("Key = " + entry.getKey());
            System.out.println("Value = " + entry.getValue().toString());
        }

        return null;
    }

}
