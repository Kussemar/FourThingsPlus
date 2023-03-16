<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
             Editform
    </jsp:attribute>

    <jsp:attribute name="footer">
            Editform
    </jsp:attribute>

    <jsp:body>

        <form method="post">
        <h3>Edit item name</h3>
            <input style="width: 300px" type="text" name="name" value="${requestScope.item.name}">
            <button formaction="updateitem" type="submit" class="ms-2 btn btn-outline-success btm-sm col-2" name="item_id" value="${requestScope.item.itemId}">Update Item
            </button>
        </form>

    </jsp:body>
</t:pagetemplate>