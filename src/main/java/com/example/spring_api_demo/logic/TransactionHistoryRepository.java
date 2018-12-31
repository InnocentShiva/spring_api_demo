package com.example.spring_api_demo.logic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionHistoryRepository extends JpaRepository<TransactionHistory,Long> {
	
	TransactionHistory findBySenderemployeename(String name);

}
