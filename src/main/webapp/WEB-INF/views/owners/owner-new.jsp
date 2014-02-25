<%@ page language="java" contentType="text/html; charset=ISO-8859-1"       pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<body>
<h1>New Owner page</h1>
<form:form method="POST" commandName="owner" action="${pageContext.request.contextPath}/owners/create.html" class="form-horizontal" >

<fieldset>
    <legend>Owner Infos</legend>

    <div class="form-group error">
        <form:label class="col-lg-2 control-label" path="firstname">
            First Name <form:errors path="firstname" />
        </form:label>
        <div class="col-lg-6">
            <form:input path="firstname" class="form-control" placeholder="First Name"/>
        </div>
    </div>

    <div class="form-group error">
        <form:label class="col-lg-2 control-label" path="lastname">
            Last Name <form:errors path="lastname" />
        </form:label>
        <div class="col-lg-6">
            <form:input path="lastname" class="form-control" placeholder="Last Name"/>
        </div>
    </div>

    <div class="form-group error">
        <form:label class="col-lg-2 control-label" path="description">
            Description <form:errors path="description" />
        </form:label>
        <div class="col-lg-6">
            <form:textarea path="description" class="form-control" placeholder="description"/>
        </div>
    </div>


    <button type="submit" class="btn btn-primary">Create</button>
    </form:form>
</body>
</html>
