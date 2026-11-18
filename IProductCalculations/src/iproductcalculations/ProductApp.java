import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ProductApp extends JFrame {

    private JTextField txtCustomerName;
    private JComboBox<String> cmbProduct;
    private JTextField txtPrice;
    private JButton btnProcess;

    public ProductApp() {
        // Frame setup
        setTitle("Product App");
        setSize(450, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null); // Using absolute positioning to match the screenshot layout closely

        // --- Menu System (Q.2.4) ---
        JMenuBar menuBar = new JMenuBar();

        // File Menu
        JMenu fileMenu = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e -> System.exit(0));
        fileMenu.add(exitItem);

        // Tools Menu
        JMenu toolsMenu = new JMenu("Tools");
        JMenuItem processItem = new JMenuItem("Process");
        JMenuItem clearItem = new JMenuItem("Clear");
        
        // Link menu process item to the same logic as the button
        processItem.addActionListener(e -> processSale());
        clearItem.addActionListener(e -> clearForm());
        
        toolsMenu.add(processItem);
        toolsMenu.add(clearItem);

        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);
        setJMenuBar(menuBar);

        // --- GUI Components (Q.2.1 & Q.2.2) ---
        JLabel lblCustomer = new JLabel("Customer Name:");
        lblCustomer.setBounds(30, 40, 100, 25);
        add(lblCustomer);

        txtCustomerName = new JTextField();
        txtCustomerName.setBounds(140, 40, 250, 25);
        add(txtCustomerName);

        JLabel lblProduct = new JLabel("Select Product:");
        lblProduct.setBounds(30, 80, 100, 25);
        add(lblProduct);

        String[] products = {"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"};
        cmbProduct = new JComboBox<>(products);
        cmbProduct.setBounds(140, 80, 250, 25);
        add(cmbProduct);

        JLabel lblPrice = new JLabel("Enter Price:");
        lblPrice.setBounds(30, 120, 100, 25);
        add(lblPrice);

        txtPrice = new JTextField();
        txtPrice.setBounds(140, 120, 250, 25);
        add(txtPrice);

        btnProcess = new JButton("PROCESS");
        btnProcess.setBounds(140, 170, 250, 30);
        btnProcess.addActionListener(e -> processSale());
        add(btnProcess);
    }

    // --- Core Logic (Q.2.3) ---
    private void processSale() {
        try {
            // Get data from form
            String customerName = txtCustomerName.getText().trim();
            String productName = (String) cmbProduct.getSelectedItem();
            String priceStr = txtPrice.getText().trim();

            // Basic validation
            if (customerName.isEmpty() || priceStr.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            double price = Double.parseDouble(priceStr);

            // Perform calculations using the separate class
            ProductCalculations calc = new ProductCalculations(price);
            double vat = calc.GetVat();
            double commission = calc.GetCommission();
            double total = calc.GetTotal();

            // Format the output string for the Message Box and File
            String outputMessage = "Customer Name: " + customerName + "\n" +
                                   "Product: " + productName + "\n" +
                                   "VAT: R " + vat + "\n" +
                                   "COMMISSION: R " + commission + "\n" +
                                   "TOTAL: R " + total;

            // Show Message Box
            JOptionPane.showMessageDialog(this, outputMessage, "Message", JOptionPane.INFORMATION_MESSAGE);

            // Save to file (data.txt)
            saveToFile(customerName, productName, vat, commission, total);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number for the price.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        }
    }

    // --- File Saving Logic ---
    private void saveToFile(String customer, String product, double vat, double commission, double total) {
        // Append mode (true) to keep previous records
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("data.txt", true))) {
            writer.write("DATA LOG\n");
            writer.write("****************************\n");
            writer.write("Customer Name: " + customer + "\n");
            writer.write("Product: " + product + "\n");
            writer.write("VAT: R " + vat + "\n");
            writer.write("COMMISSION: R " + commission + "\n");
            writer.write("TOTAL: R " + total + "\n");
            writer.write("****************************\n\n");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error saving to file: " + e.getMessage(), "File Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // --- Clear Form Logic (Q.2.4) ---
    private void clearForm() {
        txtCustomerName.setText("");
        txtPrice.setText("");
        cmbProduct.setSelectedIndex(0); // Reset to first item
    }

    public static void main(String[] args) {
        // Run GUI on Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            new ProductApp().setVisible(true);
        });
    }
}