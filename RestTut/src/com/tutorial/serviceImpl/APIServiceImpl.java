package com.tutorial.serviceImpl;

import java.util.ArrayList;

import com.tutorial.dao.DetailsDAO;
import com.tutorial.model.Details;
import com.tutorial.service.APIService;

public class APIServiceImpl implements APIService{

	
	DetailsDAO myDAO = new DetailsDAO();
	@Override
	public ArrayList<Details> getDetails() {
		// TODO Auto-generated method stub
		return myDAO.getDetails();
	}

	@Override
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
