package spring.springCoreBasic.order;

//import org.springframework.core.annotation.Order;

import spring.springCoreBasic.member.MemberRepository;

public interface OrderService {
    //Order createOrder(Long memberId, String itemName, int itemPrice);
    Order createOrder(Long memberId, String itemName, int itemPrice);

}
