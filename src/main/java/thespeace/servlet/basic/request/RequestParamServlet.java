package thespeace.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

/**
 * -HTTP 요청 데이터 - GET 쿼리 파라미터
 *  메시지 바디 없이, URL의 쿼리 파라미터를 사용해서 데이터를 전달하자. ex)검색, 필터, 페이징등에서 많이 사용하는 방식.
 *  쿼리 파라미터는 URL에 다음과 같이 ? 를 시작으로 보낼 수 있다. 추가 파라미터는 & 로 구분하면 된다.
 *  서버에서는 HttpServletRequest 가 제공하는 메서드들을 통해 쿼리 파라미터를 편리하게 조회할 수 있다.
 *
 *  1. 파라미터 전송 기능
 *  http://localhost:8080/request-param?username=hello&age=20
 *
 *  2. 동일한 파라미터 전송 가능
 *  http://localhost:8080/request-param?username=hello&username=kim&age=20
 */
@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet{

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("[전체 파라미터 조회] - start");

        //예전 방식으로 조회.
//        Enumeration<String> parameterNames = request.getParameterNames();
//        while (parameterNames.hasMoreElements()) {
//            String paramName = parameterNames.nextElement();
//            System.out.println(paramName + "=" +
//            request.getParameter(paramName));
//        }

        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> System.out.println(paramName + "=" + request.getParameter(paramName)));

        System.out.println("[전체 파라미터 조회] - end");
        System.out.println();

        System.out.println("[단일 파라미터 조회]");
        String username = request.getParameter("username");
        System.out.println("request.getParameter(username) = " + username);
        String age = request.getParameter("age");
        System.out.println("request.getParameter(age) = " + age);
        System.out.println();

        System.out.println("[파라미터를 Map으로 조회]");
        Map<String, String[]> parameterMap = request.getParameterMap();
        for (String s : parameterMap.get("username")) {
            System.out.println(s);
        }
        System.out.println();

        System.out.println("[이름이 같은 복수 파라미터 조회]");
        System.out.println("request.getParameterValues(username)");
        String[] usernames = request.getParameterValues("username");
        for (String name : usernames) {
            System.out.println("username=" + name);
        }
        //하나의 파라미터 이름에 여러 값이 있을 때 `request.getParameter()`를 사용하면 면 `request.getParameterValues()`의 첫번째 값을 반환한다.

        response.getWriter().write("ok");
    }

}