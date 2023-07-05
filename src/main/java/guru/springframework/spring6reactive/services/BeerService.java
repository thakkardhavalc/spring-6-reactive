package guru.springframework.spring6reactive.services;

import guru.springframework.spring6reactive.model.BeerDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created By dhaval on 2023-07-04
 */
public interface BeerService {

    Flux<BeerDTO> listBeers();

    Mono<BeerDTO> getBeerById(Integer beerId);
}
