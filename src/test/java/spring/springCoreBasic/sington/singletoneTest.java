package spring.springCoreBasic.sington;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import spring.springCoreBasic.AppConfig;
import spring.springCoreBasic.member.MemberService;

public class singletoneTest {
    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer() {
        AppConfig appConfig = new AppConfig();

        //1. 조회 : 호출할 때마다 객체를 생성
        MemberService memberService = appConfig.memberService();

        //2. 조회 : 호출할 때마다 객체를 생성
        MemberService memberService2 = appConfig.memberService();

        //3. 참조값이 다른 것을 확인 -> 클라이언트가 호출할 때마다, 다른 객체를 생성하면 비효율적임 
        System.out.println("memberService1 " + memberService);
        System.out.println("memberService2 " + memberService2);

        // memberService != memberService2
        Assertions.assertThat(memberService).isNotSameAs(memberService2);

    }
}
