package com.tutorial.service;

import java.util.List;

import com.tutorial.model.Details;

public interface APIService {
	public List<Details> getDetails();

	public Details insertDetail(String firstName, String lastName, String score, int age);
}
