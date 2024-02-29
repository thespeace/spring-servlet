package thespeace.servlet.web.frontController.v1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import thespeace.servlet.web.frontController.v1.controller.MemberFormControllerV1;
import thespeace.servlet.web.frontController.v1.controller.MemberListControllerV1;
import thespeace.servlet.web.frontController.v1.controller.MemberSaveControllerV1;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * -프론트 컨트롤러 도입 -v1
 *  클라이언트 -(http 요청)-> FrontController -> 1.URL 매핑 정보에서 컨트롤러 조회 -> 매핑 정보
 *                                            2.컨트롤러 호출 -> Controller -> 3. 컨트롤러에서 JSP forward -> JSP -> HTML 응답
 */
@WebServlet(name = "frontControllerServletV1", urlPatterns = "/front-controller/v1/*") //`/front-controller/v1` 를 포함한 하위 모든 요청은 이 서블릿에서 받아들인다.
public class FrontControllerServletV1 extends HttpServlet {

    //key: 매핑 URL, value: 호출될 컨트롤러
    private Map<String, ControllerV1> controllerMap = new HashMap<>();

    public FrontControllerServletV1() {
        controllerMap.put("/front-controller/v1/members/new-form", new MemberFormControllerV1());
        controllerMap.put("/front-controller/v1/members/save", new MemberSaveControllerV1());
        controllerMap.put("/front-controller/v1/members", new MemberListControllerV1());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("FrontControllerServletV1.service");

        //먼저 requestURI 를 조회해서 실제 호출할 컨트롤러를 controllerMap 에서 찾는다. 만약 없다면 404(SC_NOT_FOUND) 상태 코드를 반환.
        String requestURI = request.getRequestURI();

        ControllerV1 controller = controllerMap.get(requestURI);
        if(controller == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        controller.process(request, response);
    }
}
/**
 * -FrontController 패턴 소개
 *  1. 프론트 컨트롤러 도입 전
 *     클라이언트 -(호출)-> controllerA
 *     클라이언트 -(호출)-> controllerB
 *     클라이언트 -(호출)-> controllerC
 *  2. 프론트 컨트롤러 도입 후
 *     클라이언트 -(호출)-> FrontController -> ControllerA or ControllerB or ControllerC
 *
 *
 * -FrontController 패턴 특징
 *  프론트 컨트롤러 서블릿 하나로 클라이언트의 요청을 받는다.
 *  프론트 컨트롤러가 요청에 맞는 컨트롤러를 찾아서 호출
 *  입구를 하나로!
 *  공통 처리 가능
 *  프론트 컨트롤러를 제외한 나머지 컨트롤러는 서블릿을 사용하지 않아도 된다.
 *
 *
 * -스프링 웹 MVC와 FrontController
 *  스프링 웹 MVC의 핵심도 바로 FrontController
 *  스프링 웹 MVC의 DispatcherServlet이 FrontController 패턴으로 구현되어 있다.
 */
