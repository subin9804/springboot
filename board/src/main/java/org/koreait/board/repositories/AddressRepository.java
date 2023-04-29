package org.koreait.board.repositories;

import org.koreait.board.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface AddressRepository extends JpaRepository<Address, Long>, QuerydslPredicateExecutor {
    
}
