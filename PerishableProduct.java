// PerishableProduct class
class PerishableProduct extends Product {
    private String expirationDate;

    public PerishableProduct(String productId, String productName, int quantity, double price, String expirationDate) {
        super(productId, productName, quantity, price);
        this.expirationDate = expirationDate;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void updateStock(int amount) throws InsufficientStockException, InvalidQuantityException {
        if (amount < 0) throw new InvalidQuantityException("Quantity cannot be negative.");
        int newQuantity = getQuantity() + amount;
        if (newQuantity > 100) throw new InvalidQuantityException("Cannot exceed maximum quantity of 100 for perishable products.");
        setQuantity(newQuantity);
        System.out.println("Stock updated: " + getProductName() + " new quantity is " + getQuantity());
    }
}

// NonPerishableProduct class
class NonPerishableProduct extends Product {
    private int shelfLife;

    public NonPerishableProduct(String productId, String productName, int quantity, double price, int shelfLife) {
        super(productId, productName, quantity, price);
        this.shelfLife = shelfLife;
    }

    public int getShelfLife() {
        return shelfLife;
    }

    public void updateStock(int amount) throws InvalidQuantityException {
        if (amount < 0) throw new InvalidQuantityException("Quantity cannot be negative.");
        setQuantity(getQuantity() + amount);
        System.out.println("Stock updated: " + getProductName() + " new quantity is " + getQuantity());
    }
}

