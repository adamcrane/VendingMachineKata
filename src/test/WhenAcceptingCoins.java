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
        machine.Insert(Unknown);
        assertEquals("Insert Coin", machine.GetMessage());
        assertTrue(machine.CoinReturn.contains(Unknown));
    }

    @Test
    public void MachineDisplays41AfterAllCoinsAndUnknown(){
        machine.Insert(Quarter);
        machine.Insert(Dime);
        machine.Insert(Penny);
        machine.Insert(Nickel);
        machine.Insert(Unknown);
        assertEquals("0.41", machine.GetMessage());
        assertTrue(machine.CoinReturn.contains(Unknown));
    }

}