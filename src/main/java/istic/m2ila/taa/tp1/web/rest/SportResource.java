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

import istic.m2ila.taa.tp1.dao.SportDAO;
import istic.m2ila.taa.tp1.domain.Sport;

@Path("/sport")
public class SportResource {

	private SportDAO sportDAO = new SportDAO();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Sport> getAll() {
		return sportDAO.findAll();
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getById(@PathParam("id") long id) {
		return (Response) sportDAO.findOneById(id).map(e -> Response.ok().entity(e).build())
				.orElse(Response.status(Response.Status.NOT_FOUND).build());
	}

	@GET
	@Path("nom/{nom}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getByName(@PathParam("nom") String nom) {
		return (Response) sportDAO.findOneByName(nom).map(e -> Response.ok().entity(e).build())
				.orElse(Response.status(Response.Status.NOT_FOUND).build());
	}

	@PUT
	@Path("{nom}")
	@Consumes({ MediaType.APPLICATION_JSON })
	public void create(@PathParam("nom") String nom) {
		Sport s = new Sport();
		s.setNom(nom);
		sportDAO.create(s);
	}

	@POST
	@Path("{id}/{nom}")
	@Consumes({ MediaType.APPLICATION_JSON })
	public void update(@PathParam("id") long id, @PathParam("nom") String nom) {
		Optional<Sport> s = sportDAO.findOneById(id);
		if (s.isPresent()) {
			Sport ss = s.get();
			ss.setNom(nom);
			sportDAO.update(ss);
		}
	}

	@DELETE
	@Path("{id}")
	@Consumes({ MediaType.APPLICATION_JSON })
	public void delete(@PathParam("id") long id) {
		Optional<Sport> s = sportDAO.findOneById(id);
		if (s.isPresent()) {
			Sport ss = s.get();
			sportDAO.delete(ss);
		}
	}

}
