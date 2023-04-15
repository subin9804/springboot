package org.koreait.jpa_exam;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.koreait.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
@Transactional
public class Exam01Test {

    @Autowired
    private EntityManager em;

    @Test
    @DisplayName("연습1")
    public void exam01() {
        UserEntity entity  = new UserEntity();  // New (비영속 상태) - 객체만 생성한 상태
        entity.setUserNo(1L);
        entity.setUserId("user01");
        entity.setUserPw("123456");
        entity.setUserNm("사용자01");
        entity.setRegDt(LocalDateTime.now());

        em.persist(entity); // Managed(영속 상태) - 변화 감지
        em.flush();

        entity.setUserNm("(수정)사용자01"); // 수정 - 변화 감지 -> update쿼리 샐행
        em.flush();

        em.detach(entity);  // 영속 상태 분리 - 변화 감지 X

        entity.setUserNm("(수정2)사용자01");
        em.flush();


        // find 조회시 자동으로 조회 전에 flush()가 실행된다.
        UserEntity entity2 = em.find(UserEntity.class, 1L);
        System.out.println(entity2);

        em.merge(entity);
        entity.setUserNm("(수정2)사용자01");

        em.flush();

        UserEntity entity3 = em.find(UserEntity.class, 1L);
        System.out.println(entity3);

        em.remove(entity3);
        em.flush();

    }
}
