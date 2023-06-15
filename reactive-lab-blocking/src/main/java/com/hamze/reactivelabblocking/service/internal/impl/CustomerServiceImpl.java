package com.hamze.reactivelabblocking.service.internal.impl;

import com.hamze.reactivelabblocking.domain.entity.CustomerEntity;
import com.hamze.reactivelabblocking.repository.api.ICustomerRepository;
import com.hamze.reactivelabblocking.service.internal.api.ICustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service("CustomerService")
public class CustomerServiceImpl implements ICustomerService {

    private final ICustomerRepository customerRepository;

    @Override
    @Cacheable(value = "MapCacheManager", key = "#customerId")
    public CustomerEntity findById(Integer customerId) {

        Optional<CustomerEntity> customerOptional = customerRepository.findById(customerId);

        return customerOptional.orElse(null);
    }

    @Override
    @CachePut(value = "MapCacheManager", key = "#customer.customerId")
    public CustomerEntity save(CustomerEntity customer) {

        customer.setCustomerId(customer.getCustomerId());
        customer.setFirstName(customer.getFirstName());
        customer.setLastName(customer.getLastName());
        customer.setNationalId(customer.getNationalId());

        return customerRepository.save(customer);
    }


}
