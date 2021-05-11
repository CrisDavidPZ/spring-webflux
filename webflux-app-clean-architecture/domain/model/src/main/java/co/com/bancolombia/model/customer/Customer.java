package co.com.bancolombia.model.customer;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class Customer {
    private final int id;
    private final String name;
    private final boolean hasDebtQuota;
    private final Float debtQuota;
    private final String profile;
}
