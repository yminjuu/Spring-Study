package likeLionSpringStudy.first_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
//    localhost:8080, 기본 도메인으로 들어오면 home이 mapping됨. -> home.html을 띄움
    public String home() {
        return "home";
    }
}
