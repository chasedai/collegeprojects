package com.ait.motors;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/motors")
public class MotorsResource {

	MotorsDAO dao = new MotorsDAO();
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Motors> findAll() {
		System.out.println("findAll");
		return dao.findAll();
	}
	
	@GET @Path("{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Motors findById(@PathParam("id") String id) {
		System.out.println("findById"+id);
		return dao.findById(Integer.parseInt(id));
	}
	
	@GET @Path("pic/{make}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Motors findByMake(@PathParam("make") String make) {
		System.out.println("findByMake"+make);
		return dao.findByMake(make);
	}
	
	@DELETE @Path("{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public void remove(@PathParam("id") int id){
		dao.remove(id);
		
	}
	
	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Motors create(Motors motors){
		System.out.println("creating motors record");
		return dao.create(motors);
	}
	
	@PUT @Path("{id}")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Motors update(Motors motors){
		System.out.println("updating motors: "+ motors.getMake());
		dao.update(motors);
		return motors;
	}
	
	
	@GET @Path("/search/{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Motors> Search(@PathParam("id") String id){
		System.out.println("Searching for: " + id);
		return dao.Search(id);	
	}


}