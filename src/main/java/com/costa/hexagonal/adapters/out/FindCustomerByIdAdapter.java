package com.costa.hexagonal.adapters.out;

import com.costa.hexagonal.adapters.out.repository.CustomerRepository;
import com.costa.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.costa.hexagonal.application.core.domain.Customer;
import com.costa.hexagonal.application.ports.out.FindCustomerByIdOutPutPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Optional;

@Component
public class FindCustomerByIdAdapter implements FindCustomerByIdOutPutPort {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    @Override
    public Optional<Customer> find(String id) {
        var customerEntity = customerRepository.findById(id);
        return customerEntity.map(entity -> customerEntityMapper.toCustomer(entity));
    }

}
