package likeLionSpringStudy.first_spring.repository;

import likeLionSpringStudy.first_spring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// JpaRepository 인터페이스, MemberRepository를 extend해야
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    Optional<Member> findByName(String name);

}
