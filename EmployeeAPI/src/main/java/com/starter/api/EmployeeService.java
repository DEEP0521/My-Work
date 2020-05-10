package com.starter.api;

import java.util.*;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository empr;
	
	@PostConstruct
	public void initPatients() {
		empr.saveAll(new ArrayList<EmpModel>(Arrays.asList(new EmpModel(113,"Katie Taylor","kat@mail.com","London"),
															   new EmpModel(111,"Katie singh","sin@mail.com","UAE"),
															   new EmpModel(112,"Peter Smith","pet@mail.com","UK"))));
	}
	
	//fetches all student
	public List<EmpModel> listAll(){
		final List<EmpModel> emp=new ArrayList<EmpModel>();
		empr.findAll().forEach(em->emp.add(em));
		return emp;
	}
	
	//saves employee record
	public void save(EmpModel eml) {
		empr.save(eml);
	}	
	
	//fetches record by id
	public EmpModel get(int id) {
		return empr.findById(id).get();
	}
	
	public void deleteE(int id) {
		empr.deleteById(id);
	}
	
	public void updateE(EmpModel em,int id) {
		empr.save(em);
	}
}
