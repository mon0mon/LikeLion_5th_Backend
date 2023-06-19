/**
 * @project LikeLion_Backend
 * @author ARA
 * @since 2023-06-19 : PM 1:32
 */

package com.example.http;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MappingController {

    private static final Logger log = LoggerFactory.getLogger(MappingController.class);

    @RequestMapping(value = "/path", method = RequestMethod.GET)
    public String getPath() {
        log.info("GET /path");
        return "index";
    }

    @RequestMapping(value = "/path", method = RequestMethod.POST)
    public String postPath() {
        log.info("POST /path");
        return "index";
    }

    @RequestMapping(value = "/path", method = RequestMethod.PUT)
    public String putPath() {
        log.info("PUT /path");
        return "index";
    }

    @RequestMapping(value = "/path", method = RequestMethod.DELETE)
    public String deletePath() {
        log.info("DELETE /path");
        return "index";
    }

    @RequestMapping(value = "/consume", method = RequestMethod.POST)
    public String consumes() {
        log.info("POST /path with x-likelion");
        return "index";
    }

    @RequestMapping(value = "/path", method = RequestMethod.POST, headers = "x-likelion=hello")
    public String headerWith() {
        log.info("POST /path with x-likelion=hello");
        return "index";
    }

    @RequestMapping(value = "/path", method = RequestMethod.POST, params = "likelion=hello")
    public String params() {
        log.info("POST /path with parameter likelion");
        return "index";
    }
}
