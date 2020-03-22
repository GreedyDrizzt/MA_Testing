<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link href="${pageContext.request.contextPath}/resources/bootstrap/bootstrap-4.1.3-dist/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css" />
    <script src="${pageContext.request.contextPath}/resources/bootstrap/bootstrap-4.1.3-dist/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/jQuery/jQuery-3.x/jquery-3.3.1.min.js"></script>

    <title>New/Edit Order</title>
</head>
<body>
<div class="container">
    <div class="col-md-5">
        <div class="form-area">
            <form:form id="inputForm" action="saveOrders" method="post" modelAttribute="Orders">
                <form:hidden path="id"/>
                <br style="clear:both">
                <h4 style="margin-bottom: 25px; text-align: center;">New/Edit Orders</h4>
                <p>Please enter values in all the fields.</p>
                <div class="form-group">
                    <label for="id">order_id</label>
                    <form:input type="text" path="order_id" class="form-control" id="order_id" name="name" placeholder="order_id" required="true" />
                </div>
                <div class="form-group">
                    <label for="order_date">Order Date</label>
                    <form:input type="date" path="order_date" class="form-control" id="order_date" name="order_date" placeholder="mm/dd/yyyy" required="true" />
                </div>
                <div class="form-group">
                    <label>Toy type</label>
                    <select name="toy_type">
                        <c:forEach var="toy" items="${toys}">
                            <option>${toy.genre}</option>
                        </c:forEach>
                    </select>
                </div>
                <input type="submit" id="submit name="submit" value="Save" class="btn btn-primary pull-right">
            </form:form>
            <span></span>
            <p>Revert to Toys list&nbsp;<a href="./">here</a></p>
        </div>
    </div>
</div>
</body>
</html>