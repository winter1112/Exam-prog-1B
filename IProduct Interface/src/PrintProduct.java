public class PrintProduct {
    
    public void printReport(IProduct product) {
        System.out.println("\nPRODUCT SALES REPORT - 2026");
        System.out.println("************************************************");
        
        // Casting to Product to access specific methods if needed, 
        // but using interface methods is better practice.
        System.out.println("TOTAL PRODUCT SALES: " + product.GetTotalProductsSold());
        
        // Formatting average to match the sample (no decimals shown)
        System.out.printf("AVERAGE PRODUCT SALES: %.0f\n", product.GetAverageProductSold());
        
        System.out.println("MOST POPULAR PRODUCT: " + product.GetMostPopularProduct());
    }
}
