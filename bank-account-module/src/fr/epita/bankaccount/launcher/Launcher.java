package fr.epita.bankaccount.launcher;

import fr.epita.bankaccount.datamodel.Customer;

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


    }
}
