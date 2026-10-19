/** Un producto digital no ofrece getWeight(), por lo que no rompe LSP. */
public final class DigitalProduct extends Product {
    public DigitalProduct(String name, double price) {
        // En el ejemplo original, el tipo "digital" no tenia una tasa definida (IVA = 0).
        super(name, price, new PercentageTaxPolicy(0.0));
    }
}
