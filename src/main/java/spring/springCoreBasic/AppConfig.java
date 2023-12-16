package spring.springCoreBasic;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.springCoreBasic.discount.DiscountPolicy;
import spring.springCoreBasic.discount.FixDiscountPolicy;
import spring.springCoreBasic.discount.RateDiscountPolicy;
import spring.springCoreBasic.member.MemberRepository;
import spring.springCoreBasic.member.MemberService;
import spring.springCoreBasic.member.MemberServiceImpl;
import spring.springCoreBasic.member.MemoryMemberRepository;
import spring.springCoreBasic.order.OrderService;
import spring.springCoreBasic.order.OrderServiceImpl;

@Configuration
public class AppConfig {
    // @Bean memberService() -> new MemoryMemberRepository();
    // @Bean orderService() -> new MemoryMemberRepository(), discountPolicy();
    // new MemoryMemberRepository() 두번 호출 --> 싱글톤이 위반 되는거 아닌가

    @Bean
    public MemberService memberService(){
        System.out.println("Call : AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public  MemberRepository memberRepository() {
        System.out.println("Call : AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }
    @Bean
    public OrderService orderService() {
        System.out.println("Call: AppConfig.orderService");
        //return new OrderServiceImpl(memberRepository(), discountPolicy());
        return null;
    }
    @Bean
    public DiscountPolicy discountPolicy() {
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

}
