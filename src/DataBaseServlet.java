import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet(name = "DataBaseServlet", urlPatterns = "/loadatabase")
public class DataBaseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SqlRequest sqlRequest = new SqlRequest();
        List<Note> list = sqlRequest.sellectAll();
        List<String> tittleList = new ArrayList<>();
        for (Note note: list) {
            tittleList.add(note.getTittle());
        }
        request.setAttribute("tittleList", tittleList);
       RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/list.jsp");
       requestDispatcher.forward(request, response);
    }
 }

