package fr.epita.bankaccount.launcher;

import fr.epita.bankaccount.datamodel.Customer;
import fr.epita.bankaccount.datamodel.InvestmentAccount;
import fr.epita.bankaccount.datamodel.SavingAccount;

import java.math.BigDecimal;
import java.util.Scanner;
import java.util.stream.StreamSupport;

public class Launcher {

    public static void main(String[] args) {
        System.out.println("Hello world");
        Customer Echo = new Customer("Echo","Paris");
        Customer quentin = new Customer("quentin","Paris");

        System.out.println(Echo);
        System.out.println(quentin);

        Scanner scanner = new Scanner(System.in);

        System.out.println("hello, please input a customer name: ");
        String name = scanner.nextLine();

        System.out.println("hello, please input a customer address: ");
        String address = scanner.nextLine();

        Customer customerFromConsole = new Customer(name, address);
        System.out.println("about to create this customer: "+ customerFromConsole);

        customerFromConsole.setName("123");

        SavingAccount account = new SavingAccount(123);

        InvestmentAccount investmentAccount = new InvestmentAccount(456);

        System.out.println("Please enter the initial balance from savings:");
        String initialBalance = scanner.nextLine();
        SavingAccount savingAccountFromConsole = new SavingAccount(Double.parseDouble(initialBalance));

        System.out.println("Please enter the initial balance from investment:");
        initialBalance = scanner.nextLine();
        InvestmentAccount investmentAccountFromConsole = new InvestmentAccount(Double.parseDouble(initialBalance));

        System.out.println(savingAccountFromConsole);
        System.out.println(investmentAccountFromConsole);

        scanner.close();

    }

}
