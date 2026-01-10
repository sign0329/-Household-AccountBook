package com.ll.householdaccountbook.domain.category.dto;

import com.ll.householdaccountbook.domain.TransactionType;

public record CategoryRequest(
        String name,
        TransactionType type
) {}
