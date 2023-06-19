/**
 * @project LikeLion_Backend
 * @author ARA
 * @since 2023-06-19 : PM 2:38
 */

package com.example.http;

import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@Slf4j
@Controller
public class HeaderController {
    @PostMapping("/header-one")
    public String getHeader(@RequestHeader("x-likelion")String header) {
        log.info("POST /header-one (x-likelion=" + header + ")");
        return "index";
    }

    @PostMapping("/header-optional")
    public String getHeaderOptional(@RequestHeader(value = "x-likelion", required = false)String header) {
        log.info("POST /header-optional (x-likelion=" + header + ")");
        return "index";
    }

    @PostMapping("/header-type")
    public String getHeaderInteger(@RequestHeader("x-likelion")Integer header) {
        log.info("POST /header-type (x-likelion=" + header + ")");
        return "index";
    }

    @PostMapping("/header-all")
    public String getHeaderAll(@RequestHeader Map<String, String> headerMap) {
        log.info("POST /header-all");
        headerMap.entrySet()
            .forEach(entry -> log.info(String.format("%s : %s", entry.getKey(), entry.getValue())));
        return "index";
    }
}
