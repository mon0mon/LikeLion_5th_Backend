/**
 * @project LikeLion_Backend
 * @author ARA
 * @since 2023-07-05 PM 3:31
 */

package com.example.api.client;

import com.example.api.dto.BeerGetDto;

public interface BeerClient {
    BeerGetDto getBeer();
}
