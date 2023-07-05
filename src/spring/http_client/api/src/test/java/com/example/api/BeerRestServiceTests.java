/**
 * @project LikeLion_Backend
 * @author ARA
 * @since 2023-07-05 PM 1:14
 */

package com.example.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BeerRestServiceTests {
    @Autowired
    private BeerRestService service;

    @Test
    public void testGetBeerObject() {
        service.getBeerObject();
    }

    @Test
    public void testGetBeerEntity() {
        service.getBeerEntity();
    }

    @Test
    public void testPostBeerObject() {
        service.postBeerObject();
    }
}
