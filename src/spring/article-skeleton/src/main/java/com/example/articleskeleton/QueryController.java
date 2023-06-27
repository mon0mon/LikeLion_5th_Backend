/**
 * @project LikeLion_Backend
 * @author ARA
 * @since 2023-06-22 0022 : PM 2:03
 */

package com.example.articleskeleton;

import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class QueryController {
    //  GET /path?query=keyword&limit=20
    @GetMapping("/path")
    public Map<String, Object> queryParams(
//        @RequestParam("query") String query,
//        @RequestParam("limit") Integer limit
        @RequestParam("query") String query,
        @RequestParam(value = "limit", defaultValue = "10") Integer limit
    ) {
        log.info("query=" + query);
        log.info("limit=" + limit);

        Map<String, Object> response = new HashMap<>();
        response.put("query", query);
        response.put("limit", limit);
        return response;
    }
}
