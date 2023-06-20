/**
 * @project LikeLion_Backend
 * @author ARA
 * @since 2023-06-20 0020 : PM 2:37
 */

package com.example.http;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class ServletController {
    @PostMapping("/servlet")
    public void servletHandling(HttpServletRequest request, HttpServletResponse response)
        throws IOException {
        BufferedReader br = request.getReader();
        br.lines().forEach(line -> log.info(line));
        response.setStatus(200);
    }
}
