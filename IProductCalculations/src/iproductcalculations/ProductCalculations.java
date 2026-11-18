
public class ProductCalculations implements IProductCalculations {
    private double price;

    public ProductCalculations(double price) {
        this.price = price;
    }

    @Override
    public double GetVat() {
        return price * 0.15; // 15% VAT
    }

    @Override
    public double GetCommission() {
        return price * 0.05; // 5% Commission
    }

    @Override
    public double GetTotal() {
        // Total = Price + VAT + Commission
        return price + GetVat() + GetCommission();
    }
}
