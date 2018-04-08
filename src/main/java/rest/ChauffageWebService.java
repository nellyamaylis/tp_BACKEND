package rest;

import domain.Chauffage;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import service.ChauffageDAO;
import service.ResidenceDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/Chauffage")
public class ChauffageWebService {

        ChauffageDAO daoch ;
        ResidenceDAO daore ;

    public ChauffageWebService() {
        daoch = new ChauffageDAO();
        daore = new ResidenceDAO();
    }

    @GET
        @Produces(MediaType.APPLICATION_JSON)
        public List<Chauffage> getAllChauffages() {
            return daoch.getChauffages();
        }

        @GET
        @Path("search/{id}")
        @Produces({ MediaType.APPLICATION_JSON })
        public Chauffage findById(@PathParam("id") Long id) {
            return daoch.getChauffageById(id);
        }

        @PUT
        @Path("create")
        @Produces({ MediaType.APPLICATION_JSON })
        public Chauffage createChauffage(String jsonStringChauffage) throws JSONException {
            JSONObject jsonChauffage = new JSONObject(jsonStringChauffage);
            Chauffage chauffage = new Chauffage();
            chauffage.setPower(jsonChauffage.getString("power"));
            chauffage.setConsommation(jsonChauffage.getInt("consommation"));
            chauffage.setResidence(daore.getResidenceById(jsonChauffage.getLong("id")));
            return daoch.create(chauffage);
        }
}
