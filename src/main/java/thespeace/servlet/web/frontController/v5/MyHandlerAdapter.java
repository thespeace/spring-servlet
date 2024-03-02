package thespeace.servlet.web.frontController.v5;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import thespeace.servlet.web.frontController.ModelView;

import java.io.IOException;

public interface MyHandlerAdapter {

    boolean supports(Object handler); //어댑터가 해당 컨트롤러를 처리할 수 있는지 판단하는 메서드로 handler는 컨트롤러를 말한다.

    //어댑터는 실제 컨트롤러를 호출하고, 그 결과로 ModelView를 반환해야 한다. 실제 컨트롤러가 ModelView를 반환하지 못하면, 어댑터가 ModelView를 직접 생성해서라도 반환해야 한다.
    //이전에는 프론트 컨트롤러가 실제 컨트롤러를 호출했지만 이제는 이 어댑터를 통해서 실제 컨트롤러가 호출 된다.
    ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException;
}

/**
 * -유연한 컨트롤러1 -v5
 *  `어댑터 패턴`을 사용해서 프론트 컨트롤러가 다양한 방식의 컨트롤러를 처리할 수 있도록 변경해보자.
 *
 *  구조
 *      클라이언트 -(http요청)-> Front Controller -> 1.핸들러 조회 -> 핸들러 매핑 정보
 *                                             -> 2.핸들러를 처리할 수 있는 핸들러 어댑터 조회 -> 핸들러 어댑터 목록
 *                                             -> 3. handle(handler) -> 핸들러 어댑터 -> 4. handler 호출 -> 핸들러(컨트롤러) -> 5.ModelView 반환 -> Front Controller ->
 *                                             6.viewResolver 호출 -> viewResolver -> 7.MyView 반환 -> Front Controller -> 8.render(model)호출 -> Myview -> HTML 응답
 *
 *      핸들러 어댑터 : 중간에 어댑터 역할을 하는 어댑터가 추가되었는데 이름이 핸들러 어댑터이다. 여기서 어댑터 역 할을 해주는 덕분에 다양한 종류의 컨트롤러를 호출할 수 있다.
 *      핸들러: 컨트롤러의 이름을 더 넓은 범위인 핸들러로 변경했다. 그 이유는 이제 어댑터가 있기 때문에 꼭 컨트롤러 의 개념 뿐만 아니라 어떠한 것이든 해당하는 종류의 어댑터만 있으면 다 처리할 수 있기 때문이다
 */