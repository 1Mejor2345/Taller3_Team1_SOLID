/** Pruebas sencillas sin bibliotecas externas (ejecutar java -ea PruebasSOLID). */
public class PruebasSOLID {
    private static void verificar(boolean cond, String detalle) {
        if (!cond) throw new AssertionError(detalle);
    }

    private static void igualA(double actual, double esperado, String detalle) {
        verificar(Math.abs(actual - esperado) < 0.000001, detalle);
    }

    public static void main(String[] args) {
        TaxPolicy sinIVA = new PercentageTaxPolicy(0.0);
        TaxPolicy ropa = new PercentageTaxPolicy(0.12);
        TaxPolicy tecnologia = new PercentageTaxPolicy(0.15);
        IvaCalculator calculadora = new IvaCalculator();

        Product libro = new PhysicalProduct("Libro", 10, 0.3, sinIVA);
        Product camiseta = new PhysicalProduct("Camiseta", 40, 0.2, ropa);
        Product ordenador = new PhysicalProduct("Computadora", 500, 2.0, tecnologia);
        Product digital = new DigitalProduct("Libro digital", 20);

        // OCP: la calculadora admite cualquier politica inyectada sin cambiar su codigo.
        igualA(calculadora.calculateIVA(libro), 0, "IVA libro");
        igualA(calculadora.calculateIVA(camiseta), 4.8, "IVA ropa");
        igualA(calculadora.calculateIVA(ordenador), 75, "IVA tecnologia");
        Product nuevoTipo = new PhysicalProduct("Categoria adicional", 100, 1,
                                                new PercentageTaxPolicy(0.05));
        igualA(calculadora.calculateIVA(nuevoTipo), 5, "IVA nueva categoria");

        // LSP: cualquier Product tiene nombre y precio, sin excepcion por consultar peso.
        Product[] productos = {libro, camiseta, ordenador, digital};
        for (Product p : productos) {
            verificar(p.getName() != null, "Nombre de producto");
            verificar(p.getPrice() >= 0, "Precio no negativo");
        }
        verificar(libro instanceof Weighable, "Los fisicos tienen peso");
        verificar(!(digital instanceof Weighable), "Los digitales no requieren peso");

        ShoppingCart carrito = new ShoppingCart();
        for (Product p : productos) carrito.addProduct(p);
        igualA(carrito.calculateTotalPrice(), 570.0, "Subtotal");
        String recibo = new ReceiptFormatter(calculadora).format(carrito);
        verificar(recibo.contains("IVA: $79.80"), "IVA del carrito");
        verificar(recibo.contains("Total: $649.80"), "Total del carrito");

        // DIP en la solucion: se puede cambiar sender con una implementacion alternativa.
        final StringBuilder registro = new StringBuilder();
        ReceiptSender salidaPrueba = content -> registro.append(content);
        new ReceiptService(new ReceiptFormatter(calculadora), salidaPrueba)
            .sendReceipt(carrito);
        verificar(registro.toString().contains("=== RECIBO ==="), "Envio desacoplado");
        System.out.println("Todas las pruebas pasaron.");
    }
}
