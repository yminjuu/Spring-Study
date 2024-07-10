package likeLionSpringStudy.first_spring;

import likeLionSpringStudy.first_spring.repository.MemberRepository;
//import likeLionSpringStudy.first_spring.repository.JdbcMemberRepository;
import likeLionSpringStudy.first_spring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// configuration-> spring이 관리해줌
@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

    // 스프링에서 알아서 DI 해줌
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

//    @Bean
//    public MemberRepository memberRepository() {
////        return new MemoryMemberRepository();
////        return new JdbcMemberRepository(dataSource);
////        return new JdbcTemplateMemberRepository(dataSource);
////        return new JpaMemberRepository(em);
//
//    }
}
