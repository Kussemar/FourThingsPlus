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
                    <tr>
                    <td class="text-start align-middle"> ${item.name}</td>
                    <td  class="text-center align-middle">${item.created}</td>
                    <td class="text-end">
                        <button type="submit" class="ms-2 btn btn-outline-success btm-sm col-2">Done</button>
                        <button type="submit" class="ms-2 btn btn-outline-warning btm-sm col-2">Edit</button>
                        <button type="submit" class="ms-2 btn btn-outline-danger btm-sm col-2">Delete</button>
                    </td>
                    </tr>
                </c:forEach>
            </table>
        </form>

    </jsp:body>

</t:pagetemplate>