package fr.epita.bankaccount.datamodel;

public class Customer {
    private String name;
    private String address;


    public Customer(String name, String address) {
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
