package spring.springCoreBasic;


import spring.springCoreBasic.discount.FixDiscountPolicy;
import spring.springCoreBasic.member.MemberService;
import spring.springCoreBasic.member.MemberServiceImpl;
import spring.springCoreBasic.member.MemoryMemberRepository;
import spring.springCoreBasic.order.OrderService;
import spring.springCoreBasic.order.OrderServiceImpl;

public class AppConfig {
    public MemberService memberService(){
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }

}
