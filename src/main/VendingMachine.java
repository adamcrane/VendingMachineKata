package main;

public class VendingMachine {
    double balance;

    public VendingMachine(){
        balance = 0.00;
    }

    public String GetMessage() {
        if(balance == 0) return "Insert Coin";
        return String.format("%.2f", balance);
    }

    public void insert(Coin quarter) {
        balance+=quarter.getCoinValue();
    }
}
