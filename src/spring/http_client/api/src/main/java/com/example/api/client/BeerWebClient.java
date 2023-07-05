/**
 * @project LikeLion_Backend
 * @author ARA
 * @since 2023-07-05 PM 3:28
 */

package com.example.api.client;

import com.example.api.dto.BeerGetDto;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
@Primary
public class BeerWebClient implements BeerClient {
    public BeerGetDto getBeer() {
        WebClient webClient = WebClient.builder().build();

        String url = "https://random-data-api.com/api/v2/beers";

        return webClient.get()
            .uri(url)
            .retrieve()
            .bodyToMono(BeerGetDto.class)
            .block();
    }
}
