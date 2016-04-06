package main;

public enum Coin {
    Quarter(.25), Dime(.10);

    private double coinValue;
    Coin(double v) {
        coinValue = v;
    }

    public double getCoinValue() {
        return coinValue;
    }
}
