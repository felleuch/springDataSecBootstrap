<%@ page language="java" contentType="text/html; charset=ISO-8859-1"       pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<body>
<h1>Pet List page</h1>
<div class="table-container">
    <table  cellpadding="0" cellspacing="0" border="0"  class="display jqueryDataTable">
        <thead>
        <tr>
            <th>  <input id="allcheckbox" name="allcheckbox" type="checkbox" />  </th>
            <th>Name</th>
            <th>Color</th>
            <th></th>
            <th></th>
            <th></th>

        </tr>
        </thead>
        <tbody>
        </tbody>
    </table>
</div>
<div id="petdetail" title="Pet detail">
</div>
<a href="${pageContext.request.contextPath}/">Home page</a>
</body>
</html>