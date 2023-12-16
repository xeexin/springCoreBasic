package spring.springCoreBasic.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import spring.springCoreBasic.discount.FixDiscountPolicy;
import spring.springCoreBasic.member.Grade;
import spring.springCoreBasic.member.Member;
import spring.springCoreBasic.member.MemoryMemberRepository;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {
    @Test
    void createOrder() {
        MemoryMemberRepository memberRepository = new MemoryMemberRepository();
        memberRepository.save(new Member(1L,"name", Grade.VIP));

        OrderServiceImpl orderService = new OrderServiceImpl(memberRepository, new FixDiscountPolicy());
        Order order = orderService.createOrder(1L, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

}