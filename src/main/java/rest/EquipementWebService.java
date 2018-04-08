package rest;

import domain.Equipement;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import service.EquipementDAO;
import service.ResidenceDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

    @Path("/equipement")
    public class EquipementWebService {
        EquipementDAO daoeq;
        ResidenceDAO daoresi;

        public EquipementWebService() {
            daoeq = new EquipementDAO();
            daoresi = new ResidenceDAO();
        }

        @GET
        @Produces(MediaType.APPLICATION_JSON)
        public List<Equipement> getAllEquip() {
            return daoeq.getEquipements();
        }

        @GET
        @Path("search/{id}")
        @Produces({ MediaType.APPLICATION_JSON })
        public Equipement findById(@PathParam("id") long id) {
            return daoeq.getEquipementById(id);
        }

        @PUT
        @Path("create")
        @Produces({ MediaType.APPLICATION_JSON })
        public Equipement create(String jsonStringEquip) throws JSONException {
            JSONObject jsonEquip = new JSONObject(jsonStringEquip);
            Equipement eq = new Equipement();
            eq.setConsommation(jsonEquip.getInt("consommation"));
            eq.setNom(jsonEquip.getString("nom"));
            eq.setResidence(daoresi.getResidenceById(jsonEquip.getLong("id")));
            return daoeq.create(eq);
        }
    }
