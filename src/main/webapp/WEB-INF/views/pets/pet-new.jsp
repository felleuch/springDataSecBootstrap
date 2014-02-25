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

    <div class="form-group error">
        <form:label class="col-lg-2 control-label" path="description">
            Description <form:errors path="description" />
        </form:label>
        <div class="col-lg-6">
            <form:textarea path="description" class="form-control" placeholder="description"/>
        </div>
    </div>

    <div class="form-group error">
        <form:label class="col-lg-2 control-label" path="ownerid">
            Description <form:errors path="ownerid" />
        </form:label>
        <div class="col-lg-6">
            <form:select path="ownerid" id="ownerid" class="form-control" placeholder="Owner" >
                <form:option value="-1" label="--Please Select"/>
                <form:options items="${owners}" itemValue="id" itemLabel="firstname"/>
            </form:select>
        </div>
    </div>

    <div class="form-group error">
        <form:label class="col-lg-2 control-label" path="image">
            Image <form:errors path="image" />
        </form:label>
        <div class="col-lg-6">
            <form:input id="image" path="image" class="form-control" placeholder="image"  />
            <input id="fileupload" type="file" name="files[]" data-url="/pets/upload" >
            <img id="img2" src="#" width="100px"   height="100px"/>
        </div>
    </div>

        <button type="submit" class="btn btn-primary">Create</button>
    </form:form>
</body>
</html>
