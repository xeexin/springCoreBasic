package spring.springCoreBasic.order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spring.springCoreBasic.annotation.MainDiscountPolicy;
import spring.springCoreBasic.member.discount.DiscountPolicy;
import spring.springCoreBasic.member.Member;
import spring.springCoreBasic.member.MemberRepository;
@Component
//@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Autowired
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


    /// 테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
