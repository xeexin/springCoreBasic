package spring.springCoreBasic;

import spring.springCoreBasic.member.Grade;
import spring.springCoreBasic.member.Member;
import spring.springCoreBasic.member.MemberService;
import spring.springCoreBasic.order.Order;
import spring.springCoreBasic.order.OrderService;

public class OrderApp {
    public static void main(String[] args) {
//        MemberService memberService = new MemberServiceImpl();
//        OrderService orderService = new OrderServiceImpl();

        AppConfig appConfig = new AppConfig();

        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Long memberId=1L;

        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
        // System.out.println("calculatePrice = " + order.calculatePrice());
    }

}
