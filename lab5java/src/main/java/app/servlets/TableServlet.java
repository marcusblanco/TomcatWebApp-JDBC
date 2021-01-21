package app.servlets;

import app.model.JavaMySql;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;




@WebServlet("/table")
public class TableServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int count = JavaMySql.JAVASQLLength();

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
        out.println("<form action=\"/lab5java_war_exploded/delete\" method=\"post\">");
        out.println("                    <fieldset>");
        out.println("");
        out.println("                        <legend><span id=\"red1\">*</span> Type id of the row to delete</legend>");
        out.println("                        <hr>");
        out.println("                        <input type=\"text\" class=\"form-control\" name=\"idDeleterow\" placeholder=\"Type the id\" >");
        out.println("                        <br>");
        out.println("                        <button type=\"submit\" id=\"create\" class=\"btn btn-success\">Delete</button>");
        out.println("                    </fieldset>");
        out.println("                </form>");
        out.println("<section>");
        out.println("    <div class=\"container\">");
        out.println("        <div class=\"row\">");
        out.println("            <div class=\"tablesect\">");
        out.println("");
        out.println("                <h4 style=\"margin: 5px auto; text-align: center;\">Look's like database</h4>");
        out.println("                <br>");
        out.println("                <table class=\"table table-bordered table-hover\" id=\"students\">");
        out.println("                    <thead>");
        out.println("                    <tr>");
        out.println("                        <th>ID</th>");
        out.println("                        <th>Name</th>");
        out.println("                        <th>Math</th>");
        out.println("                        <th>English</th>");
        out.println("                        <th>Physics</th>");
        out.println("                    </tr>");
        out.println("                    </thead>");
        out.println("                    <tbody>");
        for (int i = 0 ; i  <= count; i++ ){


            out.println( "<tr>" + "<td name = \"id\">"+ JavaMySql.DatabaseInfo(count)[i][0] + "</td>" + "<td>"+ JavaMySql.DatabaseInfo(count)[i][1] + "</td>" +"<td>"+ JavaMySql.DatabaseInfo(count)[i][2] + "</td>" + "<td>"+ JavaMySql.DatabaseInfo(count)[i][3] + "</td>" +"<td>"+ JavaMySql.DatabaseInfo(count)[i][4] + "</td>"  +"</tr>"  );
            out.println("\n");
        }

        out.println("                    </tbody>");
        out.println("                </table>");
        out.println("            </div>");
        out.println("        </div>");
        out.println("    </div>");
        out.println("</section>");
        out.println("");

        out.println("</body>");
        out.println("</html>");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {


        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

}
