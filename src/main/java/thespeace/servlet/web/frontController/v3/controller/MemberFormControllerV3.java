package thespeace.servlet.web.frontController.v3.controller;

import thespeace.servlet.web.frontController.ModelView;
import thespeace.servlet.web.frontController.v3.ControllerV3;

import java.util.Map;

public class MemberFormControllerV3  implements ControllerV3 {

    @Override
    public ModelView process(Map<String, String> paramMap) {
        return new ModelView("new-form"); // ModelView 를 생성할 때 new-form 이라는 view의 논리적인 이름을 지정.
    }
}
