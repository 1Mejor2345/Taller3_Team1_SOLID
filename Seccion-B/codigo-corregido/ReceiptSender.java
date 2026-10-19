/** Abstraccion de un medio de entrega de recibos (email, SMS, etc.). */
public interface ReceiptSender {
    void send(String content);
}
