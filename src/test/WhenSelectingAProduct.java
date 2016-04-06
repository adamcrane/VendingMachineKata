package test;

import main.VendingMachine;
import org.junit.Test;
import static org.junit.Assert.*;

public class WhenSelectingAProduct {

    @Test
    public void MachineHasColaPricedAtOneDollar(){
        VendingMachine machine = new VendingMachine();
        machine.AddProduct("Cola", 1.0);
        assertEquals(1.0, machine.GetPriceOf("Cola"),0.001);
    }

    @Test
    public void MachineHasChipsPricedAtFiftyCents(){
        VendingMachine machine = new VendingMachine();
        machine.AddProduct("Chips", .5);
        assertEquals(.5, machine.GetPriceOf("Chips"),0.001);
    }
}
