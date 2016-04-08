package main;

import java.math.BigDecimal;
import java.util.ArrayList;

import static main.Coin.*;

public class ChangeGetter {
    public ArrayList<Coin> GetChangeFor(BigDecimal v) {
        ArrayList<Coin> coinsToReturn = new ArrayList<>();
        while(v.compareTo(BigDecimal.valueOf(.25)) > -1) {
            coinsToReturn.add(Quarter);
            v = v.subtract(BigDecimal.valueOf(.25));
        }
        while(v.compareTo(BigDecimal.valueOf(.10)) > -1) {
            coinsToReturn.add(Dime);
            v = v.subtract(BigDecimal.valueOf(.10));
        }
        if(v.compareTo(BigDecimal.valueOf(.05)) == 0) coinsToReturn.add(Nickel);
        while(v.compareTo(BigDecimal.valueOf(.01)) > -1) {
            coinsToReturn.add(Penny);
            v = v.subtract(BigDecimal.valueOf(.01));
        }

        return coinsToReturn;
    }
}
