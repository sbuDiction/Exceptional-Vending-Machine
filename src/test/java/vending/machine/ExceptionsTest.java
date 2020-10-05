package vending.machine;

import org.junit.jupiter.api.Test;
import vending.machine.exceptions.*;
import vending.machine.products.Chocolate;
import vending.machine.products.SoftDrink;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ExceptionsTest {

    @Test
    public void softDrinksOutOfStockExceptionTest() {
        Throwable thrown = assertThrows(SoftDrinksOutOfStockException.class, () -> {
            ExceptionalVendingMachine vendingMachine = new ExceptionalVendingMachine(10, 5, 4);
            vendingMachine.buy(new SoftDrink(), 11);
        });
        assertEquals(thrown.getMessage(), "Soft drinks out of stock!");
    }

    @Test
    public void chocolatesAllGoneExceptionTest() {
        Throwable thrown = assertThrows(ChocolatesAllGoneException.class, () -> {
            ExceptionalVendingMachine vendingMachine = new ExceptionalVendingMachine(10, 5, 4);
            vendingMachine.buy(new Chocolate(), 6);
        });
        assertEquals(thrown.getMessage(), "Chocolates all gone!");
    }

    @Test
    public void saltyCracksAllEatenExceptionTest() {
        Throwable thrown = assertThrows(SaltyCracksAllEatenException.class, () -> {
            ExceptionalVendingMachine vendingMachine = new ExceptionalVendingMachine(10, 5, 4);
            vendingMachine.buy(new Chocolate(), 6);
        });
        assertEquals(thrown.getMessage(), "Salty cracks all eaten!");
    }

    @Test
    public void invalidProductExceptionTest() {
        Throwable thrown = assertThrows(InvalidProductException.class, () -> {
            ExceptionalVendingMachine vendingMachine = new ExceptionalVendingMachine(10, 5, 4);
            vendingMachine.buy(null, 6);
        });
        assertEquals(thrown.getMessage(), "Invalid product exception!");
    }
}
