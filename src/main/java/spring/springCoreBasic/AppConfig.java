package spring.springCoreBasic;


import spring.springCoreBasic.discount.DiscountPolicy;
import spring.springCoreBasic.discount.FixDiscountPolicy;
import spring.springCoreBasic.member.MemberRepository;
import spring.springCoreBasic.member.MemberService;
import spring.springCoreBasic.member.MemberServiceImpl;
import spring.springCoreBasic.member.MemoryMemberRepository;
import spring.springCoreBasic.order.OrderService;
import spring.springCoreBasic.order.OrderServiceImpl;

public class AppConfig {
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    private static MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }

}
