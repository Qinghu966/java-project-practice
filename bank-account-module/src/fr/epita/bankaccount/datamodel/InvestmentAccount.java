package fr.epita.bankaccount.datamodel;

public class InvestmentAccount extends Account{


    public InvestmentAccount(double initialBalance) {
        super(initialBalance);
    }

    @Override
    public String toString() {
        return "InvestmentAccount{" +
                super.toString() +
                '}';
    }
}
