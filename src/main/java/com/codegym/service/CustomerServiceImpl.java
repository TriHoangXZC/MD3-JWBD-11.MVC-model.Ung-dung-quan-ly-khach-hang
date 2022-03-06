package com.codegym.service;

import com.codegym.model.Customer;


import java.util.ArrayList;
import java.util.List;


public class CustomerServiceImpl implements ICustomerService {
    private static final List<Customer> customers;

    static {
        customers = new ArrayList<>();
        customers.add(new Customer(1, "John", "John@gmail.com", "HN"));
        customers.add(new Customer(2, "Bill", "Bill@gmail.com", "HN"));
        customers.add(new Customer(3, "Alex", "Alex@gmail.com", "HCM"));
        customers.add(new Customer(4, "Adam", "Adam@gmail.com", "DN"));
        customers.add(new Customer(5, "Rose", "Rose@gmail.com", "DN"));
    }

    @Override
    public List<Customer> findAll() {
        return customers;
    }

    @Override
    public void create(Customer customer) {
        customers.add(customer);
    }

    @Override
    public Customer findById(int id) {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getId() == id) {
                return customers.get(i);
            }
        }
        return null;
    }

    @Override
    public void updateById(int id, Customer customer) {
        for (int i = 0; i < customers.size(); i++) {
            if(customers.get(i).getId() == id) {
                customers.set(i, customer);
                break;
            }
        }
    }

    @Override
    public void deleteById(int id) {
        for (int i = 0; i < customers.size(); i++) {
            if(customers.get(i).getId() == id) {
                customers.remove(i);
                break;
            }
        }
    }
}
