package com.hamze.reactivelabblocking.repository.api;

import com.hamze.reactivelabblocking.domain.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository("CustomerRepository")
@Transactional(propagation = Propagation.REQUIRED)
public interface ICustomerRepository extends JpaRepository<CustomerEntity, Integer> {
}
