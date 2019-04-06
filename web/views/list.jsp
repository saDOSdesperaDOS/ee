<%@ page import="java.util.List" %>
<%@ page import="entities.Note" %>
<%--
  Created by IntelliJ IDEA.
  User: mike
  Date: 15.12.2018
  Time: 9:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>WebNotepad</title>
</head>
<body>
    <ul>
    <%
        for (Note note:(List<Note>)request.getAttribute("list")) {
            out.println("<li>");
            out.println("<a href='#'>"+note.getTittle()+"</a> " + "<textarea>" + note.getTittle() + "</textarea>" + " <textarea>" + note.getTextArea() + "</textarea>");
            out.println("</li>");
        }
    %>
    </ul>
</body>
</html>
