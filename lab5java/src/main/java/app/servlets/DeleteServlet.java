package app.servlets;

import app.model.JavaMySql;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("    <title>Table Mysql</title>");
        out.println("    <link rel=\"stylesheet\" href=\"css/bootstrap-reboot.min.css\">");
        out.println("    <link rel=\"stylesheet\" href=\"css/bootstrap-grid.min.css\">");
        out.println("    <link rel=\"stylesheet\" href=\"css/bootstrap.min.css\">");
        out.println("    <link rel=\"stylesheet\" href=\"css/style.css\">");
        out.println("");
        out.println("    <script src=\"js/jquery.js\"></script>");
        out.println("</head>");
        out.println("<body>");
        out.println("<section>" + "<form>" + "<fieldset>" + "<button onclick=" + "\"window.location.href ='http://localhost:8080/lab5java_war_exploded/'\"" +  "type=\"button\" id=\"\" class=\"btn btn-success\">Main Page</button>" + "</fieldset>" + "</form>" + "</section>");



        out.println("</body>");
        out.println("</html>");
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {

            String id = request.getParameter("idDeleterow");
            try {
                JavaMySql.DeleteRow(id);
            }
            catch (Exception ex){
                ex.printStackTrace();
            }


            PrintWriter out = response.getWriter();

            out.println("<html>");
            out.println("<head>");
            out.println("    <title>Table Mysql</title>");
            out.println("    <link rel=\"stylesheet\" href=\"css/bootstrap-reboot.min.css\">");
            out.println("    <link rel=\"stylesheet\" href=\"css/bootstrap-grid.min.css\">");
            out.println("    <link rel=\"stylesheet\" href=\"css/bootstrap.min.css\">");
            out.println("    <link rel=\"stylesheet\" href=\"css/style.css\">");
            out.println("");
            out.println("    <script src=\"js/jquery.js\"></script>");
            out.println("</head>");
            out.println("<body>");
            out.println("<section>"+"<span>" +"Successfully deleted! " + JavaMySql.JAVASQLLength()+"</span>"+"</section>") ;
            out.println("<section>" + "<form>" + "<fieldset>" + "<button onclick=" + "\"window.location.href ='http://localhost:8080/lab5java_war_exploded/'\"" +  "type=\"button\" id=\"\" class=\"btn btn-success\">Main Page</button>" + "</fieldset>" + "</form>" + "</section>");



            out.println("</body>");
            out.println("</html>");



        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

}
