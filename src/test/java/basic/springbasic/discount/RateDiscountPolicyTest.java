package basic.springbasic.discount;

import basic.springbasic.member.Grade;
import basic.springbasic.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다")
    void vip_o() {
        // Given
        Member member = new Member(1L, "memberVIP", Grade.VIP);

        // When
        int discount = discountPolicy.discount(member, 10000);

        // Then
        assertThat(discount).isEqualTo(1000); // static import를 하는게 좋다
    }

    @Test
    @DisplayName("VIP가 아니면 할인이 적용되지 않아야 한다")
    void vip_x() {
        // Given
        Member member = new Member(2L, "memberBASIC", Grade.BASIC);

        // When
        int discount = discountPolicy.discount(member, 10000);

        // Then
        assertThat(discount).isEqualTo(0);
    }

}