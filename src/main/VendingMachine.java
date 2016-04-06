package main;

public class VendingMachine {
    String displayMessage = "Insert Coin";

    public String GetMessage() {
        return displayMessage;
    }

    public void insert(String quarter) {
        displayMessage = "0.25";
    }
}
