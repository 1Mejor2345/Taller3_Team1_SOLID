package Taller3_Team1_SOLID.SeccionC;

public class ProcesadorPagoPayPal {

    private AutenticacionPayPal autenticacion;
    private PagoPayPal pago;

    public ProcesadorPagoPayPal() {
        autenticacion = new AutenticacionPayPal();
        pago = new PagoPayPal();
    }

    public boolean procesarPago(double monto) {

        if (autenticacion.iniciarSesion()) {
            pago.realizarCobro(monto);
            return true;
        }

        return false;
    }
}
