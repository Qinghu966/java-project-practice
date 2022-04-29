package fr.epita.bankaccount.datamodel;

import java.math.BigDecimal;

public class Account {

    protected Double balance;

    public Account(double initialBalance){
        this.balance = initialBalance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                '}';
    }
}
