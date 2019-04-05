package controllers.dao.servlets;

import controllers.dao.SqlRequest;
import entities.Note;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "controllers.dao.servlets.DataBaseServlet", urlPatterns = "/loadatabase")
public class DataBaseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SqlRequest sqlRequest = new SqlRequest();
        List<Note> list = sqlRequest.sellectAll();
        request.setAttribute("list", list);
       RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/list.jsp");
       requestDispatcher.forward(request, response);
    }
 }

