package guru.springframework.spring6reactive.repositories;

import guru.springframework.spring6reactive.config.DatabaseConfig;
import guru.springframework.spring6reactive.domain.Beer;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.r2dbc.DataR2dbcTest;
import org.springframework.context.annotation.Import;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created By dhaval on 2023-07-04
 */
@Slf4j
@DataR2dbcTest
@Import(DatabaseConfig.class)
class BeerRepositoryTest {

    @Autowired
    BeerRepository beerRepository;

    @Test
    void testSaveNewBeer() {
        beerRepository.save(getTestBeer())
                .subscribe(beer -> {
                    log.info(beer.toString());
                });
    }

    Beer getTestBeer() {
        return Beer.builder()
                .beerName("Space Dust")
                .beerStyle("IPA")
                .upc("123123")
                .price(BigDecimal.TEN)
                .quantityOnHand(12)
                .build();
    }
}