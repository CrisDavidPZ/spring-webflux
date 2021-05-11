package co.com.bancolombia.customerdaoemuler;

import co.com.bancolombia.model.customer.Customer;
import co.com.bancolombia.model.customer.exceptions.CustomerNotFoundException;
import co.com.bancolombia.model.customer.gateways.CustomerService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class CustomerDAOEmuler implements CustomerService {
    private static List<Customer> customer = new ArrayList<>();

    static {
//        customer.add(Customer.builder().id(0).name("N/A").hasDebtQuota(true).debtQuota(0f).profile("N/A").build());
        customer.add(Customer.builder().id(1).name("Cris").hasDebtQuota(true).debtQuota(200000000f).profile("Risk").build());
        customer.add(Customer.builder().id(2).name("Ambar").hasDebtQuota(false).debtQuota(35000000f).profile("Moderate").build());
        customer.add(Customer.builder().id(3).name("Jesus").hasDebtQuota(true).debtQuota(11000000f).profile("Risk").build());
    }

    @Override
    public Mono<Customer> retrieveCustomer(int id){
        return Mono.just(customer.stream()
                .filter(customerFound -> customerFound.getId() == id)
                .findFirst().get()).onErrorMap(throwable -> new CustomerNotFoundException(throwable.getMessage()));
    }
}
