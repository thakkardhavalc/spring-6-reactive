package guru.springframework.spring6reactive.controllers;

import guru.springframework.spring6reactive.model.BeerDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import static guru.springframework.spring6reactive.utility.Constants.BEER_PATH;

/**
 * Created By dhaval on 2023-07-04
 */
@RestController
public class BeerController {

    @GetMapping(BEER_PATH)
    Flux<BeerDTO> listBeers() {
        return Flux.just(
                BeerDTO.builder()
                        .id(1)
                        .build(),
                BeerDTO.builder()
                        .id(2)
                        .build()
        );
    }
}
