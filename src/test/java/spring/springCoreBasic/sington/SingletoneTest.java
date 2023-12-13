package spring.springCoreBasic.sington;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.springCoreBasic.AppConfig;
import spring.springCoreBasic.member.MemberService;

import static org.assertj.core.api.Assertions.*;

public class SingletoneTest {
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
        assertThat(memberService).isNotSameAs(memberService2);

    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void SingletonServiceTest() {
        SingletonService singletonService = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();

        System.out.println("SingtonService1 " + singletonService);
        System.out.println("SingtonService2 " + singletonService2);

        assertThat(singletonService).isEqualTo(singletonService2);
    }

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void SpringContainer() {
        //AppConfig appConfig = new AppConfig();
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService = ac.getBean("memberService", MemberService.class);
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);

         System.out.println("memberService1 " + memberService);
        System.out.println("memberService2 " + memberService2);

        // memberService != memberService2
        assertThat(memberService).isSameAs(memberService2);
    }
}
