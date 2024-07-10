package likeLionSpringStudy.first_spring.repository;

import likeLionSpringStudy.first_spring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{

    // static -> 개별 instance 가 아니라 class에 붙는 static 변수를 임시 db로 사용함
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L; //key값을 생성해주는 애

    @Override
    public Member save(Member member) {
//        멤버의 이름은 넘어온 상태라 가정, 알맞게 id를 set해주고 store에 넣어준다.
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
//        Nullable로 감쌌기 때문에 존재하지 않는 id이면 Null이 전달될 것임
    }

    @Override
    public Optional<Member> findByName(String username) {
        return store.values().stream().filter(member -> member.getName().equals(username)).findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }
}
