package com.cg.cms.repository;

import com.cg.cms.model.Customer;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
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
    public Customer findById(Long id) {
        String queryString = "select c from Customer c where c.id = :id";
        TypedQuery<Customer> query = entityManager.createQuery(queryString, Customer.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void save(Customer customer) {
        if (customer.getId() != null) {
            entityManager.merge(customer);
        } else {
            entityManager.persist(customer);
        }
    }

    @Override
    public void remove(Long id) {
        Customer customer = findById(id);
        if (customer != null) {
            entityManager.remove(customer);
        }
    }
}
