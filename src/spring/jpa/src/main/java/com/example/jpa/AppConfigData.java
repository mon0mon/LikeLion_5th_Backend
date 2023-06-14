/**
 * @project LikeLion_Backend
 * @author ARA on 2023-06-14 : AM 10:43
 */

package com.example.jpa;

import lombok.RequiredArgsConstructor;

public class AppConfigData {
    private final String connectionUrl;

    public AppConfigData(String connectionUrl) {
        this.connectionUrl = connectionUrl;
    }
}
