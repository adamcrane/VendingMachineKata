package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class VendingMachine {
    private double balance;
    public ArrayList<Coin> CoinReturn;
    private HashMap<String, Double> products;
    private Stack<String> displayMessages = new Stack<String>();

    public VendingMachine(){
        balance = 0.00;
        CoinReturn = new ArrayList<>();
        products = new HashMap<>();
        displayMessages.push("Insert Coin");
    }

    public String GetMessage() {
        if(displayMessages.peek().startsWith("PRICE")){
            return displayMessages.pop();
        }
        else {
            return displayMessages.peek();
        }
    }

    public void Insert(Coin coin) {
        if(CoinIsKnown(coin)) {
            balance += coin.getCoinValue();
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
        displayMessages.push("PRICE "+ String.format("%.2f", products.get(chips)));
    }
}
