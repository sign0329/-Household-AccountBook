package com.ll.householdaccountbook;

import com.ll.householdaccountbook.domain.TransactionType;
import com.ll.householdaccountbook.domain.accountbook.AccountBook;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;
import java.time.LocalDate;

@SpringBootTest
class HouseholdAccountBookApplicationTests {

    @Test
    @DisplayName("지출 가계부 생성")
    void createExpenseAccountBook() {
        // given
        Long userId = 1L;
        int amount = 15000;
        TransactionType transactionType = TransactionType.EXPENSE;
        String memo = "점심 식사";
        LocalDate transactionDate = LocalDate.now();

        // when
        AccountBook accountBook = AccountBook.create(
                userId,
                amount,
                transactionType,
                memo,
                transactionDate
        );

        // then
        assertThat(accountBook).isNotNull();
        assertThat(accountBook.getUserId()).isEqualTo(userId);
        assertThat(accountBook.getAmount()).isEqualTo(amount);
        assertThat(accountBook.getTransactionType()).isEqualTo(TransactionType.EXPENSE);
        assertThat(accountBook.getMemo()).isEqualTo("점심 식사");
        assertThat(accountBook.getTransactionDate()).isEqualTo(transactionDate);
    }
    }


}
