package basic.springbasic;

import basic.springbasic.member.Grade;
import basic.springbasic.member.Member;
import basic.springbasic.member.MemberService;
import basic.springbasic.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("fine Member = " + findMember.getName());
    }
}
