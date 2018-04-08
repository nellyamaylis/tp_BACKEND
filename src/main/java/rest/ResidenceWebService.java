package rest;

import domain.Residence;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import service.ResidenceDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/residence")
public class ResidenceWebService {
        ResidenceDAO daores = new ResidenceDAO();
        @GET
        @Produces(MediaType.APPLICATION_JSON)
        public List<Residence> getAllHomes() {
            return daores.getResidences();
        }

        @GET
        @Path("search/{id}")
        @Produces({ MediaType.APPLICATION_JSON })
        public Residence findById(@PathParam("id") Long id) {
            return daores.getResidenceById(id);
        }

        @PUT
        @Path("create")
        @Produces({ MediaType.APPLICATION_JSON })
        public Residence createHome(String jsonStringResidence) throws JSONException {
            JSONObject jsonHome = new JSONObject(jsonStringResidence);
            Residence residence = new Residence();
            residence.setTaille(jsonHome.getInt("taille"));
            residence.setNb_pieces(jsonHome.getInt("nb_pieces"));
            return daores.create(residence);
        }
}
