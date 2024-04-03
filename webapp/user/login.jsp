<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="ko">
<head>
    <%@ include file="../include/header.jsp" %>
</head>
<body>
<%@ include file="../include/navigation.jsp" %>
<div class="container">
    <main class="form-signin">
        <form name="login" method="post" action="/user/login">
            <h1 class="h3 mb-3 fw-normal">Please Log In</h1>

            <div class="form-floating">
                <input type="text" class="form-control" id="loginId" name="userId" placeholder="id">
                <label for="loginId">ID</label>
            </div>
            <div class="form-floating">
                <input type="password" class="form-control" id="loginPassword" name="password" placeholder="Password">
                <label for="loginPassword">Password</label>
            </div>

            <button class="w-100 btn btn-lg btn-primary" type="submit">Log In</button>
        </form>
    </main>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
<script src="../js/scripts.js"></script>
</body>
</html>