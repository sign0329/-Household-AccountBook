package com.ll.householdaccountbook.domain.accountbook;

import com.ll.householdaccountbook.domain.TransactionType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "account_books")
public class AccountBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private String categoryName;

    private int amount;

    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

    private String memo;

    private LocalDate transactionDate;



    public AccountBook(Long userId, String categoryName, int amount, String transactionType, String memo, LocalDate transactionDate){

        this.userId = userId;
        this.categoryName = categoryName;
        this.amount = amount;
        this.transactionType = getTransactionType();
        this.memo = memo;
        this.transactionDate = transactionDate;
    }

}
