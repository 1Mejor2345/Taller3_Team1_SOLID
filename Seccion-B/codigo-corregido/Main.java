/** Demostracion autocontenida de la Seccion B. */
public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        TaxPolicy bookTax = new PercentageTaxPolicy(0.00);
        TaxPolicy clothingTax = new PercentageTaxPolicy(0.12);
        TaxPolicy technologyTax = new PercentageTaxPolicy(0.15);

        Product book = new PhysicalProduct("Libro", 10.00, 0.30, bookTax);
        Product shirt = new PhysicalProduct("Camiseta", 40.00, 0.20, clothingTax);
        Product laptop = new PhysicalProduct("Computadora", 500.00, 2.00, technologyTax);
        Product ebook = new DigitalProduct("Libro digital", 20.00);

        cart.addProduct(book);
        cart.addProduct(shirt);
        cart.addProduct(laptop);
        cart.addProduct(ebook);

        ReceiptSender emailSender = new EmailReceiptSender();
        ReceiptFormatter formatter = new ReceiptFormatter(new IvaCalculator());
        ReceiptService service = new ReceiptService(formatter, emailSender);
        service.sendReceipt(cart);
    }
}
