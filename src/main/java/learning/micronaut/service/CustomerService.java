package learning.micronaut.service;

import learning.micronaut.annotation.Logged;
import learning.micronaut.configuration.CustomerConfiguration;
import learning.micronaut.model.Customer;

import javax.inject.Singleton;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Singleton
public class CustomerService {

    private final List<CustomerConfiguration> customerConfigurations;

    public CustomerService(List<CustomerConfiguration> customerConfigurations) {
        this.customerConfigurations = customerConfigurations;
    }

    @Logged
    public Collection<Customer> getInitialCustomers() {
        return customerConfigurations.stream()
                .map(CustomerConfiguration::create)
                .collect(Collectors.toList());
    }
}
