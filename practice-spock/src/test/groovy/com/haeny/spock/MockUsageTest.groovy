package com.haeny.spock

import com.haeny.spock.api.amount.constant.FeeCalculateType
import com.haeny.spock.api.amount.repository.AmountRepository
import com.haeny.spock.api.amount.service.AmountService
import spock.lang.Specification

class MockUsageTest extends Specification {

    def "API를 통해 받은 값을 원단위 버림 계산한다."() {
        given:
        def mockAmountService = Mock(AmountService.class)

        when:
        long amount = mockAmountService.getAmount()

        then:
        mockAmountService.getAmount() >> 999
        999 == amount
        990L == FeeCalculateType.WON_UNIT_CUT.calculate(amount)
    }

    def "Service의 saveAmount 호출 시 Repository의 save 메소드가 2번 호출된다."() {
        given:
        def mockAmountRepository = Mock(AmountRepository.class)
        AmountService amountService = new AmountService(mockAmountRepository)

        when:
        amountService.saveAmount()

        then:
        2 * mockAmountRepository.save()
    }
}
