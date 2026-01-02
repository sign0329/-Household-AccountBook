package com.ll.householdaccountbook.domain.category.dto;

import com.ll.householdaccountbook.domain.TransactionType;

public record CategoryResponse(
        Long id,
        String name,
        TransactionType type
) {
}
