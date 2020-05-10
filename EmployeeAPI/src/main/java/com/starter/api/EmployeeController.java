package com.starter.api;

import java.util.List;
import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService ems;
	
	@GetMapping("/employees")
	public List<EmpModel> list(){
		return ems.listAll();
	}
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<EmpModel> get(@PathVariable int id) {
		try {
			
			EmpModel emp = ems.get(id);
			return new ResponseEntity<EmpModel>(emp,HttpStatus.OK);
			
		}catch(NoSuchElementException e) {
			return new ResponseEntity<EmpModel>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping(path = "/employees",consumes = "application/json")
	public int add(final @RequestBody @Valid EmpModel wmp) {
		ems.save(wmp);
		return wmp.getEmpId();
	}
	
	@DeleteMapping("/employees/{id}")
	public void remove(@PathVariable Integer id) {
		ems.deleteE(id);
	}
	
	@PutMapping("/employees/{id}")
	public EmpModel updateEmp(@RequestBody EmpModel emp,int id) {
		ems.updateE(emp,id);
		return emp;
	}
	
}
