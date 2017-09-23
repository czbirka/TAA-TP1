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

import istic.m2ila.taa.tp1.dao.RegionDAO;
import istic.m2ila.taa.tp1.domain.Region;

@Path("/region")
public class RegionResource {
	
	private RegionDAO regionDao = new RegionDAO();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Region> getAll() {
		return regionDao.findAll();
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getById(@PathParam("id") long id) {
		return (Response) regionDao.findOneById(id).map(e -> Response.ok().entity(e).build())
				.orElse(Response.status(Response.Status.NOT_FOUND).build());
	}

	@GET
	@Path("nom/{nom}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getByName(@PathParam("nom") String nom) {
		return (Response) regionDao.findOneByName(nom).map(e -> Response.ok().entity(e).build())
				.orElse(Response.status(Response.Status.NOT_FOUND).build());
	}
	
	@PUT
	@Path("{nom}")
	@Consumes({ MediaType.APPLICATION_JSON })
	public void create(@PathParam("nom") String nom) {
		Region r = new Region();
		r.setNom(nom);
		regionDao.create(r);
	}
	
	@POST
	@Path("{id}/{nom}")
	@Consumes({ MediaType.APPLICATION_JSON })
	public void updateName(@PathParam("id") long id, @PathParam("nom") String nom) {
		Optional<Region> r = regionDao.findOneById(id);
		if (r.isPresent()) {
			Region rr = r.get();
			rr.setNom(nom);
			regionDao.update(rr);
		}
	}
	
	@DELETE
	@Path("{id}")
	@Consumes({ MediaType.APPLICATION_JSON })
	public void delete(@PathParam("id") long id) {
		Optional<Region> r = regionDao.findOneById(id);
		if (r.isPresent()) {
			Region rr = r.get();
			regionDao.delete(rr);
		}
	}
	
}
