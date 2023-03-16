<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
             Register
    </jsp:attribute>

    <jsp:attribute name="footer">
            Register
    </jsp:attribute>

    <jsp:body>

        <h3>You can register here</h3>

        <c:if test="${requestScope.message != null}">
            <p>${requestScope.message}</p>
        </c:if>

        <form action="register" method="post">
            <label for="username">Username: </label>
            <input type="text" id="username" name="username"/>
            <label for="password">Password: </label>
            <input type="password" id="password" name="password"/>
            <label for="password">Confirm password: </label>
            <input type="password" id="confirmpassword" name="confirmpassword"/>
            <input type="submit"  value="register"/>
        </form>


        <p> Or login here: <a
                href="login.jsp">Log in</a></p>

    </jsp:body>
</t:pagetemplate>