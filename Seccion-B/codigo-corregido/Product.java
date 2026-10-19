import java.util.Objects;

/** Datos comunes a cualquier producto, independientemente de si es fisico o digital. */
public abstract class Product {
    private final String name;
    private final double price;
    private final TaxPolicy taxPolicy;

    protected Product(String name, double price, TaxPolicy taxPolicy) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacio");
        }
        if (!Double.isFinite(price) || price < 0) {
            throw new IllegalArgumentException("El precio debe ser no negativo");
        }
        this.name = name;
        this.price = price;
        this.taxPolicy = Objects.requireNonNull(taxPolicy, "taxPolicy");
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public TaxPolicy getTaxPolicy() {
        return taxPolicy;
    }
}
