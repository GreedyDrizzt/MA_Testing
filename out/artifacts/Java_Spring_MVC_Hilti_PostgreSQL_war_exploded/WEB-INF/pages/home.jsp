<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="option" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

        <!--
        <link href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.1/themes/base/jquery-ui.css" rel="stylesheet" />
        <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
        <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.1/jquery-ui.min.js"></script>
        -->

        <!--
        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css" />
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        -->

        <!--
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css" />
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        -->

        <link href="${pageContext.request.contextPath}/resources/bootstrap/bootstrap-4.1.3-dist/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css" />
        <script src="${pageContext.request.contextPath}/resources/bootstrap/bootstrap-4.1.3-dist/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/cdnjs/jquery.min.js"></script>
        <title>Toy List</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <div class="card">
                        <div class="card-body p-0">
                            <div class="row p-5">
                                <div class="col-md-12">
                                    <li>

                                        <select id="toy-id">
                                            <c:forEach var="order" items="${listOrders}">
                                                <option data-content="${myMap[order.toy_type]}">${order.order_id}</option>
                                            </c:forEach>
                                        </select>
                                        <label id="toyname"></label>
                                    </li>

                                    <table class="table">
                                        <thead>
                                            <tr>
                                                <!--<th class="border-0 text-uppercase small font-weight-bold">Title</th>-->
                                                <th class="border-0 font-weight-bold">id</th>
                                                <th class="border-0 font-weight-bold">Type</th>
                                                <th class="border-0 font-weight-bold">Name</th>
                                                <th class="border-0 font-weight-bold">Edit&nbsp;&nbsp;|&nbsp;&nbsp;Delete</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="toy" items="${listToy}">
                                                <tr>
                                                    <td>${toy.id}</td>
                                                    <td>${toy.genre}</td>
                                                    <td>${toy.title}</td>
                                                    <td><a href="editToy?id=${toy.id}">Edit</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="deleteToy?id=${toy.id}">Delete</a></td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                    <p>Register new Toy&nbsp;<a href="newToy">here</a><p>

                                    <table class="table">
                                        <thead>
                                        <tr>
                                            <!--<th class="border-0 text-uppercase small font-weight-bold">Title</th>-->
                                            <th class="border-0 font-weight-bold">Order Id</th>
                                            <th class="border-0 font-weight-bold">Order Date</th>
                                            <th class="border-0 font-weight-bold">Toy Type</th>
                                            <th class="border-0 font-weight-bold">Edit&nbsp;&nbsp;|&nbsp;&nbsp;Delete</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach var="order" items="${listOrders}">
                                            <tr>
                                                <td>${order.order_id}</td>
                                                <td>${order.order_date}</td>
                                                <td>${order.toy_type}</td>
                                                <td><a href="editOrders?id=${order.id}">Edit</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="deleteOrders?id=${order.id}">Delete</a></td>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                    <p>Register new Order&nbsp;<a href="newOrders">here</a><p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    <script type="text/javascript">
        $("#toy-id").change(function() {
            $('#toyname').text( $('option:selected').attr('data-content'));
        }).change();
    </script>
    </body>
</html>