import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AddServlet", urlPatterns = "/add")
public class AddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String textArea = request.getParameter("textArea");
        Note note = new Note();
        note.setTextArea(textArea);
        SqlRequest sqlRequest = new SqlRequest();
        sqlRequest.add(note);
        doGet(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().write(
                " <html>\n" +
                "<head>\n" +
                "<title>Add new Note</title>\n" +
                "</head>\n" +
                "\n" +
                  "<body" +
                  "<div>\n" +
                    "<h2>Add Note</h2>\n" +
                  "</div>\n" +
                  "<div>\n" +
                    "<form method=\"post\">\n" +
                        "Note:\n" +
                        "<div id=\"body_container\" style=\"width : 500px;height: 300px\">\n" +
                            "<textarea name=\"textArea\"  style=\"height: 250px;\"></textarea>\n" +
                            "<button type=\"submit\">Save</button>\n" +
                        "</div>\n" +
                    "</form>\n" +
                  "</div>\n" +
                "<div>\n" +
                    "<button onclick=\"location.href='/'\">Back to main</button>\n" +
                "</div>\n" +
                "\n" +
                  "</body>\n" +
                "</html>");
    }
}
