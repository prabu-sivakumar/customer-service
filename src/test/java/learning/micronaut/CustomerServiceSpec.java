package learning.micronaut;

import io.micronaut.context.ApplicationContext;
import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import learning.micronaut.model.Customer;
import learning.micronaut.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import javax.inject.Inject;
import java.util.Collection;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@MicronautTest
class CustomerServiceSpec {

    @Inject
    EmbeddedApplication<?> application;

    @Test
    void isApplicationRunning() {
        Assertions.assertTrue(application.isRunning());
    }

    @Test
    void validateInitialCustomers() {
        Map<String, Object> configuration = Map.of("customers.tucker.id", "1",
                "customers.tucker.name", "Tucker",
                "customers.barney.id", "2",
                "customers.barney.name", "Barney");
        try (ApplicationContext context = ApplicationContext.run(configuration)) {
            CustomerService customerService = context.getBean(CustomerService.class);
            Collection<Customer> initialCustomers = customerService.getInitialCustomers();
            assertEquals(2, initialCustomers.size());
            assertTrue(initialCustomers.stream().anyMatch(c ->
                    c.getName().equals("Tucker")));
        }
    }
}
