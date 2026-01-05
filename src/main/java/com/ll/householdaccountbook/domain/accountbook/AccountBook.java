package com.ll.householdaccountbook.domain.accountbook;

import com.ll.householdaccountbook.domain.category.Category;
import com.ll.householdaccountbook.domain.user.User;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Locale;

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

    private String type;

    private String memo;

    private LocalDateTime transactionDate;

    protected  AccountBook(Long userId, String categoryName, int amount, String type, String memo, LocalDateTime transactionDate){

        this.userId = userId;
        this.categoryName = categoryName;
        this.amount = amount;
        this.type = type;
        this.memo = memo;
        this.transactionDate = LocalDateTime.now();
    }

}
