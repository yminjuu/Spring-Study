package likeLionSpringStudy.first_spring.service;

import likeLionSpringStudy.first_spring.domain.Member;
import likeLionSpringStudy.first_spring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MemberServiceTest {

    MemoryMemberRepository memberRepository;
    MemberService memberService;

    // 테스트를 하기 전마다 새로운 repository/service 할당
    @BeforeEach
    public void beforeEach(){
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    // 테스트를 한 후마다
    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
//        test 하나가 끝날 때마다 데이터를 전부 지운다.
    }

    @Test
    void 회원가입() {
        // given : 무언가가 주어졌을 때
        Member member = new Member();
        member.setName("hello");

        // when : 이거를 실행했을 때
        Long saveId = memberService.join(member);

        // then : 결과가 이렇게 나와야 해!
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName()); //내가 원하는 회원 name과 같은지 검증
    }

//    중복 회원 로직이 잘 작동하는지 확인해야함
    @Test
    public void 중복_회원_예외() {
        //given
        Member member1 = new Member();
        member1.setName("Mark");

        Member member2 = new Member();
        member2.setName("Mark");

        //when
        memberService.join(member1);
        // try-catch 대신  asserThrows 메서드를 활용한다 -> 뒤의 문장이 실행되면 앞의 예외가 터져야 한다.
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        assertThat(e.getMessage()).isEqualTo("중복 이름 존재");

//        try {
//            memberService.join(member2); // 예외가 터져야 함 (다음 문장으로 넘어가선 안됨)
//            fail("예외 발생해야 옳음");
//        } catch (IllegalStateException e) {
//            assertThat(e.getMessage()).isEqualTo("중복 이름 존재");
//        }


        //then

    }

    @Test
    void findMembers() {

    }

    @Test
    void findOne() {

    }
}