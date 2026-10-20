public class DigitalProduct extends Product {
    public DigitalProduct(String name, double price) {
        super(name, price);
    } 

    @Override
    public double calculateIVA() {
        return 0;
    }
}
