/** Un producto fisico tiene peso y un impuesto configurable. */
public final class PhysicalProduct extends Product implements Weighable {
    private final double weight;

    public PhysicalProduct(String name, double price, double weight, TaxPolicy taxPolicy) {
        super(name, price, taxPolicy);
        if (!Double.isFinite(weight) || weight < 0) {
            throw new IllegalArgumentException("El peso debe ser no negativo");
        }
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return weight;
    }
}
