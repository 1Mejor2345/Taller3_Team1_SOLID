/** Estrategia de calculo del impuesto para un producto. */
public interface TaxPolicy {
    double calculateTax(double price);
}
