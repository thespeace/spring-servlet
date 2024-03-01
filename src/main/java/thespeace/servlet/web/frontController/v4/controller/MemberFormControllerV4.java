package thespeace.servlet.web.frontController.v4.controller;

import thespeace.servlet.web.frontController.v4.ControllerV4;

import java.util.Map;

public class MemberFormControllerV4 implements ControllerV4 {

    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {
        return "new-form"; //view의 논리 이름만 반환.
    }
}
