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

import istic.m2ila.taa.tp1.dao.LieuDAO;
import istic.m2ila.taa.tp1.dao.PersonDAO;
import istic.m2ila.taa.tp1.domain.Lieu;
import istic.m2ila.taa.tp1.domain.Person;

@Path("/lieu")
public class LieuResource {

	private LieuDAO lieuDao = new LieuDAO();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Lieu> getAll() {
		return lieuDao.findAll();
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getById(@PathParam("id") long id) {
		return (Response) lieuDao.findOneById(id).map(e -> Response.ok().entity(e).build())
				.orElse(Response.status(Response.Status.NOT_FOUND).build());
	}

	@GET
	@Path("name/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getByName(@PathParam("name") String name) {
		return (Response) lieuDao.findOneByName(name).map(e -> Response.ok().entity(e).build())
				.orElse(Response.status(Response.Status.NOT_FOUND).build());
	}

	@PUT
	@Path("{nom}/{latitude}/{longitude}")
	@Consumes({ MediaType.APPLICATION_JSON })
	public void create(@PathParam("nom") String nom, @PathParam("latitude") double latitude,
			@PathParam("longitude") double longitude) {
		Lieu l = new Lieu();
		l.setNom(nom);
		l.setLatitude(latitude);
		l.setLongitude(longitude);
		lieuDao.create(l);
	}

	@POST
	@Path("{id}/{nom}/{latitude}/{longitude}")
	@Consumes({ MediaType.APPLICATION_JSON })
	public void update(@PathParam("id") long id, @PathParam("nom") String nom, @PathParam("latitude") double latitude,
			@PathParam("longitude") double longitude) {
		Optional<Lieu> l = lieuDao.findOneById(id);
		if (l.isPresent()) {
			Lieu ll = l.get();
			ll.setNom(nom);
			ll.setLatitude(latitude);
			ll.setLongitude(longitude);
			lieuDao.update(ll);
		}
	}

	@POST
	@Path("{id}/{nom}")
	@Consumes({ MediaType.APPLICATION_JSON })
	public void updateName(@PathParam("id") long id, @PathParam("nom") String nom) {
		Optional<Lieu> l = lieuDao.findOneById(id);
		if (l.isPresent()) {
			Lieu ll = l.get();
			ll.setNom(nom);
			lieuDao.update(ll);
		}
	}

	@POST
	@Path("{id}//{latitude}")
	@Consumes({ MediaType.APPLICATION_JSON })
	public void updateFirstname(@PathParam("id") long id, @PathParam("latitude") double latitude) {
		Optional<Lieu> l = lieuDao.findOneById(id);
		if (l.isPresent()) {
			Lieu ll = l.get();
			ll.setLatitude(latitude);
			lieuDao.update(ll);
		}
	}
	
	@POST
	@Path("{id}///{longitude}")
	@Consumes({ MediaType.APPLICATION_JSON })
	public void update(@PathParam("id") long id, @PathParam("longitude") double longitude) {
		Optional<Lieu> l = lieuDao.findOneById(id);
		if (l.isPresent()) {
			Lieu ll = l.get();
			ll.setLongitude(longitude);
			lieuDao.update(ll);
		}
	}
	
	@DELETE
	@Path("{id}")
	@Consumes({ MediaType.APPLICATION_JSON })
	public void delete(@PathParam("id") long id) {
		Optional<Lieu> l = lieuDao.findOneById(id);
		if (l.isPresent()) {
			Lieu ll = l.get();
			lieuDao.delete(ll);
		}
	}

}
