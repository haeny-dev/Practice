package com.haeny.spock;

import static org.assertj.core.api.Assertions.*;

import com.haeny.spock.api.amount.constant.FeeCalculateType;
import com.haeny.spock.api.amount.exception.NegativeNumberException;
import org.junit.jupiter.api.Test;

class BasicUsageJavaTest {

    @Test
    void calculate_금액이_주어지면_원단위_반올림_결과가_반환된다() throws Exception {
        // given
        FeeCalculateType feeCalculator = FeeCalculateType.WON_UNIT_CUT;

        // when & then
        final long case1 = feeCalculator.calculate(500);
        assertThat(case1).isEqualTo(500L);

        final long case2 = feeCalculator.calculate(495);
        assertThat(case2).isEqualTo(490L);
    }

    @Test
    void calculate_음수가입력되면_throwNagativeNumberException() throws Exception {
        // given
        FeeCalculateType feeCalculator = FeeCalculateType.WON_UNIT_CUT;

        // when & then
        assertThatThrownBy(() -> feeCalculator.calculate(-1))
            .isInstanceOf(NegativeNumberException.class)
            .hasMessage("음수는 허용하지 않습니다.");
    }

}