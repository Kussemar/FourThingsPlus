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
                <!--   <th>
                   <td class="text-start">Name</td>
                   <td class="text-center">Date created</td>
                   <td class="text-end">Actions</td>
                   <th/>
                -->
                <c:forEach var="item" items="${requestScope.itemList}">
                    <c:if test="${!item.done}">
                        <tr>
                            <td class="text-start align-middle"> ${item.name}</td>
                            <td class="text-center align-middle">${item.created}</td>
                            <td class="text-end">
                                <button formaction="additem" type="submit"
                                        class="ms-2 btn btn-outline-success btm-sm col-2" name="action"
                                        value="done-${item.itemId}">Done
                                </button>
                                <button formaction="editform" type="submit"
                                        class="ms-2 btn btn-outline-warning btm-sm col-2" name="item_id"
                                        value="${item.itemId}">Edit
                                </button>
                                <button formaction="additem" type="submit"
                                        class="ms-2 btn btn-outline-danger btm-sm col-2" name="action"
                                        value="delete-${item.itemId}">Delete
                                </button>
                            </td>
                        </tr>
                    </c:if>
                </c:forEach>
            </table>
        </form>

        <h1>Done</h1>
        <form method="post">
            <table class="table table-striped mt-4">
                <c:forEach var="item" items="${requestScope.itemList}">
                    <c:if test="${item.done}">
                        <tr>
                            <td class="text-start align-middle"> ${item.name}</td>
                            <td class="text-center align-middle">${item.created}</td>
                            <td class="text-end">
                                <button formaction="additem" type="submit"
                                        class="ms-2 btn btn-outline-success btm-sm col-2" name="action"
                                        value="undo-${item.itemId}">Undo
                                </button>
                                <button formaction="additem" type="submit"
                                        class="ms-2 btn btn-outline-danger btm-sm col-2" name="action"
                                        value="delete-${item.itemId}">Delete
                                </button>
                            </td>
                        </tr>
                    </c:if>
                </c:forEach>
            </table>
        </form>
    </jsp:body>

</t:pagetemplate>