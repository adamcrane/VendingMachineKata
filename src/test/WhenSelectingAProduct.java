package test;

import main.VendingMachine;
import org.junit.Before;
import org.junit.Test;

import static main.Coin.Dime;
import static main.Coin.Quarter;
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

    @Test
    public void MachineDisplaysPriceSixtyFiveCentsThenTwentyFiveCentsWhenOnlyQuarter(){
        machine.Insert(Quarter);
        machine.AttemptToPurchase("Candy");
        assertEquals("PRICE 0.65", machine.GetMessage());
        assertEquals("0.25", machine.GetMessage());
    }

    @Test
    public void MachineDisplaysThankYouThenInsertCoinsWhenEvenChange(){
        machine.Insert(Quarter);
        machine.Insert(Quarter);
        machine.AttemptToPurchase("Chips");
        assertEquals("Thank You", machine.GetMessage());
        assertEquals("Insert Coin", machine.GetMessage());
    }

    @Test
    public void MachineDisplaysThankYouThenInsertCoinsAndReturnCoinsWhenLeftOver(){
        machine.Insert(Quarter);
        machine.Insert(Quarter);
        machine.Insert(Quarter);
        machine.Insert(Dime);
        machine.AttemptToPurchase("Chips");
        assertEquals("Thank You", machine.GetMessage());
        assertEquals("Insert Coin", machine.GetMessage());
        assertEquals(Quarter, machine.CoinReturn.get(0));
        assertEquals(Dime, machine.CoinReturn.get(1));
    }
}
