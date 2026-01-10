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
import org.springframework.security.core.parameters.P;

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



    public AccountBook(Long userId, String categoryName, int amount, TransactionType transactionType, String memo, LocalDate transactionDate){
        this.userId = userId;
        this.categoryName = categoryName;
        this.amount = amount;
        this.transactionType = transactionType;
        this.memo = memo;
        this.transactionDate = transactionDate;
    }

    private AccountBook(Long userId, int amount, TransactionType transactionType, String memo, LocalDate transactionDate) {
        this.userId = userId;
        this.amount = amount;
        this.transactionType = transactionType;
        this.memo = memo;
        this.transactionDate = transactionDate;
    }

    public static AccountBook create(Long userId, int amount, TransactionType transactionType, String memo, LocalDate transactionDate) {

        validate(amount, transactionType, transactionDate);

        return new AccountBook(userId, amount, transactionType, memo, transactionDate);
    }

    private static void validate(int amount, TransactionType transactionType, LocalDate transactionDate) {
        if(amount < 0) {
            throw new IllegalArgumentException("금액이 0보다 커야합니다");
        }
        if (transactionType == null) {
            throw new IllegalArgumentException("거래 타입은 필수입니다");
        }
        if(transactionDate == null){
            throw new IllegalArgumentException("거래 날짜는 필수입니다");
        }
    }
}
