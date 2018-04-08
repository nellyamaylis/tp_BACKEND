package Servlet;

import domain.Personne;
import service.PersonneDAO;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="userinfo",
        urlPatterns={"/UserInfo"})


public class UserInfo extends HttpServlet {
//    PersonneDAO daope;
//    @Override
//    public void init() throws ServletException {
//        super.init();
//        daope = new PersonneDAO();
//    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        //Personne p = new Personne();
        //p.setNom(request.getParameter("name"));
        //p.setPrenom(request.getParameter("firstname"));
        //p.setMail(request.getParameter("mail"));
        //daope.create(p);
        out.println("<HTML>\n<BODY>\n" +
                "<H1>Recapitulatif des informations</H1>\n" + "<H2>Données ajoutées à la base de données</H2>\n"+
                "<UL>\n" +
                " <LI>Nom: "
                + request.getParameter("name") + "\n" +
                " <LI>Prenom: "
                + request.getParameter("firstname") + "\n" +
                " <LI>Mail: "
                + request.getParameter("mail") + "\n" +
                "</UL>\n" +
                "</BODY></HTML>");
    }

}
