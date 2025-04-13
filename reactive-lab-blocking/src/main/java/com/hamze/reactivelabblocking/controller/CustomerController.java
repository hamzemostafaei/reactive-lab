package com.hamze.reactivelabblocking.controller;

import com.github.benmanes.caffeine.cache.Cache;
import com.hamze.reactivelabblocking.domain.entity.CustomerEntity;
import com.hamze.reactivelabblocking.repository.api.ICustomerRepository;
import com.hamze.reactivelabblocking.service.internal.api.ICustomerService;
import com.hamze.reactivelabblocking.service.internal.impl.CustomerServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/reactive-lab/rest/customer")
public class CustomerController {

    private final CustomerServiceImpl customerService;
    private final ICustomerRepository customerRepository;
    private final CacheManager cacheManager;

    private final ApplicationContext applicationContext;

    @PostMapping(path = "/get")
    public ResponseEntity<CustomerEntity> getCustomer(@RequestBody Map<String, Object> requestBody) {

        log.info("*************************************");
//        ICustomerService iCustomerService = applicationContext.getBean(ICustomerService.class);
//        log.info(iCustomerService.getClass().getName());
        log.info(customerService.getClass().getName());
        log.info("*************************************");

        CustomerEntity customer = customerService.findById((Integer) requestBody.get("customerId"));
//        CustomerEntity customer = findById((Integer) requestBody.get("customerId"));

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
