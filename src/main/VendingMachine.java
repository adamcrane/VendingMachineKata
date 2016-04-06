package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class VendingMachine {
    private double balance;
    public ArrayList<Coin> CoinReturn;
    private HashMap<String, Double> products;

    public VendingMachine(){
        balance = 0.00;
        CoinReturn = new ArrayList<>();
        products = new HashMap<>();
    }

    public String GetMessage() {
        if(balance == 0) return "Insert Coin";
        return String.format("%.2f", balance);
    }

    public void Insert(Coin coin) {
        if(CoinIsKnown(coin)) {
            balance += coin.getCoinValue();
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
}
