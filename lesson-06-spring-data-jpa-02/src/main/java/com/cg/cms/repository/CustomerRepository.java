package com.cg.cms.repository;

import com.cg.cms.model.Customer;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class CustomerRepository implements ICustomerRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Customer> findAll() {
        String queryString = "select c from Customer c";
        TypedQuery<Customer> query = entityManager.createQuery(queryString, Customer.class);
        return query.getResultList();
    }

    @Override
    public boolean insertWithStoredProcedure(Customer customer) {
        String sql = "CALL Insert_Customer(:firstName, :lastName)";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("firstName", customer.getFirstName());
        query.setParameter("lastName", customer.getLastName());
        return query.executeUpdate() == 0;
    }
}
