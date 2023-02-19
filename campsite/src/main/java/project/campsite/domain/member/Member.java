package project.campsite.domain.member;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Getter @Setter
public class Member {
    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;
    private String username;
    private String number;
    private String email;

    private String password;
    private String birth;
    @Embedded
    private Address address;

    /**
     * 사용자와 관리자의 아이디를 구별할 수 있는 필드
     */
    private String admin;
}
