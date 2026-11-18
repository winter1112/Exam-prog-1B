

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

public class ProductCalculationsTest {

    @Test
    public void GetVat_WithValidData_ReturnsCorrectValue() {
        // Arrange: Using price 3500 from the sample screenshot
        ProductCalculations calc = new ProductCalculations(3500.0);
        // 15% of 3500 is 525.0
        double expectedVat = 525.0; 
        
        // Act
        double actualVat = calc.GetVat();
        
        // Assert
        assertEquals(expectedVat, actualVat, 0.01, "The VAT should be 525.0");
    }

    @Test
    public void GetTotal_WithValidData_ReturnsCorrectValue() {
        // Arrange: Using price 3500 from the sample screenshot
        ProductCalculations calc = new ProductCalculations(3500.0);
        // Total = 3500 (price) + 525 (VAT) + 175 (Commission) = 4200.0
        double expectedTotal = 4200.0; 
        
        // Act
        double actualTotal = calc.GetTotal();
        
        // Assert
        assertEquals(expectedTotal, actualTotal, 0.01, "The total should be 4200.0");
    }
}