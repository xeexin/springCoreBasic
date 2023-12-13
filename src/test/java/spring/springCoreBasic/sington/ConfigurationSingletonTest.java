package spring.springCoreBasic.sington;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.springCoreBasic.AppConfig;
import spring.springCoreBasic.member.MemberRepository;
import spring.springCoreBasic.member.MemberService;
import spring.springCoreBasic.member.MemberServiceImpl;
import spring.springCoreBasic.order.OrderServiceImpl;

import static org.assertj.core.api.Assertions.*;

public class ConfigurationSingletonTest {
    @Test
    void configurationTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
        MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);

        MemberRepository memberRepository1 = ((MemberServiceImpl) memberService).getMemberRepository();
        MemberRepository memberRepository2 = orderService.getMemberRepository();

        System.out.println("MemberService -> memberRepository = " + memberRepository1);
        System.out.println("OrderService -> memberRepository = " + memberRepository2);
        System.out.println("MemberRepository = " + memberRepository);

        assertThat(((MemberServiceImpl) memberService).getMemberRepository()).isSameAs(memberRepository);
        assertThat(orderService.getMemberRepository()).isSameAs(memberRepository);
    }
}
