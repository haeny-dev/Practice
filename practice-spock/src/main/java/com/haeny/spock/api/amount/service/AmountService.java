package com.haeny.spock.api.amount.service;

import com.haeny.spock.api.amount.repository.AmountRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class AmountService {

    private final AmountRepository amountRepository;

    private Long amount;

    public void saveAmount() {
        amountRepository.save();
        amountRepository.save();
    }

}
