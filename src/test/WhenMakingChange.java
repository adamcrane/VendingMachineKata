package test;

import main.Coin;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

import static main.Coin.*;
import static org.junit.Assert.*;
public class WhenMakingChange {

    @Test
    public void BalanceOfTwentyFiveCentsReturnsOneQuarter(){
        assertEquals(Quarter, GetChangeFor(BigDecimal.valueOf(.25)).get(0));
    }

    @Test
    public void BalanceOfTenCentsReturnsOneDime(){
        assertEquals(Dime, GetChangeFor(BigDecimal.valueOf(.10)).get(0));
    }

    @Test
    public void BalanceOfFiveCentsReturnsOneNickel(){
        assertEquals(Nickel, GetChangeFor(BigDecimal.valueOf(.05)).get(0));
    }

    @Test
    public void BalanceOfOneCentReturnsOnePenny(){
        assertEquals(Penny, GetChangeFor(BigDecimal.valueOf(.01)).get(0));
    }

    @Test
    public void BalanceOfFiftyCentsReturnsTwoQuarters(){
        ArrayList<Coin> coins = GetChangeFor(BigDecimal.valueOf(.5));
        assertEquals(Quarter, coins.get(0));
        assertEquals(Quarter, coins.get(1));
    }

    @Test
    public void BalanceOfThirtyFiveCentsReturnsQuarterAndDime(){
        ArrayList<Coin> coins = GetChangeFor(BigDecimal.valueOf(.35));
        assertEquals(Quarter, coins.get(0));
        assertEquals(Dime, coins.get(1));
    }
    private ArrayList<Coin> GetChangeFor(BigDecimal v) {
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
        if(v.compareTo(BigDecimal.valueOf(.01)) == 0) coinsToReturn.add(Penny);

        return coinsToReturn;
    }
}
