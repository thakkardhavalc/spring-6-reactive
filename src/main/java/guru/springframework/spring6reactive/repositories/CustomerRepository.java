package guru.springframework.spring6reactive.repositories;

import guru.springframework.spring6reactive.domain.Customer;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

/**
 * Created By dhaval on 2023-07-06
 */
public interface CustomerRepository extends ReactiveCrudRepository<Customer, Integer> {
}
