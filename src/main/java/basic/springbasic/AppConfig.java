package basic.springbasic;

import basic.springbasic.discount.FixDiscountPolicy;
import basic.springbasic.member.MemberService;
import basic.springbasic.member.MemberServiceImpl;
import basic.springbasic.member.MemoryMemberRepository;
import basic.springbasic.order.OrderService;
import basic.springbasic.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}
