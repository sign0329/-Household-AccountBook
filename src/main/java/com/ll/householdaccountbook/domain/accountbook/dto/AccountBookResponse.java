package com.ll.householdaccountbook.domain.accountbook.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record AccountBookResponse(
        //화면전달용
        LocalDate transactionDate,
        String categoryName,
        int amount,
        String type,
        String memo
) {

}
