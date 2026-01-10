package com.ll.householdaccountbook.domain.accountbook;

import com.ll.householdaccountbook.domain.accountbook.dto.AccountBookRequest;
import com.ll.householdaccountbook.domain.accountbook.dto.AccountBookResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountBookService {

    private final AccountBookRepository accountBookRepository;

            public List<AccountBookResponse> findAll(Long userId){
                return accountBookRepository.findByUserId(userId)
                        .stream()
                        .map(a -> new AccountBookResponse(
                                a.getTransactionDate(),
                                a.getCategoryName(),
                                a.getAmount(),
                                a.getTransactionType(),
                                a.getMemo()
                        ))
                        .toList();
            }

            public void save(Long userId, AccountBookRequest request){
                AccountBook accountBook = new AccountBook(
                        userId,
                        request.categoryName(),
                        request.amount(),
                        request.transactionType(),
                        request.memo(),
                        request.transactionDate()
                );
            }

            public void create(Long userId, AccountBookRequest request){

            }

}
