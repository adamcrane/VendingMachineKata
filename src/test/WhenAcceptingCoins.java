package test;

import main.Coin;
import main.VendingMachine;
import org.junit.Before;
import org.junit.Test;

import static main.Coin.*;
import static org.junit.Assert.*;

public class WhenAcceptingCoins {

    private VendingMachine machine;

    @Before
    public void setUp() throws Exception {
        machine = new VendingMachine();
    }

    @Test
    public void WhenNoCoinsAddedMachineDisplaysInsertCoin(){
        assertEquals("Insert Coin", machine.GetMessage());
    }

    @Test
    public void MachineDisplays0_25WhenQuarterEntered(){
        machine.Insert(Quarter);
        assertEquals("0.25", machine.GetMessage());
    }

    @Test
    public void MachineDisplays0_35WhenGivenQuarterAndDime(){
        machine.Insert(Quarter);
        machine.Insert(Dime);
        assertEquals("0.35", machine.GetMessage());
    }

    @Test
    public void MachineDisplays0_06WhenGivenNickelAndPenny(){
        machine.Insert(Penny);
        machine.Insert(Nickel);
        assertEquals("0.06", machine.GetMessage());
    }

    @Test
    public void MachineStillDisplaysInsertCoinAfterUnknownCoinInserted(){
        Coin unkownCoin = Unknown;
        machine.Insert(unkownCoin);
        assertEquals("Insert Coin", machine.GetMessage());
        assertTrue(machine.CoinReturn.contains(unkownCoin));
    }
}