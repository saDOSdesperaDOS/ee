import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "DataBaseServlet", urlPatterns = "/loadatabase")
public class DataBaseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SqlRequest sqlRequest = new SqlRequest();
        List<Note> list = sqlRequest.sellectAll();
        for (Note note: list) {
            response.getWriter().write(
                    "<table border='1'>"+
                            "<tr>"+
                                 "<td>" + note.getTextArea() + "\n"+"</td>"
                            +"</tt>"+
                      "</table>");
        }


    }
}
