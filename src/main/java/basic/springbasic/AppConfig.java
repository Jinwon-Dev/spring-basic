package basic.springbasic;

import basic.springbasic.discount.DiscountPolicy;
import basic.springbasic.discount.RateDiscountPolicy;
import basic.springbasic.member.MemberRepository;
import basic.springbasic.member.MemberService;
import basic.springbasic.member.MemberServiceImpl;
import basic.springbasic.member.MemoryMemberRepository;
import basic.springbasic.order.OrderService;
import basic.springbasic.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
