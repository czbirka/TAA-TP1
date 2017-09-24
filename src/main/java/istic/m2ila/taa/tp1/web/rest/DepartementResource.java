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

import istic.m2ila.taa.tp1.dao.DepartementDAO;
import istic.m2ila.taa.tp1.domain.Departement;

@Path("/departement")
public class DepartementResource {

	private DepartementDAO departementDao = new DepartementDAO();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Departement> getAll() {
		return departementDao.findAll();
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getById(@PathParam("id") long id) {
		return (Response) departementDao.findOneById(id).map(e -> Response.ok().entity(e).build())
				.orElse(Response.status(Response.Status.NOT_FOUND).build());
	}

	@GET
	@Path("nom/{nom}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getByName(@PathParam("nom") String nom) {
		return (Response) departementDao.findOneByName(nom).map(e -> Response.ok().entity(e).build())
				.orElse(Response.status(Response.Status.NOT_FOUND).build());
	}

	@PUT
	@Path("{nom}")
	@Consumes({ MediaType.APPLICATION_JSON })
	public void create(@PathParam("nom") String nom) {
		Departement d = new Departement();
		d.setNom(nom);
		departementDao.create(d);
	}

	@POST
	@Path("{id}/{nom}")
	@Consumes({ MediaType.APPLICATION_JSON })
	public void update(@PathParam("id") long id, @PathParam("nom") String nom) {
		Optional<Departement> d = departementDao.findOneById(id);
		if (d.isPresent()) {
			Departement dd = d.get();
			dd.setNom(nom);
			departementDao.update(dd);
		}
	}
	
	@DELETE
	@Path("{id}")
	@Consumes({ MediaType.APPLICATION_JSON })
	public void delete(@PathParam("id") long id) {
		Optional<Departement> d = departementDao.findOneById(id);
		if (d.isPresent()) {
			Departement dd = d.get();
			departementDao.delete(dd);
		}
	}
	
}
