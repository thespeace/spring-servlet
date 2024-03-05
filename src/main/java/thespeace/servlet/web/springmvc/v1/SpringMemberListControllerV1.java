package thespeace.servlet.web.springmvc.v1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import thespeace.servlet.domain.member.Member;
import thespeace.servlet.domain.member.MemberRepository;

import java.util.List;

@Controller
public class SpringMemberListControllerV1 {

    private final MemberRepository memberRepository = MemberRepository.getInstance();

    @RequestMapping("/springmvc/v1/members")
    public ModelAndView process() {
        List<Member> members = memberRepository.findAll();
        ModelAndView mv = new ModelAndView("members");
//        mv.getModel().put("members", members);
        mv.addObject("members",members);
        return mv;
    }
}
