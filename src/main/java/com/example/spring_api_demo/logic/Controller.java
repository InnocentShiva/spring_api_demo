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

	@GetMapping("/employees")
	public List<TransactionHistory> retreiveAllEmployees() throws Exception {
		List<TransactionHistory> employeeList = null;
		try {
			employeeList = transactionHistoryRepository.findAll();
			if(employeeList == null) {
				throw new NullPointerException("Inside retreiveAllEmployees no sign of employees!!");
			}

		}catch(Exception e) {
			e.getMessage();
		}
		return employeeList;
		
	}
	
	@GetMapping("/employees/{id}")
	public TransactionHistory retreiveEmployee(@PathVariable long employeeid) throws Exception {
		Optional<TransactionHistory> transactionHistory = transactionHistoryRepository.findById(employeeid);
		if(!transactionHistory.isPresent()) {
			throw new Exception("No student of the id"+employeeid+"is existed");
		}
		 return transactionHistory.get();
	}
	
	@DeleteMapping("/employees/{id}")
	public void deleteEmployee(@PathVariable Long id) {
		transactionHistoryRepository.deleteById(id);
	}
	
	@PostMapping("/addemployee")
	public ResponseEntity<Object> createEmployee(@RequestBody TransactionHistory transactionHistory){
		TransactionHistory transactionhistoryemployee = transactionHistoryRepository.save(transactionHistory);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(transactionhistoryemployee.getEmployeeid()).toUri();
		
		System.out.println("Value of Location is : "+location);
		
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping("/updateemployee/{id}")
	public ResponseEntity<Object> updateEmployee(@RequestBody TransactionHistory transactionHistory , @PathVariable long id){
		Optional<TransactionHistory> employeeOptional = transactionHistoryRepository.findById(id);
		
		if(!employeeOptional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		transactionHistory.setEmployeeid(id);
		transactionHistoryRepository.save(transactionHistory);
		
		return ResponseEntity.noContent().build();
	}
	
}
