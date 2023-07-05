/**
 * @project LikeLion_Backend
 * @author ARA
 * @since 2023-07-05 PM 3:18
 */

package com.example.api.client;

import com.example.api.dto.BeerGetDto;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class BeerRestClient implements BeerClient {
    public BeerGetDto getBeer() {
        //  BeerRestService에 있는 코드를 가져오면 된다.
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://random-data-api.com/api/v2/beers";

        return restTemplate.getForObject(url, BeerGetDto.class);
    }

}
