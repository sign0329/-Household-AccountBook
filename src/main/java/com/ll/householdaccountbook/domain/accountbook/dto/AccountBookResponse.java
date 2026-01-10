package com.ll.householdaccountbook.domain.accountbook.dto;

import com.ll.householdaccountbook.domain.TransactionType;

import java.time.LocalDate;

public record AccountBookResponse(
        //화면전달용
        LocalDate transactionDate,
        String categoryName,
        int amount,
        TransactionType type,
        String memo
) {

}
