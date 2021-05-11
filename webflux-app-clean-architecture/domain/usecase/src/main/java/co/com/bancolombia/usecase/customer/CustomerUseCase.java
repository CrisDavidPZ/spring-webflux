package co.com.bancolombia.usecase.customer;

import co.com.bancolombia.model.customer.Customer;
import co.com.bancolombia.model.customer.gateways.CustomerService;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class CustomerUseCase {
    private final CustomerService customerServiceGateway;

    public Mono<Customer> retrieveCustomer(int id){
        return customerServiceGateway.retrieveCustomer(id);
    }
}
