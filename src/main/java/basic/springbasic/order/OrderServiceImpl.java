package basic.springbasic.order;

import basic.springbasic.discount.DiscountPolicy;
import basic.springbasic.discount.FixDiscountPolicy;
import basic.springbasic.member.Member;
import basic.springbasic.member.MemberRepository;
import basic.springbasic.member.MemoryMemberRepository;

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
