package istic.m2ila.taa.tp1.web.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import istic.m2ila.taa.tp1.dao.PersonDAO;
import istic.m2ila.taa.tp1.domain.Person;

@Path("/person")
public class PersonResource {

	private PersonDAO personDao = new PersonDAO();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Person> getAll() {
		return personDao.findAll();
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getById(@PathParam("id") String id) {
		return personDao.findOneById(Long.parseLong(id))
				.map(e -> Response.ok().entity(e).build())
				.orElse(Response.status(Response.Status.NOT_FOUND).build());
	}
	
	@GET
	@Path("name/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getByName(@PathParam("name") String name) {
		return personDao.findOneByName(name)
				.map(e -> Response.ok().entity(e).build())
				.orElse(Response.status(Response.Status.NOT_FOUND).build());
	}

}
