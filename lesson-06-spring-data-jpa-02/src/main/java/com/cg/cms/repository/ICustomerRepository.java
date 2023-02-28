package com.cg.cms.repository;

import com.cg.cms.model.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> findAll();

    boolean insertWithStoredProcedure(Customer customer);
}
