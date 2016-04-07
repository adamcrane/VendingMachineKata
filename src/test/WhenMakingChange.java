package test;

import main.Coin;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static main.Coin.*;
import static org.junit.Assert.*;
public class WhenMakingChange {

    @Test
    public void BalanceOfTwentyFiveCentsReturnsOneQuarter(){
        assertEquals(Quarter, GetChangeFor(.25).get(0));
    }

    @Test
    public void BalanceOfTenCentsReturnsOneDime(){
        assertEquals(Dime, GetChangeFor(.10).get(0));
    }

    @Test
    public void BalanceOfFiveCentsReturnsOneNickel(){
        assertEquals(Nickel, GetChangeFor(.05).get(0));
    }

    @Test
    public void BalanceOfOneCentReturnsOnePenny(){
        assertEquals(Penny, GetChangeFor(.01).get(0));
    }

    @Test
    public void BalanceOfFiftyCentsReturnsTwoQuarters(){
        ArrayList<Coin> coins = GetChangeFor(.5);
        assertEquals(Quarter, coins.get(0));
        assertEquals(Quarter, coins.get(1));
    }
    private ArrayList<Coin> GetChangeFor(double v) {
        ArrayList<Coin> coinsToReturn = new ArrayList<>();
        while(v >= .25) {
            coinsToReturn.add(Quarter);
            v -= .25;
        }
        if(v == .10) coinsToReturn.add(Dime);
        if(v == .05) coinsToReturn.add(Nickel);
        if(v == .01) coinsToReturn.add(Penny);

        return coinsToReturn;
    }
}
