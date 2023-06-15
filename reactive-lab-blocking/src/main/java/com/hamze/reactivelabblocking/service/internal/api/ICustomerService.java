package com.hamze.reactivelabblocking.service.internal.api;

import com.hamze.reactivelabblocking.domain.entity.CustomerEntity;

public interface ICustomerService {

    CustomerEntity findById(Integer customerId);

    CustomerEntity save(CustomerEntity customer);
}
