import java.util.Objects;

/** Calcula IVA sin switch ni conocimiento de categorias concretas. */
public final class IvaCalculator {
    public double calculateIVA(Product product) {
        Objects.requireNonNull(product, "product");
        return product.getTaxPolicy().calculateTax(product.getPrice());
    }
}
