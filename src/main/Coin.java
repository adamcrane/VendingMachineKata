package main;

public enum Coin {
    Quarter(.25), Dime(.10), Penny(.01), Nickel(.05), Unknown(-1);

    private double coinValue;
    Coin(double v) {
        coinValue = v;
    }

    public double getCoinValue() {
        return coinValue;
    }
}
