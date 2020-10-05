package vending.machine.exceptions;

public class InvalidProductException extends RuntimeException {
    public InvalidProductException() {
        super("Invalid product exception!");
    }
}
