package com.costa.hexagonal.application.ports.in;

import com.costa.hexagonal.application.core.domain.Customer;

public interface InsertCustomerInputPort {

    void insert(Customer customer, String zipCode);

}
