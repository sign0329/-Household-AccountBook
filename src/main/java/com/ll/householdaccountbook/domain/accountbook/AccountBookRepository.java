package com.ll.householdaccountbook.domain.accountbook;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountBookRepository extends JpaRepository<AccountBook, Long> {
    List<AccountBook> findByUserId(Long userId);
}
