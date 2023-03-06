package project.campsite.domain.controller;

import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter @Setter
public class MemberForm {

    @NotBlank(message = "회원 이름을 입력해주세요")
    @Size(min = 3, max = 10, message = "이름은 3 ~ 10자 이여야 합니다!")
    private String username;
    @NotBlank(message = "전화번호를 입력해주세요")
    private String number;


    @NotBlank(message = "이메일을 입력해주세요")
    @Email(message = "올바른 이메일 형식이 아닙니다.")
    private String email;

    @NotBlank(message = "비밀번호를 입력해주세요")
    private String password;

    private String checkPW;

    private String birth;

    private String city; //시,도
    private String street; //지역
    private String Zipcode; //우편번호
}
