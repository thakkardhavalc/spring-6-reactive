package guru.springframework.spring6reactive.controllers;

import guru.springframework.spring6reactive.domain.Customer;
import guru.springframework.spring6reactive.model.CustomerDTO;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import static guru.springframework.spring6reactive.utility.Constants.CUSTOMER_PATH;
import static guru.springframework.spring6reactive.utility.Constants.CUSTOMER_PATH_ID;

/**
 * Created By dhaval on 2023-07-06
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
@AutoConfigureWebTestClient
class CustomerControllerTest {

    @Autowired
    WebTestClient webTestClient;

    @Test
    void testPatchIdNotFound() {
        webTestClient.patch().uri(CUSTOMER_PATH_ID, 99)
                .body(Mono.just(getTestCustomer()), CustomerDTO.class)
                .exchange()
                .expectStatus().isNotFound();
    }

    @Test
    void testDeleteCustomerByIdNotFound() {
        webTestClient.delete().uri(CUSTOMER_PATH_ID, 99)
                .exchange()
                .expectStatus().isNotFound();
    }

    @Test
    @Order(999)
    void testDeleteCustomer() {
        webTestClient.delete().uri(CUSTOMER_PATH_ID, 1)
                .exchange()
                .expectStatus().isNoContent();
    }

    @Test
    void testUpdateCustomerIdNotFound() {
        webTestClient.put().uri(CUSTOMER_PATH_ID, 99)
                .body(Mono.just(getTestCustomer()), CustomerDTO.class)
                .exchange()
                .expectStatus().isNotFound();
    }

    @Test
    @Order(3)
    void testUpdateCustomer() {
        webTestClient.put().uri(CUSTOMER_PATH_ID, 1)
                .body(Mono.just(getTestCustomer()), CustomerDTO.class)
                .exchange()
                .expectStatus().isNoContent();
    }

    @Test
    void testCreateCustomerBadData() {
        Customer testCustomer = getTestCustomer();
        testCustomer.setCustomerName("");

        webTestClient.post().uri(CUSTOMER_PATH)
                .body(Mono.just(testCustomer), CustomerDTO.class)
                .header("content-type", "application/json")
                .exchange()
                .expectStatus().isBadRequest();
    }

    @Test
    void testCreateCustomer() {
        webTestClient.post().uri(CUSTOMER_PATH)
                .body(Mono.just(getTestCustomer()), CustomerDTO.class)
                .header("content-type", "application/json")
                .exchange()
                .expectStatus().isCreated()
                .expectHeader().location("http://localhost:8080/api/v2/customer/4");
    }

    @Test
    void testGetCustomerByIdNotFound() {
        webTestClient.get().uri(CUSTOMER_PATH_ID, 99)
                .exchange()
                .expectStatus().isNotFound();
    }

    @Test
    @Order(1)
    void testGetCustomerById() {
        webTestClient.get().uri(CUSTOMER_PATH_ID, 1)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().valueEquals("content-type", "application/json")
                .expectBody(CustomerDTO.class);
    }

    @Test
    @Order(2)
    void testListCustomers() {
        webTestClient.get().uri(CUSTOMER_PATH)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().valueEquals("content-type", "application/json")
                .expectBody().jsonPath("$.size()").isEqualTo(3);
    }

    Customer getTestCustomer() {
        return Customer.builder()
                .customerName("Adam")
                .build();
    }
}