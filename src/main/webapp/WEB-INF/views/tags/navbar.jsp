<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Pet clinic</a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="<c:url value="/" />">Home</a></li>
                <li><a href="<c:url value="/pets/create" />">Create Pet</a></li>
                <li><a href="<c:url value="/pets/list" />">Pets</a></li>
                <li><a href="<c:url value="/owners/list" />">Owners</a></li>
                <li><a href="<c:url value="/owners/create" />">Create owners</a></li>
            </ul>
        </div>
    </div>
</div>