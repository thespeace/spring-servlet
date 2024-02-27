<%@ page contentType="text/html;charset=UTF-8" language="java" %> <%--JSP문서 선언--%>
<%@ page import="thespeace.servlet.domain.member.MemberRepository" %> <%--자바의 import 문과 같다.--%>
<%@ page import="thespeace.servlet.domain.member.Member" %>
<% //자바 코드를 입력할 수 있다.
    //request, response 사용 가능(JSP는 서버 내부에서 서블릿으로 변환된다.)
    MemberRepository memberRepository = MemberRepository.getInstance();

    String username = request.getParameter("username");
    int age = Integer.parseInt(request.getParameter("age"));

    Member member = new Member(username, age);
    memberRepository.save(member);
%>
<%--코드의 상위 절반은 회원을 저장하기 위한 비즈니스 로직이고, 나머지 하위 절반만 결과를 HTML로 보여주기 위한 뷰 영역--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
성공
<ul>
    <li>id=<%=member.getId()%></li> <%--자바 코드를 출력할 수 있다.--%>
    <li>username=<%=member.getUsername()%></li>
    <li>age=<%=member.getAge()%></li>
</ul>
<a href="/index.html">메인</a>
</body>
</html>