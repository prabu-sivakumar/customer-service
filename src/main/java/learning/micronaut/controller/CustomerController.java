package learning.micronaut.controller;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import learning.micronaut.model.Customer;
import learning.micronaut.service.CustomerService;

import javax.inject.Inject;
import java.util.Collection;

@Controller("/customer")
public class CustomerController {

    @Inject
    private CustomerService customerService;

    @Get("/")
    Collection<Customer> getCustomers() {
        return customerService.getInitialCustomers();
    }
}
