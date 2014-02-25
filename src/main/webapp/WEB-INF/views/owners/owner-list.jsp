<%@ page language="java" contentType="text/html; charset=ISO-8859-1"       pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<body>
<h1>Owner List page</h1>
<div class="table-container">
    <a href="/owners/create" class="btn btn-success btn-large"><i class="icon-white "></i> Add New</a>
    <br><br>
    <table  cellpadding="0" cellspacing="0" border="0"  class="display ownersDataTable">
        <thead>
        <tr>
            <th>  <input id="allcheckbox" name="allcheckbox" type="checkbox" />  </th>
            <th>Last Name</th>
            <th>First Name</th>
            <th></th>
            <th></th>
            <th></th>

        </tr>
        </thead>
        <tbody>
        </tbody>
    </table>
</div>
<div id="ownerdetail" title="Owner detail">
</div>
<a href="${pageContext.request.contextPath}/">Home page</a>
</body>
</html>