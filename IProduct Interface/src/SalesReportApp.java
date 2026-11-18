import java.util.Scanner;

public class SalesReportApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Single-dimensional array for the 3 products
        String[] products = {
            "Cozy Nights Monarch mattress",
            "Restonic Barbados mattress",
            "Sealy Phuket mattress"
        };
        
        // Two-dimensional array: 3 products, 3 months
        int[][] sales = new int[3][3];
        
        // Capture input
        for (int i = 0; i < products.length; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("Enter number of sales for month " + (j + 1) + " for " + products[i] + ": ");
                sales[i][j] = scanner.nextInt();
            }
            System.out.println(); // Blank line between products for readability
        }
        
        // Instantiate classes
        Product productData = new Product(products, sales);
        PrintProduct printer = new PrintProduct();
        
        // Print the report
        printer.printReport(productData);
        
        scanner.close();
    }
}