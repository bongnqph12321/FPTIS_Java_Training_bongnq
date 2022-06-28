package vn.fis.training.ordermanagement.service;

import vn.fis.training.ordermanagement.model.Customer;

public interface CustomerService {

    Customer createCustomer(Customer customer);
    Customer findById(Long id);

    void deleteCustomerById(Long customerId);

    Customer updateCustomer(Customer customer);
}
