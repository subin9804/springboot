package org.koreait.repositories;

import org.koreait.entities.PostData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostDataRepository extends JpaRepository<PostData, Long> { // <entity class, entity의 기본키 타입>

}
