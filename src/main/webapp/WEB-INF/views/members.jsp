<%@ page contentType="text/html;charset=UTF-8" language="java" %> <%--JSP문서 선언--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <%--JSP가 제공하는 taglib 사용--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/index.html">메인</a>
<table>
    <thead>
    <th>id</th>
    <th>username</th>
    <th>age</th>
    </thead>
    <tbody>
    <%--jstl 태그 활용, JSP와 같은 뷰 템플릿은 이렇게 화면을 렌더링 하는데 특화된 다양한 기능을 제공한다.--%>
    <c:forEach var="item" items="${members}">
        <tr>
            <td>${item.id}</td>
            <td>${item.username}</td>
            <td>${item.age}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>