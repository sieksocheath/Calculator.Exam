import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame {

    private JTextField firstNumberField;
    private JTextField secondNumberField;
    private JTextField resultField;
    private JButton addButton, subButton, mulButton, divButton, modButton, clearButton;

    public Calculator() {
        createView();
        setTitle("Calculator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 300); // Adjusted size for better button alignment
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void createView() {
        JPanel panel = new JPanel(new GridBagLayout());
        getContentPane().add(panel);
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(4, 4, 4, 4); // Margin around components

        // Input and result fields
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2; // Span two columns
        panel.add(new JLabel("First Number:"), constraints);

        firstNumberField = new JTextField(10);
        constraints.gridy = 1;
        panel.add(firstNumberField, constraints);

        constraints.gridy = 2;
        panel.add(new JLabel("Second Number:"), constraints);

        secondNumberField = new JTextField(10);
        constraints.gridy = 3;
        panel.add(secondNumberField, constraints);

        constraints.gridy = 4;
        panel.add(new JLabel("Result:"), constraints);

        resultField = new JTextField(10);
        resultField.setEditable(false);
        constraints.gridy = 5;
        panel.add(resultField, constraints);

        // First column of buttons
        addButton = new JButton("+");
        mulButton = new JButton("*");
        modButton = new JButton("%");

        constraints.gridwidth = 1; // Reset to one column width
        constraints.gridx = 0; // First column
        constraints.gridy = 6;
        panel.add(addButton, constraints);

        constraints.gridy = 7;
        panel.add(mulButton, constraints);

        constraints.gridy = 8;
        panel.add(modButton, constraints);

        // Second column of buttons
        subButton = new JButton("-");
        divButton = new JButton("/");
        clearButton = new JButton("Clear");

        constraints.gridx = 1; // Second column
        constraints.gridy = 6;
        panel.add(subButton, constraints);

        constraints.gridy = 7;
        panel.add(divButton, constraints);

        constraints.gridy = 8;
        panel.add(clearButton, constraints);

        // Add action listeners for operations
        addButton.addActionListener(e -> calculate('+'));
        subButton.addActionListener(e -> calculate('-'));
        mulButton.addActionListener(e -> calculate('*'));
        divButton.addActionListener(e -> calculate('/'));
        modButton.addActionListener(e -> calculate('%'));
        clearButton.addActionListener(e -> clearFields());
    }

    private void calculate(char operator) {
        double result = 0;
        double firstNumber = Double.parseDouble(firstNumberField.getText());
        double secondNumber = Double.parseDouble(secondNumberField.getText());

        switch (operator) {
            case '+':
                result = firstNumber + secondNumber;
                break;
            case '-':
                result = firstNumber - secondNumber;
                break;
            case '*':
                result = firstNumber * secondNumber;
                break;
            case '/':
                result = firstNumber / secondNumber;
                break;
            case '%':
                result = firstNumber % secondNumber;
                break;
        }

        resultField.setText(String.valueOf(result));
    }

    private void clearFields() {
        firstNumberField.setText("");
        secondNumberField.setText("");
        resultField.setText("");
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Calculator().setVisible(true));
    }
}