package project.campsite.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.campsite.domain.member.Member;
import project.campsite.repository.MemberRepository;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {
    private MemberRepository memberRepository;

    public Long join(Member member){
        validateDuplicateMember(member);

        memberRepository.save(member);
        return member.getId();
    }

    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Member findOne(Long id){
        return memberRepository.find(id);
    }

    /**
     * 회원가입 검증로직
     * @param member
     */
    private void validateDuplicateMember(Member member) {
        List<Member> findMembers = memberRepository.findByName(member.getId(), member.getUsername());

        if(!findMembers.isEmpty()){
            throw new IllegalStateException("이미 가입된 회원입니다.");
        }
    }
}
