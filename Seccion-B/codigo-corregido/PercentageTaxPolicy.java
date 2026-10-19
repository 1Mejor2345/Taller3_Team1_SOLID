/** Calcula un impuesto porcentual: por ejemplo, 0, 0.12 o 0.15. */
public final class PercentageTaxPolicy implements TaxPolicy {
    private final double rate;

    public PercentageTaxPolicy(double rate) {
        if (!Double.isFinite(rate) || rate < 0 || rate > 1) {
            throw new IllegalArgumentException("La tasa debe estar entre 0 y 1");
        }
        this.rate = rate;
    }

    @Override
    public double calculateTax(double price) {
        return price * rate;
    }
}
