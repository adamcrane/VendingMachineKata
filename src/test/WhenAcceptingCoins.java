package test;

import main.VendingMachine;
import org.junit.Test;

import static org.junit.Assert.*;

public class WhenAcceptingCoins {

    @Test
    public void WhenNoCoinsAddedMachineDisplaysInsertCoin(){
        VendingMachine machine = new VendingMachine();
        assertEquals("Insert Coin", machine.GetMessage());
    }
}