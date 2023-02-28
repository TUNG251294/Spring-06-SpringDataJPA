package com.cg.cms.service;

import com.cg.cms.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();

    boolean insertWithStoredProcedure(Customer customer);
}
