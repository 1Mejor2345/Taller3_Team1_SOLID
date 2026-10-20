public class PhysicalProduct extends Product {
    private double weight;
    private double ivaRate;

    public PhysicalProduct(String name, double price, double weight, double ivaRate) {
        super(name, price);
        this.weight = weight;
        this.ivaRate = ivaRate;
    } 

    public double getWeight() {
        return weight;
    }

    @Override
    public double calculateIVA() {
        return getPrice() * ivaRate;
    }
}
