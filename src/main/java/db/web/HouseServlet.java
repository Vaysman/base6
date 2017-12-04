package db.web;
import javax.sql.DataSource;
import db.dao.HouseDAO;
import db.model.House;
import db.Main;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import org.postgresql.ds.PGPoolingDataSource;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.sql.Connection;


public class HouseServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HouseDAO houseDAO = (HouseDAO)
                this.getServletContext().getAttribute("houseDAO");

        response.setContentType("text.html;charset=UTF-8");
        request.setAttribute("house",houseDAO);

       /* PrintWriter out = response.getWriter();
        out.println("= = = = = House list");

        out.println("= = = = = house = = = = = =");
        houseDAO.list().stream().forEach(House-> out.println(String.format("%s (id: %03d) (id: %03d)", House.getAdress(),  House.getId(),House.getRoom_count()))); */
       this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);

    }
}