package thespeace.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * -HTTP 요청 데이터 - API 메시지 바디 - 단순 텍스트
 *  HTTP message body에 데이터를 직접 담아서 요청
 *      1. HTTP API에서 주로 사용, JSON, XML, TEXT
 *      2. 데이터 형식은 주로 JSON 사용
 *      3. POST, PUT, PATCH
 *
 *  먼저 가장 단순한 텍스트 메시지를 HTTP 메시지 바디에 담아서 전송하고, 읽어보자.
 *  HTTP 메시지 바디의 데이터를 InputStream을 사용해서 직접 읽을 수 있다.
 *
 *  POST http://localhost:8080/request-body-string
 *  content-type: text/plain
 *  message body: hello
 *  결과: messageBody = hello
 */
@WebServlet(name = "requestBodyStringServlet", urlPatterns = "/request-body-string")
public class RequestBodyStringServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletInputStream inputStream = request.getInputStream();
        //inputStream은 byte 코드를 반환, byte 코드를 우리가 읽을 수 있는 UTF_8 Charset을 지정.
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

        System.out.println("messageBody = " + messageBody);

        response.getWriter().write("ok");
    }
}
