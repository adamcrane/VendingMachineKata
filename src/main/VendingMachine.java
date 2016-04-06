package main;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
    double balance;
    public ArrayList<Coin> CoinReturn;

    public VendingMachine(){
        balance = 0.00;
        CoinReturn = new ArrayList<>();
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
}
