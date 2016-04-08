package test;

import main.ChangeGetter;
import main.Coin;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

import static main.Coin.*;
import static org.junit.Assert.*;
public class WhenMakingChange {

    private ChangeGetter getter;

    @Before
    public void Setup(){
        getter = new ChangeGetter();
    }
    @Test
    public void BalanceOfTwentyFiveCentsReturnsOneQuarter(){
        assertEquals(Quarter, getter.GetChangeFor(BigDecimal.valueOf(.25)).get(0));
    }

    @Test
    public void BalanceOfTenCentsReturnsOneDime(){
        assertEquals(Dime, getter.GetChangeFor(BigDecimal.valueOf(.10)).get(0));
    }

    @Test
    public void BalanceOfFiveCentsReturnsOneNickel(){
        assertEquals(Nickel, getter.GetChangeFor(BigDecimal.valueOf(.05)).get(0));
    }

    @Test
    public void BalanceOfOneCentReturnsOnePenny(){
        assertEquals(Penny, getter.GetChangeFor(BigDecimal.valueOf(.01)).get(0));
    }

    @Test
    public void BalanceOfFiftyCentsReturnsTwoQuarters(){
        ArrayList<Coin> coins = getter.GetChangeFor(BigDecimal.valueOf(.5));
        assertEquals(Quarter, coins.get(0));
        assertEquals(Quarter, coins.get(1));
    }

    @Test
    public void BalanceOfFourtyCentsReturnsQuarterDimeNickel(){
        ArrayList<Coin> coins = getter.GetChangeFor(BigDecimal.valueOf(.40));
        assertEquals(Quarter, coins.get(0));
        assertEquals(Dime, coins.get(1));
        assertEquals(Nickel, coins.get(2));
    }

    @Test
    public void BalanceOfFourtyThreeCentsReturnsQuarterDimeNickelPennyPennyPenny(){
        ArrayList<Coin> coins = getter.GetChangeFor(BigDecimal.valueOf(.40));
        assertEquals(Quarter, coins.get(0));
        assertEquals(Dime, coins.get(1));
        assertEquals(Nickel, coins.get(2));
        assertEquals(Penny, coins.get(3));
        assertEquals(Penny, coins.get(4));
        assertEquals(Penny, coins.get(5));
    }

    @Test
    public void BalanceOfThirtyFiveCentsReturnsQuarterAndDime(){
        ArrayList<Coin> coins = getter.GetChangeFor(BigDecimal.valueOf(.35));
        assertEquals(Quarter, coins.get(0));
        assertEquals(Dime, coins.get(1));
    }
}
