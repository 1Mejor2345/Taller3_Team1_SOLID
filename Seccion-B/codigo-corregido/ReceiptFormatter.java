import java.util.Locale;
import java.util.Objects;

/** Se responsabiliza exclusivamente del formato del recibo. */
public final class ReceiptFormatter {
    private final IvaCalculator ivaCalculator;

    public ReceiptFormatter(IvaCalculator ivaCalculator) {
        this.ivaCalculator = Objects.requireNonNull(ivaCalculator, "ivaCalculator");
    }

    public String format(ShoppingCart cart) {
        Objects.requireNonNull(cart, "cart");
        StringBuilder text = new StringBuilder("=== RECIBO ===\n");
        double taxes = 0;
        for (Product product : cart.getProducts()) {
            text.append(String.format(Locale.US, "%s: $%.2f%n",
                product.getName(), product.getPrice()));
            taxes += ivaCalculator.calculateIVA(product);
        }
        double subtotal = cart.calculateTotalPrice();
        text.append(String.format(Locale.US,
            "Subtotal: $%.2f%nIVA: $%.2f%nTotal: $%.2f",
            subtotal, taxes, subtotal + taxes));
        return text.toString();
    }
}
