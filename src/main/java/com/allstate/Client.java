package com.allstate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by sameer on 2/1/17.
 */
public class Client {
    private List<Portfolio> listOfPortfolios = new ArrayList<Portfolio>();
    private String name;
    private String gender;

    public List<Portfolio> getListOfPortfolios() {
        return listOfPortfolios;
    }

    private int age;
    private int balance;

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public Client(String name, String gender, int age) {
        this(name, gender, age, 0);
    }

    public Client(String name, String gender, int age, int balance) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.balance = balance;
    }

    public void deposit(int amount) {
        balance += amount;
    }

    public void withdraw(int amount) {
        balance -= amount;
    }

    public boolean purchaseShare(String name , int noOfShares, Portfolio portfolio) {
        int required = Stock.getShareQuote(name).getPrice() * noOfShares;
        if(balance < required) {
            return false;
        }
        balance -= required;
        portfolio.addStock(name, noOfShares);
        return true;
    }
    public boolean sellShare(String name, int noOfShares, Portfolio portfolio) {
        if(portfolio.sellStock(name, noOfShares)){
            balance += Stock.getShareQuote(name).getPrice() * noOfShares;
            return true;
        }
        return false;
    }

    public Portfolio createPortfolio(String name) {
        Portfolio portfolio = new Portfolio(name);
        listOfPortfolios.add(portfolio);
        return portfolio;
    }

    public boolean deletePortfolio(Portfolio portfolio) {
        if(portfolio.getMapOfStocks().isEmpty()) {
            listOfPortfolios.remove(portfolio);
            return true;
        }
        return false;
    }

    public int totalValue(Portfolio pf) {
        int amount = 0;
        for(int j =0; j< pf.getMapOfStocks().values().toArray().length; j++) {
            amount += Integer.parseInt(pf.getMapOfStocks().values().toArray()[j].toString());
        }
        return amount;
    }

    public int position() {
        int amount = 0;
        for(int i = 0; i < listOfPortfolios.size(); i++) {
//            for(int j= 0; j < listOfPortfolios.get(i).getMapOfStocks().values().toArray().le)
            for(int j =0; j< listOfPortfolios.get(i).getMapOfStocks().values().toArray().length; j++) {
                amount += Integer.parseInt(listOfPortfolios.get(i).getMapOfStocks().values().toArray()[j].toString());
            }
        }
        return amount;
    }

    @Override
    public String toString() {
        return "Client{" +
                "listOfPortfolios=" + listOfPortfolios +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", balance=" + balance +
                '}';
    }
}
