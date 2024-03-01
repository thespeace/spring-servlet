package thespeace.servlet.web.frontController.v4;

import java.util.Map;

/**
 * -단순하고 실용적인 컨트롤러 -v4
 *  앞서 만든 v3 컨트롤러는 서블릿 종속성을 제거하고 뷰 경로의 중복을 제거하는 등, 잘 설계된 컨트롤러이다.
 *  그런데 실제 컨트톨러 인터페이스를 구현하는 개발자 입장에서 보면, 항상 ModelView 객체를 생성하고 반환해야 하는 부분이 조금은 번거롭다.
 *  이 부분을 제거하고 실용성이 있게 변경해보자.
 *  기본적인 구조는 v3와 같지만 대신 컨트롤러가 ModelView를 반환하지 않고, ViewName만 반환한다.
 *
 *  이번 버전의 컨트롤러는 매우 단순하고 실용적이다.
 *  기존 구조에서 모델을 파라미터로 넘기고, 뷰의 논리 이름을 반환한다는 작은 아이디어를 적용했을 뿐인데,
 *  컨트롤러를 구현하는 개발자 입장에서 보면 이제 군더더기 없는 코드를 작성할 수 있다.
 *  또한 중요한 사실은 여기까지 한번에 온 것이 아니라는 점이다. 프레임워크가 점진적으로 발전하는 과정 속에서 이런 방법도 찾을 수 있었다.
 *  `프레임워크나 공통 기능이 수고로워야 사용하는 개발자가 편리해진다.`
 */
public interface ControllerV4 {
    /**
     * @param paramMap
     * @param model
     * @return viewName
     */
    //ModelView가 없는데 model 객체는 파라미터로 전달되기 때문에 그냥 사용하면 되고, 결과로 뷰의 이름만 반환해주면 된다
    String process(Map<String, String> paramMap, Map<String, Object> model);
}