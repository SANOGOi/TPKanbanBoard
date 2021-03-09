package servlet;

import domain.Kanban;
import jpa.EntityManagerHelper;
import dao.TabloDAO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

//TP5-Q5
@WebServlet(name="servlet_tabloKanba", urlPatterns = "/afficherTablo")
public class TabloInfo extends HttpServlet{
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse rep) throws ServletException, IOException {
        rep.setContentType("text/html");

        PrintWriter out = rep.getWriter();

        TabloDAO daoTab = new TabloDAO(EntityManagerHelper.getEntityManager());
        List<Kanban> listeTab = daoTab.fetchTablo();

        String dyn = "<h2>Liste des tableaux </h2>";
        dyn += "<table style = 'border-collapse:collapse; border:1px solid black;'>" +
                "<tr style = 'border-collapse:collapse; border:1px solid black;'>>" +
                "<th>Identifiant" +
                "</th>" +
                "<th>Nom projet" +
                "</th>"+
                "<th>Reference de section"+
                "</th>" +
                "</tr>" ;
        for(Kanban tab : listeTab) {
            dyn +=
                    "<tr style = 'border-collapse:collapse; border:1px solid black;'>>" +
                            "<td>" + tab.getId() +
                            "</td>" +
                            "<td>" + tab.getTitreProjet() +
                            "</td>" +
                            "<td>" + tab.getSections() +
                            "</td>" +
                            "</tr>";

        }
        dyn += "</table>";
        String html = "<html> " +
                "<body>" +
                dyn +
                "</body>" +
                "</html>";
        out.println(html);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse rep) throws ServletException, IOException {
        rep.setContentType("text/html");

        PrintWriter out = rep.getWriter();

        TabloDAO daoTab = new TabloDAO(EntityManagerHelper.getEntityManager());
        Kanban tab = new Kanban();
        tab.setTitreProjet(req.getParameter("titre"));
        daoTab.saveInDB(tab);

        out.println("Enregistrement effectué avec succès");
    }
}
