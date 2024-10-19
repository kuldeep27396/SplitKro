package com.money.splitkro.util;

import com.money.splitkro.model.Expense;
import com.money.splitkro.model.User;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DebtCalculator {

    public static Map<User, Map<User, BigDecimal>> calculateDebts(List<Expense> expenses, List<User> users) {
        Map<User, BigDecimal> balances = new HashMap<>();
        Map<User, Map<User, BigDecimal>> debts = new HashMap<>();

        // Initialize balances and debts
        for (User user : users) {
            balances.put(user, BigDecimal.ZERO);
            debts.put(user, new HashMap<>());
            for (User otherUser : users) {
                if (!user.equals(otherUser)) {
                    debts.get(user).put(otherUser, BigDecimal.ZERO);
                }
            }
        }

        // Calculate balances
        for (Expense expense : expenses) {
            User payer = expense.getPayer();
            BigDecimal amount = expense.getAmount();
            BigDecimal splitAmount = amount.divide(BigDecimal.valueOf(users.size()), 2, RoundingMode.HALF_UP);

            balances.put(payer, balances.get(payer).add(amount.subtract(splitAmount)));
            for (User user : users) {
                if (!user.equals(payer)) {
                    balances.put(user, balances.get(user).subtract(splitAmount));
                }
            }
        }

        // Calculate debts
        for (User debtor : users) {
            for (User creditor : users) {
                if (!debtor.equals(creditor)) {
                    BigDecimal debtAmount = balances.get(debtor).min(balances.get(creditor).negate());
                    if (debtAmount.compareTo(BigDecimal.ZERO) > 0) {
                        debts.get(debtor).put(creditor, debtAmount);
                        balances.put(debtor, balances.get(debtor).add(debtAmount));
                        balances.put(creditor, balances.get(creditor).subtract(debtAmount));
                    }
                }
            }
        }

        return debts;
    }
}