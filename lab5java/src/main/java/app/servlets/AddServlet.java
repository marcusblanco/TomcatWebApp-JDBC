package app.servlets;

import app.model.JavaMySql;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/add")
public class AddServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("    <title>Info</title>");
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

            String name = request.getParameter("personName");
            int eng = Integer.parseInt(request.getParameter("personEngScore"));
            int math = Integer.parseInt(request.getParameter("personMathScore"));
            int phys = Integer.parseInt(request.getParameter("personPhysScore"));
            System.out.println("worked");
            JavaMySql.NewData(name,math,eng,phys);

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
            out.println("<section>"+"<span>" +"Successfully added! " + JavaMySql.JAVASQLLength()+"</span>"+"</section>") ;
            out.println("<section>" + "<form>" + "<fieldset>" + "<button onclick=" + "\"window.location.href ='http://localhost:8080/lab5java_war_exploded/'\"" +  "type=\"button\" id=\"\" class=\"btn btn-success\">Main Page</button>" + "</fieldset>" + "</form>" + "</section>");



            out.println("</body>");
            out.println("</html>");



        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    }
