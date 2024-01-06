package com.haeny.spock

import com.haeny.spock.api.amount.constant.FeeCalculateType
import com.haeny.spock.api.amount.exception.NegativeNumberException
import spock.lang.Specification
import spock.lang.Unroll

import java.math.RoundingMode

class BasicUsageTest extends Specification {

    def "495를 원단위로 반올림하면 500이 된다"() {
        given:
        BigDecimal 금액 = BigDecimal.valueOf(495)

        when:
        BigDecimal 원단위_반올림 = 금액.setScale(-1, RoundingMode.HALF_UP)

        then:
        원단위_반올림 == 500
    }

    @Unroll
    def "금액이 주어지면 원단위 반올림 결과가 반환된다 [금액: #amount, 결과: #result]"() {
        given:
        def feeCalculator = FeeCalculateType.WON_UNIT_CUT

        expect:
        feeCalculator.calculate(amount) == result

        where:
        amount | result
        500L   | 500L
        495L   | 490L
    }

    def "음수가 입력되는 NegativeNumberException 발생한다"() {
        given:
        def feeCalculator = FeeCalculateType.WON_UNIT_CUT

        when:
        feeCalculator.calculate(-1)

        then:
        def e = thrown(NegativeNumberException.class)
        e.message == "음수는 허용하지 않습니다."
    }
}
