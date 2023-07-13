/**
 * @project LikeLion_Backend
 * @author ARA
 * @since 2023-07-12 PM 2:22
 */

package com.example.producer.dto;

import lombok.Data;

@Data
//  사용자가 인코딩 요청을 보내는 DTO
//  사용자 -> Producer
public class JobRequest {
    private String filename;
}
