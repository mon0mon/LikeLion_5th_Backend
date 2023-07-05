/**
 * @project LikeLion_Backend
 * @author ARA
 * @since 2023-07-05 PM 3:25
 */

package com.example.api;

import com.example.api.service.BeerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BeerServiceTests {
    @Autowired
    private BeerService service;

    @Test
    public void drinkBeer() {
        service.drinkBeer();
    }
}
