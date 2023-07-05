package guru.springframework.spring6reactive.controllers;

import guru.springframework.spring6reactive.model.BeerDTO;
import guru.springframework.spring6reactive.services.BeerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static guru.springframework.spring6reactive.utility.Constants.BEER_PATH;
import static guru.springframework.spring6reactive.utility.Constants.BEER_PATH_ID;

/**
 * Created By dhaval on 2023-07-04
 */
@RestController
@RequiredArgsConstructor
public class BeerController {

    private final BeerService beerService;

    @GetMapping(BEER_PATH_ID)
    Mono<BeerDTO> getBeerById(@PathVariable("beerId") Integer beerId){
        return beerService.getBeerById(beerId);
    }

    @GetMapping(BEER_PATH)
    Flux<BeerDTO> listBeers() {
        return beerService.listBeers();
    }
}
