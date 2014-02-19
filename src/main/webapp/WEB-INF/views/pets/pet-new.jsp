<%@ page language="java" contentType="text/html; charset=ISO-8859-1"       pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<body>
<h1>New Pet page</h1>
<form:form method="POST" commandName="pet" action="${pageContext.request.contextPath}/pets/create.html" class="form-horizontal" >

<fieldset>
    <legend>Pet Infos</legend>

    <div class="form-group error">
        <form:label class="col-lg-2 control-label" path="name">
            Name <form:errors path="name" />
        </form:label>
        <div class="col-lg-6">
            <form:input path="name" class="form-control" placeholder="name"/>
        </div>
    </div>

    <div class="form-group error">
        <form:label class="col-lg-2 control-label" path="color">
            Color <form:errors path="color" />
        </form:label>
        <div class="col-lg-6">
            <form:input path="color" class="form-control" placeholder="color"/>
        </div>
    </div>



    <p><button type="submit" class="btn btn-primary">Create</button></p>
</form:form>
<a href="${pageContext.request.contextPath}/">Home page</a>
</body>
</html>
