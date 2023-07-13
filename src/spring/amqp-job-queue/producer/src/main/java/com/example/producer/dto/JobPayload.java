/**
 * @project LikeLion_Backend
 * @author ARA
 * @since 2023-07-12 PM 2:22
 */

package com.example.producer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
//  Producer가 발생시킬 Job을 정의한 DTO
//  Producer -> RabbitMQ
public class JobPayload {
    private String jobId;
    private String filename;
    private String path;
}
