

public class ShoppingCart {
    private List<Product> products;
    public void addProduct(Product product) {
        products.add(product);
    }
    public void removeProduct(Product product) {
        products.remove(product);
    }
    public double calculateTotalPrice() {
        double total = 0;
        // Lógica para calcular el precio total
        return total;
    }
    public void sendReceipt() {
        System.out.println("Sending receipt by email...");
        // Lógica para enviar el recibo
    }
}
