package spring.springCoreBasic.order;
import spring.springCoreBasic.discount.DiscountPolicy;
import spring.springCoreBasic.discount.FixDiscountPolicy;
import spring.springCoreBasic.member.Member;
import spring.springCoreBasic.member.MemberRepository;
import spring.springCoreBasic.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
