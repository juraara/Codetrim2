package CodeTrim;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class RegularAccountFrame extends JFrame {
    private JTextField accountNumberField;
    private BankAccount regularAccount; // Assuming you have a BankAccount instance for the user

    public RegularAccountFrame() {
        // Set up the frame
        setTitle("Regular Account");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Add components
        add(new JLabel("Welcome to Regular Account!"));
        accountNumberField = new JTextField();
        JButton submitButton = new JButton("Submit");

        // Create a panel to organize components
        JPanel panel = new JPanel();
        accountNumberField.setColumns(10);
        panel.add(new JLabel("Enter account number: "));
        panel.add(accountNumberField);
        panel.add(submitButton);

        add(panel);

        // Add action listener for the submit button
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleAccountNumberInput();
            }
        });
    }

    private void handleAccountNumberInput() {
        String accountNumberInput = accountNumberField.getText();

        if (accountNumberInput.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Invalid Input. Please enter an account number.");
            return;
        }

        // Assuming you have a mechanism to validate the account number
        // For now, I'll assume you have a regularAccount instance
        // Replace this with your actual validation logic
        regularAccount = validateAccountNumber(accountNumberInput);

        if (regularAccount != null) {
            // Account number is valid, open the second JFrame
            openTransactionFrame();
        } else {
            JOptionPane.showMessageDialog(this, "Invalid Account Number. Please try again.");
        }
    }

 private void openTransactionFrame() {
    // Create a new instance of TransactionFrame
    TransactionFrame transactionFrame = new TransactionFrame(regularAccount);

    // Add a window close listener to open a new RegularAccountFrame when the TransactionFrame is closed
    transactionFrame.addWindowListener(new WindowAdapter() {
        @Override
        public void windowClosed(WindowEvent e) {
            openRegularAccountFrame();
        }
    });

    transactionFrame.setVisible(true);
}
 private void openRegularAccountFrame() {
    // Create a new instance of RegularAccountFrame
    RegularAccountFrame regularAccountFrame = new RegularAccountFrame();
    regularAccountFrame.setVisible(true);
    
    // Close the current RegularAccountFrame if needed
    this.dispose();
}

    public static void main(String[] args) {
        // Create an instance of RegularAccountFrame
        SwingUtilities.invokeLater(() -> {
            RegularAccountFrame frame = new RegularAccountFrame();
            frame.setVisible(true);
        });
    }

    // Replace this method with your actual validation logic
    private BankAccount validateAccountNumber(String accountNumber) {
        // Your logic to validate the account number and fetch the corresponding BankAccount
        // For now, I'll assume you have a regularAccount instance
        return new BankAccount(accountNumber, "Account Holder");
    }
}
