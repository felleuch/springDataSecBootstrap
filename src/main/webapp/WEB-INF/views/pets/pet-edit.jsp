<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
    <title>Edit Pet page</title>
</head>
<body>
<h1>Edit Pet page</h1>
<form:form method="POST" commandName="petObject" action="${pageContext.request.contextPath}/pets/edit/${petObject.id}.html" class="form-horizontal" >


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

        <div class="form-group error">
            <form:label class="col-lg-2 control-label" path="description">
                Color <form:errors path="description" />
            </form:label>
            <div class="col-lg-6">
                <form:textarea path="description" class="form-control" placeholder="description"/>
            </div>
        </div>


        <button type="submit" class="btn btn-primary">Save</button>
        <a href="/pets/list" class="btn btn-success btn-large"><i class="icon-white "></i> Cancel</a>
    </fieldset>


</form:form>



</body>
</html>