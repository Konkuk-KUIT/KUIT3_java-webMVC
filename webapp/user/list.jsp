<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="ko">
<%@ include file="../include/header.jspf" %>
<body>
<%@ include file="../include/navigation.jspf" %>
<div class="container" id="main">
    <table class="table table-striped">
        <thead class="col-md-12">
        <tr>
            <th class="col-md-3">아이디</th>
            <th class="col-md-3">이름</th>
            <th class="col-md-3">이메일</th>
            <th class="col-md-3">#</th>

        </tr>
        </thead>
        <tbody>

        <%-- 왜 안될까?..? HttpSession usersession = request.getSession();
         Object sessionValue = usersession.getAttribute("user"); // 세션에서 사용자 정보 가져오기
            Collection<User> users = (Collection<User>) request.getAttribute("users"); // request 속성에서 사용자 목록 가져오기
            if (sessionValue != null) {
                User sessionUser = (User) sessionValue; // 세션에서 가져온 사용자 정보
                for (User user : users) {
         %>--%>

        <c:forEach items="${users}" var="user">
            <tr>
                <th class="col-md-3">${user.userId}
                </th>
                <th class="col-md-3">${user.name}
                </th>
                <th class="col-md-3">${user.email}
                </th>
                <th class="col-md-3">
                    <c:choose>
                        <c:when test="${user.userId eq sessionScope.user.userId}">
                            <a href="/user/updateForm?userId=${user.userId}" class="btn btn-success" role="button">수정</a>
                        </c:when>
                        <c:otherwise>
                            <a href="#" class="btn" role="button" disabled>-</a>
                        </c:otherwise>
                    </c:choose>
                </th>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
    <script src="../js/scripts.js"></script>
</body>
</html>