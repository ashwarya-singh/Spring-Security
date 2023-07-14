package com.ash.incubation.incubation.controller;

import com.ash.incubation.incubation.model.Customer;
import com.ash.incubation.incubation.service.BasicSecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class BasicSpringSecurityController {

    @Autowired
    BasicSecurityService service;

    @GetMapping("/welcome")
    public String entryToApplication(){
        return service.welcomeGreetsOnLanding();
    }

    @GetMapping("/allCustomer")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<Customer> findAllCustomer(){
        return service.findAllCustomer();

    }

    @GetMapping("customerId/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public Customer findCustomerById(@PathVariable int id){
        return service.findCustomerById(id);

    }

}
