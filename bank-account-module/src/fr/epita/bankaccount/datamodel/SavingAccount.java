package fr.epita.bankaccount.datamodel;

public class SavingAccount extends Account{

    protected double interestRate;

    public SavingAccount(double initialBalance){
        super(initialBalance);
        this.balance = initialBalance;
    }

    public double computeInterests(){
        return this.interestRate * balance;
    }
    public void withdraw(double amount){
        this.balance = this.balance - amount;
        this.balance = amount;
    }

}
