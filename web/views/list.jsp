<%@ page import="java.util.ArrayList" %>
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
        for (String tittle: (ArrayList<String>)request.getAttribute("tittleList")) {
            out.println("<li>");
            out.println(tittle);
            out.println("</li>");
        }
    %>
    </ul>
</body>
</html>
