package app.servlets;

import entities.Note;
import model.Model;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class DelServlet extends HttpServlet {




    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/del.jsp");
        requestDispatcher.forward(req, res);

    }

    public  void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        String textArea = req.getParameter("textArea");

        if(!textArea.isEmpty()) {
            Note note = new Note(textArea);
            Model model = Model.getInstance();
            model.delete(note);
            req.setAttribute("noteText", note);
        }
        doGet(req, res);
    }
}
