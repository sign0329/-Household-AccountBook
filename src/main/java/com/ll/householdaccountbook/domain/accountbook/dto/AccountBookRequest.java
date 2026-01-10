package com.ll.householdaccountbook.domain.accountbook.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record AccountBookRequest(
        //등록용
        String categoryName,
        int amount,
        String type,
        String memo,
        LocalDate transactionDate
) {
}
