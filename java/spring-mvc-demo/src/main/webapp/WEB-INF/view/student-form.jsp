<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Student Registration Form</title>
</head>
<body>

<form:form action="processForm" modelAttribute="student" method="get">
    First Name: <form:input path="firstName"/>
    <br/>
    Last Name: <form:input path="lastName"/>
    <br/>
    <form:select path="country">
        <form:options items="${theCountryOptions.values()}"/>
    </form:select>
    <br/>
    Favourite Language:
    <br/>
    Java <form:radiobutton path="favouriteLanguage" value="Java"/>
    Python <form:radiobutton path="favouriteLanguage" value="Python"/>
    C <form:radiobutton path="favouriteLanguage" value="C"/>
    C++ <form:radiobutton path="favouriteLanguage" value="C++"/>
    C# <form:radiobutton path="favouriteLanguage" value="C#"/>
    Go <form:radiobutton path="favouriteLanguage" value="Go"/>
    <br/>
    <input type="submit" value="Submit"/>
</form:form>

</body>
</html>
