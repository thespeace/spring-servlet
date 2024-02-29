package thespeace.servlet.web.frontController;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * -View 분리 - v2
 *  모든 컨트롤러에서 뷰로 이동하는 부분에 중복이 있고, 깔끔하지 않다.
 *  {@code
 *      String viewPath = "/WEB-INF/views/new-form.jsp";
 *      RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
 *      dispatcher.forward(request, response);
 *  }
 *  부분을 깔끔하게 분리하기 위해 별도로 뷰를 처리하는 객체를 만들자.
 *
 * -V2 구조
 *  클라이언트 -(http 요청)-> FrontController -> 1. URL 매핑 정보에서 컨트롤러 조회 -> 매핑 정보
 *                                            2. 컨트롤러 호출 -> controller -> 3. MyView 반환 -> FrontController -> 4. render()호출 -> MyView -> 5. JSP forward -> JSP -> HTML 응답
 */
public class MyView {
    private String viewPath;

    public MyView(String viewPath) {
        this.viewPath = viewPath;
    }

    //프론트 컨트롤러의 도입으로 MyView 객체의 render() 를 호출하는 부분을 모두 일관되게 처리할 수 있다.
    public void render(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request, response);
    }
}
