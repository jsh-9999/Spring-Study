package hello.hellospring.member;

import hello.hellospring.AppConfig;
import hello.hellospring.order.OrderService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {
    MemberService memberService;

    @BeforeEach
    public void beforeEach(){ // test를 실행하기 전에 무조건 실행되는 것!
        AppConfig appConfig = new AppConfig();
        memberService=appConfig.memberService();
    }

    @Test
    void join(){
        //given
        Member member = new Member(1L,"memberA",Grade.VIP);

        //when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);
        //then
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
