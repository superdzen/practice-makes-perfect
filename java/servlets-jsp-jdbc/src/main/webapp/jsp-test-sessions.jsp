<%@ page import="java.util.*" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>To-Do List</title>
</head>
<body>

<!-- Step 1: Create HTML form-->
<form action="jsp-test-sessions.jsp">
    Add new item: <input type="text" name="theItem"/>
    <input type="submit" value="Submit"/>
</form>
<br/>
<!-- Step 2: Add new item to "To Do " list-->
<%
    // Get the TO DO items from the session
    List<String> items = (List<String>) session.getAttribute("myToDoList");
    // if the TO DO items doesn't exist, then create new one
    if (items == null) {
        items = new ArrayList<String>();
        session.setAttribute("myToDoList", items);
    }
    // see if there is form data to add
    String theItem = request.getParameter("theItem");
    if (theItem != null && !(theItem.trim().equals(""))) {
        items.add(theItem);
    }
%>
<!-- Step 3: Display all "To Do" item from session-->
<b>TO-DO List Items:</b><br/>
<ol>
    <%
        for (String item : items) {
            out.println("<li>" + item + "</li>");
        }
    %>
</ol>
</body>
</html>