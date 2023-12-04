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
    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public  MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
    @Bean
    public DiscountPolicy discountPolicy() {
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

}
