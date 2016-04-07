package test;

import main.VendingMachine;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class WhenSelectingAProduct {

    private VendingMachine machine;

    @Before
    public void setUp() throws Exception {
        machine = new VendingMachine();
        machine.AddProduct("Chips", .5);
        machine.AddProduct("Cola", 1.0);
        machine.AddProduct("Candy", .65);
    }

    @Test
    public void MachineHasColaPricedAtOneDollar(){
        assertEquals(1.0, machine.GetPriceOf("Cola"),0.001);
    }

    @Test
    public void MachineHasChipsPricedAtFiftyCents(){
        assertEquals(.5, machine.GetPriceOf("Chips"),0.001);
    }

    @Test
    public void MachineHasCandyPricedAtSixtyFiveCents(){
        assertEquals(.65, machine.GetPriceOf("Candy"),0.001);
    }

    @Test
    public void MachineDisplaysPriceSixtyFiveCentsThenInsertCoinWhenNoFunds(){
        machine.AttemptToPurchase("Candy");
        assertEquals("PRICE 0.65", machine.GetMessage());
        assertEquals("Insert Coin", machine.GetMessage());
    }
}
