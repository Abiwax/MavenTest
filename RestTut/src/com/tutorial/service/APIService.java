package com.tutorial.service;

import java.util.ArrayList;

import com.tutorial.model.Details;

public interface APIService {
	public ArrayList<Details> getDetails();

	public Details insertDetail(String firstName, String lastName, String score, int age);
}
