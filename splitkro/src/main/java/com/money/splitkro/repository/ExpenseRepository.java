package com.money.splitkro.repository;

import com.money.splitkro.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    List<Expense> findByGroupId(Long groupId);
    List<Expense> findByPayerId(Long payerId);
}