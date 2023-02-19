package project.campsite.repository;

import org.springframework.stereotype.Repository;
import project.campsite.domain.member.Member;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class MemberRepository {
    @PersistenceContext
    EntityManager em;

    public Long save(Member member) {
        em.persist(member);
        return member.getId();
    }

    public Member find(Long id) {
        return em.find(Member.class, id);
    }

    /**
     * 전체 멤버 조회
     * @return
     */
    public List<Member> findAll(){
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }

    /**
     * 단일 멤버 조회
     * @param id
     * @param name
     * @return
     */
    public List<Member> findByName(Long id, String name){
        return em.createQuery("select m from Member m where m.id=?1 and m.name =?2", Member.class)
                .setParameter(1, id)
                .setParameter(2, name)
                .getResultList();
    }
}
