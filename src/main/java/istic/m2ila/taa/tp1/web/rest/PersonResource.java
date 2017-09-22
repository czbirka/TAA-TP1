package istic.m2ila.taa.tp1.web.rest;

import java.util.List;
import java.util.Optional;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
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
		return personDao.findOneById(Long.parseLong(id)).map(e -> Response.ok().entity(e).build())
				.orElse(Response.status(Response.Status.NOT_FOUND).build());
	}

	@GET
	@Path("name/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getByName(@PathParam("name") String name) {
		return personDao.findOneByName(name).map(e -> Response.ok().entity(e).build())
				.orElse(Response.status(Response.Status.NOT_FOUND).build());
	}

	@PUT
	@Path("{name}/{firstname}")
	@Consumes({ MediaType.APPLICATION_JSON })
	public void create(@PathParam("name") String name, @PathParam("firstname") String firstname) {
		Person p = new Person();
		p.setName(name);
		p.setFirstname(firstname);
		personDao.create(p);
	}

	@POST
	@Path("{id}/{name}/{firstname}")
	@Consumes({ MediaType.APPLICATION_JSON })
	public void update(@PathParam("id") String id, @PathParam("name") String name,
			@PathParam("firstname") String firstname) {
		Optional<Person> p = personDao.findOneById(Long.parseLong(id));
		if (p.isPresent()) {
			Person pp = p.get();
			pp.setName(name);
			pp.setFirstname(firstname);
			personDao.update(pp);
		}
	}

	@POST
	@Path("{id}/{name}")
	@Consumes({ MediaType.APPLICATION_JSON })
	public void updateName(@PathParam("id") String id, @PathParam("name") String name)  {
		Optional<Person> p = personDao.findOneById(Long.parseLong(id));
		if (p.isPresent()) {
			Person pp = p.get();
			pp.setName(name);
			personDao.update(pp);
		}
	}
	
	@POST
	@Path("{id}//{firstname}")
	@Consumes({ MediaType.APPLICATION_JSON })
	public void updateFirstname(@PathParam("id") String id, 
			@PathParam("firstname") String firstname) {
		Optional<Person> p = personDao.findOneById(Long.parseLong(id));
		if (p.isPresent()) {
			Person pp = p.get();
			pp.setFirstname(firstname);
			personDao.update(pp);
		}
	}
	
	@DELETE
	@Path("{id}")
	@Consumes({ MediaType.APPLICATION_JSON })
	public void delete(@PathParam("id") String id) {
		Optional<Person> p = personDao.findOneById(Long.parseLong(id));
		if (p.isPresent()) {
			Person pp = p.get();
			personDao.delete(pp);
		}
	}

}
