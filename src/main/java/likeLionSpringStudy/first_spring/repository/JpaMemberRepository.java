package likeLionSpringStudy.first_spring.repository;

import jakarta.persistence.EntityManager;
import likeLionSpringStudy.first_spring.domain.Member;

import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository {
    // JPA는 EntityManager을 가지고 모든 동작을 함.
    // 앞에서 추가해주었던 Member Entity에 대한 Management를 함.
    private final EntityManager em;

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    public Member save(Member member) {
        em.persist(member); //persist : 영구저장
        return member;
    }

    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id); //find하면 member을 return해줌.
        return Optional.ofNullable(member);
    }

    public List<Member> findAll() {
        // jqpl사용
        return em.createQuery("select m from Member m", Member.class).getResultList();
    }

    public Optional<Member> findByName(String name) {
        // findByName은 jpal이라는 객체지향쿼리를 사용해야 함.
        // 설명: 멤버 entity를 대상으로 쿼리를 날린다. -> sql로 번역됨.
        // select m : Member 자체를 select하게 됨
        List<Member> result = em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
        return result.stream().findAny();
    }
}
