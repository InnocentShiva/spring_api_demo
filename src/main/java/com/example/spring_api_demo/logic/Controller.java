package com.example.spring_api_demo.logic;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class Controller {
	
	@Autowired
	private TransactionHistoryRepository transactionHistoryRepository;

	@GetMapping("/transactions")
	public List<TransactionHistory> retreiveAllTransactions() throws Exception {
		List<TransactionHistory> employeeList = null;
		try {
			employeeList = transactionHistoryRepository.findAll();
			if(employeeList == null) {
				throw new NullPointerException("Inside retreiveAllTransactions no sign of a transaction!!");
			}

		}catch(Exception e) {
			e.getMessage();
		}
		return employeeList;
		
	}
	
	@GetMapping("/transactions/{transactionid}")
	public TransactionHistory retreiveEmployee(@PathVariable long transactionid) throws Exception {
		Optional<TransactionHistory> transactionHistory = transactionHistoryRepository.findById(transactionid);
		if(!transactionHistory.isPresent()) {
			throw new Exception("No student of the id"+transactionid+"is existed");
		}
		 return transactionHistory.get();
	}
	
	@DeleteMapping("/transactionid/{transactionid}")
	public void deleteEmployee(@PathVariable Long transactionid) {
		transactionHistoryRepository.deleteById(transactionid);
	}
	
	@PostMapping("/addtransaction")
	public ResponseEntity<Object> createEmployee(@RequestBody TransactionHistory transactionHistory){
		TransactionHistory transactionhistoryemployee = transactionHistoryRepository.save(transactionHistory);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(transactionhistoryemployee.getTransactionhistoryid()).toUri();
		
		System.out.println("Value of Location is : "+location);
		
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping("/updateemployee/{transactionhistoryid}")
	public ResponseEntity<Object> updateEmployee(@RequestBody TransactionHistory transactionHistory , @PathVariable long transactionhistoryid){
		Optional<TransactionHistory> employeeOptional = transactionHistoryRepository.findById(transactionhistoryid);
		
		if(!employeeOptional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		transactionHistory.setTransactionhistoryid(transactionhistoryid);
		transactionHistoryRepository.save(transactionHistory);
		
		return ResponseEntity.noContent().build();
	}
	
}
