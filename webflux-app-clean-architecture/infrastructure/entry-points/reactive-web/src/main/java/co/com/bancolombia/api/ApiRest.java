package co.com.bancolombia.api;
import co.com.bancolombia.model.customer.Customer;
import co.com.bancolombia.model.customer.exceptions.CustomerNotFoundException;
import co.com.bancolombia.usecase.customer.CustomerUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ApiRest {
    private final CustomerUseCase personUseCase;

    @GetMapping(path = "/customers/{id}")
    public Mono<Customer> retrieveCustomer(@PathVariable int id) {
        return personUseCase.retrieveCustomer(id)
                .onErrorReturn(CustomerNotFoundException.class, Customer.builder().build())
                .onErrorReturn(Customer.builder().build());
    }
}
