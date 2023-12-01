package spring.springCoreBasic.order;
import spring.springCoreBasic.discount.DiscountPolicy;
import spring.springCoreBasic.discount.FixDiscountPolicy;
import spring.springCoreBasic.discount.RateDiscountPolicy;
import spring.springCoreBasic.member.Member;
import spring.springCoreBasic.member.MemberRepository;
import spring.springCoreBasic.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
