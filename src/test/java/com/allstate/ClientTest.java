package com.allstate;

import org.junit.Ignore;
import org.junit.Test;

import java.lang.reflect.AnnotatedElement;

import static org.junit.Assert.*;

/**
 * Created by sameer on 2/1/17.
 */
public class ClientTest {

    @Test
    public void isInitializedWithNameGenderAgeAndAccountBalance() {
        Client client = new Client("Hero", "male", 23, 5000);
        assertEquals("Hero", client.getName());
        assertEquals(5000, client.getBalance());
        assertEquals("male", client.getGender());
        assertTrue(23 == client.getAge());
    }

    @Test
    public void isInitialzedWithZeroBalanceWhenNotGiven() {
        Client client = new Client("Hero", "male", 23);
        assertEquals("Hero", client.getName());
        assertEquals("male", client.getGender());
        assertEquals(23, client.getAge());
    }

    @Test
    public void depositIncrementsBalance() {
        Client client = new Client("Hero", "male", 23, 500);
        client.deposit(50);
        assertEquals(550, client.getBalance());
    }
    @Test
    public void withdrawDecrementsBalance() {
        Client client = new Client("Hero", "male", 23, 500);
        client.withdraw(100);
        assertEquals(400, client.getBalance());
    }

    @Test
    public void purchaseShareReturnsFalseIfBalanceNotSufficient() {
        Client client = new Client("Hero", "male", 23);
        Portfolio portfolio = client.createPortfolio("Electronics");
        assertFalse(client.purchaseShare("Bajaj", 10, portfolio));
    }

    @Test
    public void createPortfolioCreatesPortfolios () {
        Client client = new Client("Hero", "male", 25);
        Portfolio pf1 = client.createPortfolio("Manufacturing");
        Portfolio pf2 = client.createPortfolio("Electronics");
        assertTrue(client.getListOfPortfolios().contains(pf1));
        assertTrue(client.getListOfPortfolios().contains(pf2));
    }

    @Test
    public void purchaseShareReturnsTrueIfBalanceAvailableAndUpdatesBalanceAndPortfolio() {
        Client client = new Client("Hero", "male", 23, 50000);
        Portfolio portfolio = client.createPortfolio("Electronics");
        assertTrue(client.purchaseShare("Bajaj", 10, portfolio));
        assertTrue(client.getBalance() < 50000);
        assertTrue(portfolio.getMapOfStocks().containsKey("Bajaj"));
        assertTrue(portfolio.getMapOfStocks().get("Bajaj") == 10);
    }

    @Test
    public void sellShareReturnsFalseIfNoSuchStockPresentOrNoOfSharesIsNotAvailable () {
        Client client = new Client("Hero", "male", 23, 2000);
        Portfolio portfolio = client.createPortfolio("Electronics");
        assertFalse(client.sellShare("Bajaj", 10, portfolio));
        portfolio.addStock("Bajaj", 8);
        assertFalse(client.sellShare("Bajaj", 10, portfolio));
    }

    @Test
    public void sellShareReturnsTrueInFavourableSituationsAndUpdatesBalanceAndPortFolio () {
        Client client = new Client("Hero", "male", 23, 5000);
        Portfolio portfolio = client.createPortfolio("Electronics");
        portfolio.addStock("Bajaj", 30);
        assertTrue(client.sellShare("Bajaj", 29, portfolio));
    }

    @Test
    public void deletePortfolioReturnsFalseIfNotEmpty () {
        Client client = new Client("Hero", "male", 23, 5000);
        Portfolio pf = client.createPortfolio("Technology");
        pf.addStock("Mahindra", 10);
        assertFalse(client.deletePortfolio(pf));
    }

    @Test
    public void deletePortfolioReturnsTrueIfEmpty () {
        Client client = new Client("Hero", "male", 23, 5000);
        Portfolio pf = client.createPortfolio("Technology");
        assertTrue(client.deletePortfolio(pf));
    }
    @Test
    public void positionReturnsTotalValueOfShares() {
        Client client = new Client("Hero", "male", 23, 5000);
        Portfolio pf = client.createPortfolio("Technology");
        Portfolio pf1 = client.createPortfolio("Electronics");
        client.purchaseShare("Apple", 11, pf1);
        client.purchaseShare("Google", 12, pf1);

        client.purchaseShare("Bajaj", 10, pf1);
        client.purchaseShare("Usha", 10, pf1);
// assert that its a number
        //assert( client.position())
    }

    @Test
    public void totalValueReturnsValueOfSharesInPortfolio() {
        Client client = new Client("Hero", "male", 23, 5000);
        Portfolio pf = client.createPortfolio("Technology");
        Portfolio pf1 = client.createPortfolio("Electronics");
// write assert here

    }
}