
package com.luv2code.springdemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

    @Autowired
    CustomerService customerSevice;

    // add mapping for Get /customers
    @GetMapping("/customers")
    public List<Customer> getCustomers() {
        return customerSevice.getCustomers();
    }

    // add mapping for get /customers/{custoemerId}
    @GetMapping("/customers/{customerId}")
    public Customer getCustomers(@PathVariable final int customerId) {
        final Customer customer = customerSevice.getCustomer(customerId);
        if (customer == null) {
            throw new CustomerNotFoundException("Customer id not found " + customerId);
        }
        return customer;
    }

    // add mapping for Post /customers add new customer
    @PostMapping("/customers")
    public Customer addCustomer(@RequestBody final Customer customer) {

        customer.setId(0);
        customerSevice.saveCustomer(customer);
        return customer;

    }

    // add mapping for put /customer update existing customer
    @PutMapping("/customers")
    public Customer updateCustomers(@RequestBody final Customer customer) {
        customerSevice.saveCustomer(customer);
        return customer;
    }

    // add mapping for delete /customer/{customerId}
    @DeleteMapping("/customers/{customerId}")
    public String deleteCustomer(@PathVariable final int customerId) {
        final Customer customer = customerSevice.getCustomer(customerId);
        if (customer == null) {
            throw new CustomerNotFoundException("Customer id not found " + customerId);
        }
        customerSevice.deleteCustomer(customerId);
        return "Delete customer id" + customerId;
    }

}
