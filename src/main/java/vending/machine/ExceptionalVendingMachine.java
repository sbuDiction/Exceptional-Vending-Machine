package vending.machine;

import vending.machine.exceptions.*;
import vending.machine.products.Chocolate;
import vending.machine.products.Product;
import vending.machine.products.SaltySnack;
import vending.machine.products.SoftDrink;

public class ExceptionalVendingMachine {
    private int softDrinksLevel = 0;
    private int chocolatesLevel = 0;
    private int saltySnacksLevel = 0;

    public ExceptionalVendingMachine(int softDrinksLevel, int chocolatesLevel, int saltySnacksLevel) {
        this.softDrinksLevel = softDrinksLevel;
        this.chocolatesLevel = chocolatesLevel;
        this.saltySnacksLevel = saltySnacksLevel;
    }

    public void buy(Product product, int qty) throws ProductNotFoundException {
        if (product instanceof SoftDrink) {
            if (softDrinksLevel - qty > 0) {
                softDrinksLevel -= qty;
            } else {
                throw new SoftDrinksOutOfStockException();
            }
        }

        if (product instanceof Chocolate) {
            if (chocolatesLevel - qty > 0) {
                chocolatesLevel -= qty;
            } else {
                throw new ChocolatesAllGoneException();
            }
        }

        if (product instanceof SaltySnack) {
            if (saltySnacksLevel - qty > 0) {
                saltySnacksLevel -= qty;
            } else {
                throw new SaltyCracksAllEatenException();
            }
        }

        if (product == null) {
            throw new InvalidProductException();
        }
    }

    public void addStock(Product product, int newStock) {
        if (product instanceof SoftDrink) softDrinksLevel += newStock;
        if (product instanceof Chocolate) chocolatesLevel += newStock;
        if (product instanceof SaltySnack) saltySnacksLevel += newStock;
    }

    public int getStock(Product product) {
        if (product instanceof SoftDrink) return softDrinksLevel;
        if (product instanceof Chocolate) return chocolatesLevel;
        if (product instanceof SaltySnack) return saltySnacksLevel;
        else return 0;
    }

    public int getSoftDrinksLevel() {
        return softDrinksLevel;
    }

    public int getChocolatesLevel() {
        return chocolatesLevel;
    }


    public int getSaltySnacksLevel() {
        return saltySnacksLevel;
    }
}
