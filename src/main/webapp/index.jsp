<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
         Welcome to the frontpage
    </jsp:attribute>

    <jsp:attribute name="footer">
        Welcome to the frontpage
    </jsp:attribute>

    <jsp:body>

        <p>Startcode for 2nd semester </p>

        <c:if test="${sessionScope.user != null}">
            <p class="bolded">You are logged in with the role of "${sessionScope.user.role}".</p><b/>
        </c:if>

        <c:if test="${sessionScope.user != null}">
        <p>Add items to: <a href="viewitems">todo</a> </p>
        </c:if>

        <c:if test="${sessionScope.user == null}">
            <p class="bolded">You are not logged in yet. <p/>
                <p> You can do it here: <a
                    href="login.jsp">Login</a></p>
            <p> Or register here: <a
                    href="register.jsp">Register</a></p>
        </c:if>

    </jsp:body>

</t:pagetemplate>