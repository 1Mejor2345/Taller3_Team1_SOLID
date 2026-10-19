/** Simula el envio por email; una integracion real requeriria un servicio de correo. */
public final class EmailReceiptSender implements ReceiptSender {
    @Override
    public void send(String content) {
        System.out.println("[Simulacion de envio por email]");
        System.out.println(content);
    }
}
