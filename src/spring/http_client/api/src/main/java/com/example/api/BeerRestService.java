/**
 * @project LikeLion_Backend
 * @author ARA
 * @since 2023-07-05 PM 1:07
 */

package com.example.api;

import com.example.api.dto.BeerGetDto;
import com.example.api.dto.BeerPostDto;
import com.example.api.dto.MessageDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
//@RequiredArgsConstructor
public class BeerRestService {
//    private final RestTemplate restTemplate;

    //  getForObject -> 다른 거 필요없고, 응답 Body만 있으면 될 때
    public void getBeerObject() {
        //  RestTemplate: Spring에서 제공하는 기본 HTTP Client
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://random-data-api.com/api/v2/beers";

//        //  RestTemplate으로 GET 요청
//        String responseBody = restTemplate.getForObject(url, String.class);
//        log.info(responseBody);

        //  @RequestBody, @ResponseBody => JSON -> DTO
        BeerGetDto responseBody = restTemplate.getForObject(url, BeerGetDto.class);
        log.info(responseBody.toString());
    }

    //  STATUS LINE
    //  RESPONSE HEADER
    //  RESPONSE BODY
    //  HTTP 응답 전체 확인
    public void getBeerEntity() {
        //  RestTemplate: Spring에서 제공하는 기본 HTTP Client
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://random-data-api.com/api/v2/beers";

        //  RestController
        ResponseEntity<BeerGetDto> response = restTemplate.getForEntity(url, BeerGetDto.class);
        log.info(response.getStatusCode().toString());
        log.info(response.getHeaders().toString());
        log.info(response.getBody().toString());
    }

    //  postForObject
    public void postBeerObject() {
        //  RestTemplate: Spring에서 제공하는 기본 HTTP Client
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8081/give-me-beer";

        BeerPostDto dto = new BeerPostDto();
        dto.setName("Stella Artois");
        dto.setCc(2000L);
        dto.setAlcohol(5.0);

        //  post 요청을 보낼 때 requestBody를 같이 전달
        MessageDto responseBody = restTemplate.postForObject(url, dto, MessageDto.class);
        log.info(responseBody.toString());

        //  응답 Body 없이 응답하는 URL
        url = "http://localhost:8081/give-me-beer-204";
        ResponseEntity<Void> response = restTemplate.postForEntity(url, dto, Void.class);
        log.info(response.getStatusCode().toString());
//        restTemplate.exchange(url, HttpMethod.POST,
//            new HttpEntity<>(dto), Void.class);
    }
}
