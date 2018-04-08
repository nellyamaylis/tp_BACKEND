package Servlet;
import domain.Personne;
import org.codehaus.jettison.json.JSONArray;
import service.PersonneDAO;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="person", urlPatterns={"/person"})
public class MyServlet extends HttpServlet {
    PersonneDAO daop;

    @Override
    public void init() throws ServletException {
        super.init();
        daop = new PersonneDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        PrintWriter p = new PrintWriter(resp.getOutputStream());
        JSONArray jsonListPersonnes = new JSONArray();
        for (Personne pe : daop.readAll()){
            p.println("<HTML>\n<BODY>\n" +
                    "<UL>\n" +
                    " <LI>Nom: " +pe.getNom() +"<BR>"+
                    " <LI>Prenom: "
                    + pe.getPrenom()+"<BR>"+
                    " <LI>Mail: "
                    + pe.getMail()+"<BR>"+
                    "</UL>\n" +
                            "</BODY></HTML>");
        }

        p.flush();

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        super.doPost(req, resp);
        System.out.println("La personne a bien créé !");
    }
}

