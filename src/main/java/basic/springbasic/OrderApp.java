package basic.springbasic;

import basic.springbasic.member.Grade;
import basic.springbasic.member.Member;
import basic.springbasic.member.MemberService;
import basic.springbasic.order.Order;
import basic.springbasic.order.OrderService;

public class OrderApp {
    public static void main(String[] args) {

        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
    }
}
