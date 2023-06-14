/**
 * @project LikeLion_Backend
 * @author ARA on 2023-06-14 : AM 9:48
 */

package com.example.jpa;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class AppRepository {
    //  데이터베이스와의 소통을 담당
    //  @Transactional

    public List<Object> selectStudentAll() {
        return new ArrayList<>();
    }
}
