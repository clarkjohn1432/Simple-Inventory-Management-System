// Abstract class for inventory operations
abstract class InventoryOperation {
    public abstract void addProduct(Product product);
    public abstract void removeProduct(String productId) throws InsufficientStockException;
}
