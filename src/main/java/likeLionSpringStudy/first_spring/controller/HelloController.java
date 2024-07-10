package likeLionSpringStudy.first_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

//    web application에서 /hello로 주소가 매핑되면 이 함수를 호출해준다
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello";
    }

    @GetMapping("hello-mvc")
//    이번에는 위의 hello 함수와 달리 파라미터를 전달받는 방식을 사용해본다.
    public String helloMvc(@RequestParam(value = "name", required = false) String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody
//    ResponseBody의 역할? http의 응답 Body 부에 직접 데이터를 넣어주겠다라는 의미
//    위의 방식과는 달리 html template을 거치지 않고 데이터가 그대로 들어가게 된다.
    public String helloString(@RequestParam(value = "name") String name) {
        return "hello "+ name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private String name;
//        getter
        public String getName() {
            return name;
        }
//        setter
        public void setName(String name) {
            this.name= name;
        }
    }
}
