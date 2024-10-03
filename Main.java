import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Inventory Management System ---");
            System.out.println("1. Add Perishable Product");
            System.out.println("2. Add Non-Perishable Product");
            System.out.println("3. Update Stock of Product");
            System.out.println("4. Remove Product");
            System.out.println("5. View All Products");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1: // Add Perishable Product
                    System.out.print("Enter Product ID: ");
                    String pId = scanner.nextLine();
                    System.out.print("Enter Product Name: ");
                    String pName = scanner.nextLine();
                    System.out.print("Enter Quantity: ");
                    int pQuantity = scanner.nextInt();
                    System.out.print("Enter Price: ");
                    double pPrice = scanner.nextDouble();
                    System.out.print("Enter Expiration Date (YYYY-MM-DD): ");
                    String expirationDate = scanner.next();
                    PerishableProduct perishableProduct = new PerishableProduct(pId, pName, pQuantity, pPrice, expirationDate);
                    inventory.addProduct(perishableProduct);
                    break;

                case 2: // Add Non-Perishable Product
                    System.out.print("Enter Product ID: ");
                    String npId = scanner.nextLine();
                    System.out.print("Enter Product Name: ");
                    String npName = scanner.nextLine();
                    System.out.print("Enter Quantity: ");
                    int npQuantity = scanner.nextInt();
                    System.out.print("Enter Price: ");
                    double npPrice = scanner.nextDouble();
                    System.out.print("Enter Shelf Life (days): ");
                    int shelfLife = scanner.nextInt();
                    NonPerishableProduct nonPerishableProduct = new NonPerishableProduct(npId, npName, npQuantity, npPrice, shelfLife);
                    inventory.addProduct(nonPerishableProduct);
                    break;

                case 3: // Update Stock of Product
                    System.out.print("Enter Product ID: ");
                    String productId = scanner.nextLine();
                    System.out.print("Enter Amount to Update: ");
                    int amount = scanner.nextInt();
                    try {
                        for (Product product : inventory.products) {
                            if (product.getProductId().equals(productId)) {
                                if (product instanceof PerishableProduct) {
                                    ((PerishableProduct) product).updateStock(amount);
                                } else if (product instanceof NonPerishableProduct) {
                                    ((NonPerishableProduct) product).updateStock(amount);
                                }
                                break;
                            }
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4: // Remove Product
                    System.out.print("Enter Product ID to Remove: ");
                    String removeId = scanner.nextLine();
                    try {
                        inventory.removeProduct(removeId);
                    } catch (InsufficientStockException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 5: // View All Products
                    System.out.println("\n--- List of Products ---");
                    for (Product product : inventory.products) {
                        String productType = product instanceof PerishableProduct ? "Perishable" : "Non-Perishable";
                        System.out.printf("ID: %s, Name: %s, Quantity: %d, Price: %.2f, Type: %s\n",
                                product.getProductId(), product.getProductName(), product.getQuantity(), product.getPrice(), productType);
                    }
                    break;

                case 6: // Exit
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
