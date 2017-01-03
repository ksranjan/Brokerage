package com.allstate;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by sameer on 2/1/17.
 */
public class Brokerage {
    private String name;

    private List<Client> listOfClients = new ArrayList<Client>();
    public Brokerage(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addClient(Brokerage broker, Client client) {
        broker.listOfClients.add(client);
    }

    public static void main(String[] args) {
        Brokerage broker = new Brokerage("ZeroDHA");
        Client client = new Client("Anjesh", "male", 25);
        broker.addClient(client);
        client.deposit(4000);
        Portfolio portfolio = client.createPortfolio("Technology");
        Portfolio portfolio1 = client.createPortfolio("Electronics");
        System.out.println("initial state \n" + client);
        client.purchaseShare("Apple", 30, portfolio);
        System.out.println("after purchases \n" + client);
        client.withdraw(100);
        System.out.println("after withdrawal " + client.getBalance());
        client.sellShare("Apple", 15, portfolio);
        client.deletePortfolio(portfolio1);
        System.out.println("After deleting portfolio1 and some selling of shares \n" + client);
        System.out.println("total value in portfolio " + client.totalValue(portfolio));
        System.out.println("total value of all portfolios  " + client.position());
    }



}
