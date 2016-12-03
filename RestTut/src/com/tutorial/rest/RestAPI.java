package com.tutorial.rest;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;

import com.tutorial.model.Details;
import com.tutorial.serviceImpl.APIServiceImpl;

@Path("/")
public class RestAPI {

	APIServiceImpl myImpl = new APIServiceImpl();

	@GET
	@Path("/details")
	@Produces("application/json")
	public Response allDetails() {
		GenericEntity<ArrayList<Details>> list = new GenericEntity<ArrayList<Details>>(myImpl.getDetails()) {};
		return Response.ok(list).build();
	}
	
	@POST
	@Path("/insert")
	@Consumes("application/xml")
	@Produces("application/json")
	public Response createDetail(Details details) {
		Details restDetail = myImpl.insertDetail(details.getFirstName(), details.getLastName(), details.getScore(), details.getAge());
		if( restDetail == null){
			return Response.ok("No Insert").build();
		}
		else{
			GenericEntity<Details> entityDetails = new GenericEntity<Details>(restDetail) {};
			return Response.ok(entityDetails).build();
		}	
	}
}
