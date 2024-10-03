// Custom exceptions
class InsufficientStockException extends Exception {
    public InsufficientStockException(String message) {
        super(message);
    }
}

class InvalidQuantityException extends Exception {
    public InvalidQuantityException(String message) {
        super(message);
    }
}