package rest;


import domain.Personne;
import domain.Residence;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import service.PersonneDAO;
import service.ResidenceDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/Personne")
public class PersonneWebService {

    PersonneDAO daop;
    ResidenceDAO daor;

    public PersonneWebService() {
        daop = new PersonneDAO();
        daor = new ResidenceDAO();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Personne> getAllPersonnes(){
        return daop.readAll();
    }

    @GET
    @Path("search/{id}")
    @Produces({ MediaType.APPLICATION_JSON })
    public Personne findById(@PathParam("id") long id) {
        return daop.read(id);
    }

    @PUT
    @Path("create")
    @Produces({ MediaType.APPLICATION_JSON })
    public Personne create(String jsonStringPerson) throws JSONException {
        List<Residence> residences = new ArrayList<Residence>();

        JSONObject jsonPerson = new JSONObject(jsonStringPerson);
        JSONArray jsonResidences = jsonPerson.getJSONArray("residencesChecked");
        for(int i = 0; i < jsonResidences.length(); i++){
            Residence r = daor.getResidenceById(jsonResidences.getJSONObject(i).getLong("id"));
            residences.add(r);
        }
        Personne pers = new Personne();
        pers.setNom(jsonPerson.getString("nom"));
        pers.setPrenom(jsonPerson.getString("prenom"));
        pers.setMail(jsonPerson.getString("mail"));
        pers.setResidences(residences);
        return daop.create(pers);
    }

}
