/**
 * @project LikeLion_Backend
 * @author ARA
 * @since 2023-07-05 PM 3:14
 */

package com.example.api.service;

import com.example.api.client.BeerClient;
import com.example.api.dto.BeerGetDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BeerService {
    //  Service는 맥주정보를 어떻게 가져왔는지 중요하지 않다.
    private final BeerClient client;

    public BeerService(
//        @Qualifier("beerWebClient")
        BeerClient client) {
        this.client = client;
    }

    public void drinkBeer() {
        log.info("order beer");
        //  TODO API를 활용해 맥주 정보 받아오기
        BeerGetDto result = client.getBeer();
        log.info("{}는 맛있다", result.getName());
    }
}
