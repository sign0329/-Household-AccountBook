package com.ll.householdaccountbook.domain.accountbook.dto;

import com.ll.householdaccountbook.domain.TransactionType;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record AccountBookRequest(
        //등록용
        String categoryName,
        int amount,
        TransactionType transactionType,
        String memo,
        LocalDate transactionDate
) {
}
