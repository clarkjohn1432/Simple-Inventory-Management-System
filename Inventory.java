import java.util.ArrayList; 
import java.util.List;
// Inventory class
class Inventory extends InventoryOperation {
    public ArrayList<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
        System.out.println("Product added: " + product.getProductName() + " with quantity " + product.getQuantity());
    }

    public void removeProduct(String productId) throws InsufficientStockException {
        for (Product product : products) {
            if (product.getProductId().equals(productId)) {
                if (product.getQuantity() > 0) {
                    product.setQuantity(0);
                    System.out.println("Product " + productId + " removed successfully.");
                } else {
                    throw new InsufficientStockException("Insufficient stock for product " + product.getProductName() + ".");
                }
            }
        }
    }
}

