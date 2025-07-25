package com.mssc_brewery_client.web.client;

import com.mssc_brewery_client.web.model.BeerDto;
import com.mssc_brewery_client.web.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryClient client;

    @Test
    void testGetBeerById() {

        BeerDto beerDto = client.getBeerById(UUID.randomUUID());

        assertNotNull(beerDto);
    }

    @Test
    void testSaveNewBeer(){
        BeerDto beerDto=BeerDto.builder().beerName("New Beer").build();
        URI uri = client.savedNewBeer(beerDto);
        assertNotNull(uri);
        System.out.println(uri.toString());
    }

    @Test
    void testUpdateBeer(){
        BeerDto beerDto= BeerDto.builder().beerName("New Beer").build();
        client.updateBeer(UUID.randomUUID(),beerDto);
    }

    @Test
    void testDeleteBeer(){
        client.deleteBeer(UUID.randomUUID());
    }
    @Test
    void testGetCustomerById(){
        CustomerDto customerDto= client.getCustomerById(UUID.randomUUID());

        assertNotNull(customerDto);
    }

    @Test
    void testSavedNewCustomer(){
        CustomerDto customerDto= CustomerDto.builder().customerName("Gonca").build();
        URI uri=client.savedNewCustomer(customerDto);
        assertNotNull(uri);
        System.out.println(uri.toString());
    }

    @Test
    void testUpdateCustomer(){
        CustomerDto customerDto=CustomerDto.builder().customerName("Kenan").build();
        client.updateCustomer(UUID.randomUUID(),customerDto);
    }

    @Test
    void testDeleteCustomer(){
        client.deleteCustomer(UUID.randomUUID());
    }
}