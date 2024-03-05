package thespeace.servlet.web.springmvc.v2;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import thespeace.servlet.domain.member.Member;
import thespeace.servlet.domain.member.MemberRepository;

import java.util.List;

/**
 * -스프링 MVC - 컨트롤러 통합
 *  클래스 단위 -> 메서드 단위.
 *  @RequestMapping 클래스 레벨과 메서드 레벨 조합.
 *  따라서 컨트롤러 클래스를 유연하게 하나로 통합할 수 있다.
 */
@Controller
@RequestMapping("/springmvc/v2/members") //클래스 레벨에 다음과 같이 @RequestMapping을 두면 메서드 레벨과 조합이 된다.
public class SpringMemberControllerV2 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @RequestMapping("/new-form")
    public ModelAndView newForm() {
        return new ModelAndView("new-form");
    }

    @RequestMapping("/save")
    public ModelAndView save(HttpServletRequest request) {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        Member member = new Member(username, age);
        memberRepository.save(member);

        ModelAndView mv = new ModelAndView("save-result");
        mv.addObject("member", member);
        return mv;
    }

    @RequestMapping
    public ModelAndView members() {
        List<Member> members = memberRepository.findAll();
        ModelAndView mv = new ModelAndView("members");
        mv.addObject("members", members);
        return mv;
    }
}
