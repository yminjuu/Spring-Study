package likeLionSpringStudy.first_spring.repository;

import likeLionSpringStudy.first_spring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
//    repository의 4가지 기능
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String username);
    List<Member> findAll();
}
