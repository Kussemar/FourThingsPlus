<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
        Todos
    </jsp:attribute>

    <jsp:attribute name="footer">
        Logged in area
    </jsp:attribute>

    <jsp:body>


        <form method="post">
            <input id="newitem" class="d-inline form-control w-50" placeholder="Enter new todo here..." type="text"
                   name="newitem"/>

            <button formaction="additem" type="submit" class="align-baseline btn btn-outline-success">Add</button>

            <table class="table table-striped mt-4">
                <c:forEach var="item" items="${requestScope.itemList}">
                    <td>
                    <td> ${item.name}</td>
                    <td>${item.created}</td>
                    <td>
                        <button type="submit" class="btn btn-outline-success btm-sm">Done</button>
                    </td>
                    </tr>
                </c:forEach>
            </table>
        </form>

    </jsp:body>

</t:pagetemplate>