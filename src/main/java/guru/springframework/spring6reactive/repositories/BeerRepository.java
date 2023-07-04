package guru.springframework.spring6reactive.repositories;

import guru.springframework.spring6reactive.domain.Beer;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

/**
 * Created By dhaval on 2023-07-04
 */
public interface BeerRepository extends ReactiveCrudRepository<Beer, Integer> {
}
