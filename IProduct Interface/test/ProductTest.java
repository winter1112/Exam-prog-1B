/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author DELL
 */
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductTest {

    // Test data based on the sample screenshot
    String[] testProducts = {"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"};
    int[][] testSales = {
        {25, 18, 20}, // Sum: 63
        {15, 10, 12}, // Sum: 37
        {18, 15, 20}  // Sum: 53
    }; 
    // Total = 153

    @Test
    public void GetTotalProductSales_WithValidData_ReturnsCorrectValue() {
        // Arrange
        Product product = new Product(testProducts, testSales);
        int expectedTotal = 153;
        
        // Act
        int actualTotal = product.GetTotalProductsSold();
        
        // Assert
        assertEquals(expectedTotal, actualTotal, "The total products sold should be 153");
    }

    @Test
    public void GetAverageSales_WithValidData_ReturnsCorrectValue() {
        // Arrange
        Product product = new Product(testProducts, testSales);
        // Total 153 / 9 data points = 17.0
        double expectedAverage = 17.0; 
        
        // Act
        double actualAverage = product.GetAverageProductSold();
        
        // Assert
        assertEquals(expectedAverage, actualAverage, 0.01, "The average should be 17.0");
    }
}