package com.tutorial.rest;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import com.tutorial.model.Details;
import com.tutorial.serviceImpl.APIServiceImpl;

@RestController
@EnableWebMvc
@RequestMapping("/rest")
public class RestAPI {
	@Autowired
	APIServiceImpl myImpl;

	@RequestMapping(value="/details", method=RequestMethod.GET)
	public @ResponseBody List<Details> allDetails(){
		return myImpl.getDetails();
	}


	@RequestMapping(value = "/insert", method = RequestMethod.POST)
    public Details createDetail(@RequestBody Map<String, String> json) {
		String firstName = json.get("firstname");
		String lastName = json.get("lastname");
		String score = json.get("score");
		String age = json.get("age");
		Details restDetail = myImpl.insertDetail(firstName, lastName, score, Integer.parseInt(age));
        return restDetail;
    }
	
	
}

