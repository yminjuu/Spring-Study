package likeLionSpringStudy.first_spring.repository;

import likeLionSpringStudy.first_spring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {
//    Test를 각 메서드의 순서에 의존적으로 설계하면 안됨. 각각 독립적으로 실행됨.
    MemoryMemberRepository repository= new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        repository.clearStore();
//        test 하나가 끝날 때마다 store을 전부 지운다.
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("MARK");

        repository.save(member);

        Member result= repository.findById(member.getId()).get();
        assertThat(member).isEqualTo(result);
//        Assertions.assertEquals(member, result);
//        System.out.println("result = " + (result == member));
    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("MARK1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("MARK2");
        repository.save(member2);

        Member result = repository.findByName("MARK1").get();
        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("MARK1");
        repository.save(member1);

        Member member2 = new Member();
        member1.setName("MARK1");
        repository.save(member2);

        List<Member> result= repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }
}
