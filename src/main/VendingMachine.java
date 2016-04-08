package main;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

import static main.Coin.Quarter;

public class VendingMachine {
    private double balance;
    public ArrayList<Coin> CoinReturn;
    public ArrayList<Coin> CoinsInTransaction;
    private HashMap<String, Double> products;
    private Stack<String> displayMessages = new Stack<>();
    private ChangeGetter changeGetter;

    public VendingMachine(){
        balance = 0.00;
        CoinReturn = new ArrayList<>();
        CoinsInTransaction = new ArrayList<>();
        products = new HashMap<>();
        displayMessages.push("Insert Coin");
        changeGetter = new ChangeGetter();
    }

    public String GetMessage() {
        if(displayMessages.peek().startsWith("Thank You"))
        {
            String thankYou = displayMessages.pop();
            resetDisplayMessages();
            return thankYou;
        }
        if(displayMessages.peek().startsWith("PRICE")){
            return displayMessages.pop();
        }
        else {
            return displayMessages.peek();
        }
    }

    private void resetDisplayMessages() {
        displayMessages.clear();
        displayMessages.push("Insert Coin");
    }

    public void Insert(Coin coin) {
        if(CoinIsKnown(coin)) {
            balance += coin.getCoinValue();
            CoinsInTransaction.add(coin);
            displayMessages.push(String.format("%.2f", balance));
        }
        else {
            CoinReturn.add(coin);
        }
    }

    private boolean CoinIsKnown(Coin coin) {
        return coin != Coin.Unknown;
    }

    public void AddProduct(String product, double price) {
        products.put(product, price);
    }

    public double GetPriceOf(String product) {
        return products.get(product);
    }

    public void AttemptToPurchase(String chips) {
        if(balance >= products.get(chips)){
            displayMessages.push("Thank You");
            CoinReturn.addAll(changeGetter.GetChangeFor(BigDecimal.valueOf(balance - products.get(chips))));
            balance = 0.0;
        }
        else {
            displayMessages.push("PRICE " + String.format("%.2f", products.get(chips)));
        }
    }

    public void ReturnCoins() {
        CoinReturn.addAll(CoinsInTransaction);
        CoinsInTransaction.clear();
        resetDisplayMessages();
    }
}
