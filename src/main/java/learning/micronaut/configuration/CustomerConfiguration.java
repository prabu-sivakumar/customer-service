package learning.micronaut.configuration;

import io.micronaut.context.annotation.Context;
import io.micronaut.context.annotation.EachProperty;
import learning.micronaut.model.Customer;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@EachProperty("customers")
@Context
public class CustomerConfiguration {

    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Customer create() {
        return new Customer(id, name);
    }
}
