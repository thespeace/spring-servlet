package thespeace.servlet.web.frontController.v3.controller;

import thespeace.servlet.domain.member.Member;
import thespeace.servlet.domain.member.MemberRepository;
import thespeace.servlet.web.frontController.ModelView;
import thespeace.servlet.web.frontController.v3.ControllerV3;

import java.util.List;
import java.util.Map;

public class MemberListControllerV3 implements ControllerV3 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public ModelView process(Map<String, String> paramMap) {
        List<Member> members = memberRepository.findAll();
        ModelView mv = new ModelView("members");
        mv.getModel().put("members", members);

        return mv;
    }
}
