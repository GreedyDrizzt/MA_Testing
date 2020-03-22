<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <link href="${pageContext.request.contextPath}/resources/bootstrap/bootstrap-4.1.3-dist/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css" />
        <script src="${pageContext.request.contextPath}/resources/bootstrap/bootstrap-4.1.3-dist/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/jQuery/jQuery-3.x/jquery-3.3.1.min.js"></script>

        <title>New/Edit Toy</title>
    </head>
    <body>
        <div class="container">
            <div class="col-md-5">
                <div class="form-area">
                    <form:form id="inputForm" action="saveToy" method="post" modelAttribute="Toy">
                        <form:hidden path="id"/>
                        <br style="clear:both">
                        <h4 style="margin-bottom: 25px; text-align: center;">New/Edit Toy</h4>
                        <p>Please enter values in all the fields.</p>
    			<div class="form-group">
                            <label for="title">Name</label>
			    <form:input type="text" path="title" class="form-control" id="title" name="name" placeholder="Name" required="true" />
			</div>
			<div class="form-group">
                            <label for="genre">Type</label>
			    <form:input type="text" path="genre" class="form-control" id="genre" name="genre" placeholder="Type" required="true" />
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