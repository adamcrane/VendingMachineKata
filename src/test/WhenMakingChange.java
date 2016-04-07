package test;

import main.Coin;
import org.junit.Test;

import java.util.ArrayList;

import static main.Coin.Dime;
import static main.Coin.Quarter;
import static org.junit.Assert.*;
public class WhenMakingChange {

    @Test
    public void BalanceOfTwentyFiveCentsReturnsOneQuarter(){
        assertEquals(Quarter, GetChangeFor(.25));
    }

    @Test
    public void BalanceOf10CentsReturnsOneDime(){
        assertEquals(Dime, GetChangeFor(.10));
    }

    private Coin GetChangeFor(double v) {
        if(v == .10) return Dime;
        return Quarter;
    }
}
