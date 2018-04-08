package rest;

import domain.Chauffage;
import domain.Equipement;
import domain.Personne;
import domain.Residence;
import service.PersonneDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/hello")
public class SampleWebService {

    PersonneDAO dao;

    public SampleWebService(){

        dao = new PersonneDAO();
    }
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello() {
        return "Hello, how are you?";
    }

    @GET
    @Path("/titi")
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello1() {
        return "Coucou";
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findPerson(@PathParam("id") long id) {
        Personne p = dao.read(id);
        return Response.status(200).entity("name : " + p.getNom() + ", prenom : " + p.getPrenom() + ", mail" + p.getMail()).build();

    }

    /*@POST
    @Path("/person")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Personne createPerson(Personne p) {
            return dao.create(p);
    }*/

    @GET
    @Path("/residence")
    @Produces({MediaType.APPLICATION_JSON})
    public Residence getHome() {
        Residence h = new Residence();
        h.setId(1);
        h.setTaille(450);
        h.setNb_pieces(6);
        Chauffage h1 = new Chauffage();
        h1.setId(1);
        h1.setPower("500w");
        h1.setName("Chauffage1");
        h1.setResidence(h);
        Chauffage h2 = new Chauffage();
        h2.setId(2);
        h2.setName("Chauffage2");
        h2.setPower("600w");
        h2.setResidence(h);
        h.addChauffage(h1);
        h.addChauffage(h2);
        return h;

    }
    @GET
    @Path("/equipement")
    @Produces(MediaType.APPLICATION_JSON)
    public Equipement findEquipement() {
        Equipement eq = new Equipement();
        eq.setId(1);
        eq.setName("montre");
        eq.setWatts(10);
        return eq;
    }
}

