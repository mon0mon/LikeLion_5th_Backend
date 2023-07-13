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
//  사용자에게 요청의 처리 상태를 확인할 수 있는
//  JobId를 반환하는 용도의 DTO
//  Producer -> 사용자
//  사용자 -> Producer
public class JobTicket {
    private String jobId;
}
