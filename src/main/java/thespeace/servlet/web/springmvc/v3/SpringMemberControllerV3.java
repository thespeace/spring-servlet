package thespeace.servlet.web.springmvc.v3;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import thespeace.servlet.domain.member.Member;
import thespeace.servlet.domain.member.MemberRepository;

import java.util.List;

/**
 * 스프링 MVC - 실용적인 방식 V3
 * 실무에서는 해당 방식으로 주로 사용한다.
 * Model 도입
 * ViewName 직접 반환
 * @RequestParam 사용
 * @RequestMapping -> @GetMapping, @PostMapping
 */
@Controller
@RequestMapping("/springmvc/v3/members")
public class SpringMemberControllerV3 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    //@RequestMapping 은 URL만 매칭하는 것이 아니라, HTTP Method도 함께 구분할 수 있다.
//    @RequestMapping(value = "/new-form", method = RequestMethod.GET) //HTTP Method가 GET인 경우만 매핑가능(제약).
    @GetMapping("/new-form") //스프링은 Annotation을 조합한 편리한 Annotation들을 많이 제공한다.
    public String newForm() {
        return "new-form"; //뷰의 논리 이름으로 반환.
    }

//    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @PostMapping("/save")
    public String save(
            @RequestParam("username") String username, //request.getParameter("username")
            @RequestParam("age") int age, //Integer.parseInt(request.getParameter("age")), 형변환도 자동으로 해준다.
            Model model) { //Model을 파라미터로 받는 편의 기능 제공.

        Member member = new Member(username, age);
        memberRepository.save(member);

        model.addAttribute("member", member);
        return "save-result";
    }

//    @RequestMapping(method = RequestMethod.GET)
    @GetMapping
    public String members(Model model) {
        List<Member> members = memberRepository.findAll();
        model.addAttribute("members", members);
        return "members";
    }
}