package test;

import main.Coin;
import main.VendingMachine;
import org.junit.Before;
import org.junit.Test;

import static main.Coin.Dime;
import static main.Coin.Quarter;
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
        machine.insert(Quarter);
        assertEquals("0.25", machine.GetMessage());
    }

    @Test
    public void MachineDisplays0_35WhenGivenQuarterAndDime(){
        machine.insert(Quarter);
        machine.insert(Dime);
        assertEquals("0.35", machine.GetMessage());
    }
}