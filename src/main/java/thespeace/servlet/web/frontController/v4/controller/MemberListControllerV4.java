package thespeace.servlet.web.frontController.v4.controller;

import thespeace.servlet.domain.member.Member;
import thespeace.servlet.domain.member.MemberRepository;
import thespeace.servlet.web.frontController.ModelView;
import thespeace.servlet.web.frontController.v3.ControllerV3;
import thespeace.servlet.web.frontController.v4.ControllerV4;

import java.util.List;
import java.util.Map;

public class MemberListControllerV4 implements ControllerV4 {

    private final MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {
        List<Member> members = memberRepository.findAll();
        model.put("members", members);
        return "members";
    }
}
