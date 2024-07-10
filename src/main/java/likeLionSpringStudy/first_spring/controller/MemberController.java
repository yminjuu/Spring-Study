package likeLionSpringStudy.first_spring.controller;

import likeLionSpringStudy.first_spring.domain.Member;
import likeLionSpringStudy.first_spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

//Controller annotation이 필요
@Controller
public class MemberController {
    private final MemberService memberService;

    @Autowired
    public MemberController(final MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName()); // 직접 만들어준 setter

        System.out.println(member.getName());
        memberService.join(member);

        return "redirect:/"; // redirect: 다시 home으로 돌려보낸다.
    }

    @GetMapping("/members")
    public String list(Model model){
        List<Member> members= memberService.findMembers();
//        model attribute로 members 리스트를 추가하여 화면에 넘길 것임.
        model.addAttribute("members", members);
        return "members/memberList";
    }
}
