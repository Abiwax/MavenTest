package com.tutorial.serviceImpl;

import java.util.List;

import com.tutorial.dao.DetailsDAO;
import com.tutorial.model.Details;
import com.tutorial.service.APIService;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
@Component
public class APIServiceImpl implements APIService{

	
	DetailsDAO myDAO = new DetailsDAO();
	
	public List<Details> getDetails() {
		// TODO Auto-generated method stub
		return myDAO.getDetails();
	}

	public Details insertDetail(String firstName, String lastName, String score, int age) {
		// TODO Auto-generated method stub
		Details newDetails = new Details(firstName, lastName, score, age);
		int num = myDAO.insertDetails(newDetails);
		if (num == 0){
			return null;
		}
		else{
			return newDetails;
		}
		
	}

	

}
