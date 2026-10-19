import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/** Solo administra los productos y calcula el subtotal del carrito. */
public final class ShoppingCart {
    private final List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(Objects.requireNonNull(product, "product"));
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public double calculateTotalPrice() {
        double total = 0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }

    public List<Product> getProducts() {
        return Collections.unmodifiableList(products);
    }
}
