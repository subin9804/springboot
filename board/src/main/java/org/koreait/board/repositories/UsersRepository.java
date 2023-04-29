package org.koreait.board.repositories;

import org.koreait.board.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface UsersRepository extends JpaRepository<Users,Long>, QuerydslPredicateExecutor<Users> {
    Users findByUserId(String userId);
}
