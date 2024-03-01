package thespeace.servlet.web.frontController.v3.controller;

import thespeace.servlet.domain.member.Member;
import thespeace.servlet.domain.member.MemberRepository;
import thespeace.servlet.web.frontController.ModelView;
import thespeace.servlet.web.frontController.v3.ControllerV3;

import java.util.Map;

public class MemberSaveControllerV3 implements ControllerV3 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public ModelView process(Map<String, String> paramMap) {
        String username = paramMap.get("username");
        int age = Integer.parseInt(paramMap.get("age"));

        Member member = new Member(username, age);
        memberRepository.save(member);

        ModelView mv = new ModelView("save-result");
        mv.getModel().put("member", member); //모델은 단순한 map이므로 모델에 뷰에서 필요한 member 객체를 담고 반환한다.
        return mv;
    }
}
