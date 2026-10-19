import java.util.Objects;

/** Coordina generar y enviar el recibo, sin depender de un medio concreto. */
public final class ReceiptService {
    private final ReceiptFormatter formatter;
    private final ReceiptSender sender;

    public ReceiptService(ReceiptFormatter formatter, ReceiptSender sender) {
        this.formatter = Objects.requireNonNull(formatter, "formatter");
        this.sender = Objects.requireNonNull(sender, "sender");
    }

    public void sendReceipt(ShoppingCart cart) {
        sender.send(formatter.format(cart));
    }
}
