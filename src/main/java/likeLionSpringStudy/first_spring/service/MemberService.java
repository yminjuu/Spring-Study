package likeLionSpringStudy.first_spring.service;

import likeLionSpringStudy.first_spring.domain.Member;
import likeLionSpringStudy.first_spring.repository.MemberRepository;
import likeLionSpringStudy.first_spring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
// command+Shift+T -> 자동으로 test class를 생성할 수 있음.
public class MemberService {

    private final MemberRepository memberRepository;

    // 생성자를 만들어 repository는 매개변수로 받음.
    // dependency injection (DI) : repository를 외부에서 넣어주는 방식 사용
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    /**
     * 회원가입
     */
    public Long join(Member member) {
        validateDuplicateMember(member);

        memberRepository.save(member);
        return member.getId();
    }

    // ctrl+t로 긴 로직을 메서드로 뽑을 수 있음.
    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName()).ifPresent(m -> {
            throw new IllegalStateException("중복 이름 존재");
        });
    }

    /**
     * 전체 회원 조회
     * @return
     */
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    /**
     * Id로 member 찾기
     * @param memberId
     * @return
     */
    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
