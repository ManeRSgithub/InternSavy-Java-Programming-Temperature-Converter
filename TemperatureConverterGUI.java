import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TemperatureConverterGUI extends JFrame {
    private JTextField inputField;
    private JLabel resultLabel;

    public TemperatureConverterGUI() {
        setTitle("Temperature Converter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);
        setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(3, 1));

        JLabel titleLabel = new JLabel("Temperature Converter", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());
        JLabel inputLabel = new JLabel("Enter temperature:");
        inputField = new JTextField(10);
        inputPanel.add(inputLabel);
        inputPanel.add(inputField);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        JButton celsiusButton = new JButton("Fahrenheit to Celsius");
        JButton fahrenheitButton = new JButton("Celsius to Fahrenheit");
        buttonPanel.add(celsiusButton);
        buttonPanel.add(fahrenheitButton);

        resultLabel = new JLabel("", SwingConstants.CENTER);
        resultLabel.setFont(new Font("Arial", Font.BOLD, 16));

        mainPanel.add(titleLabel);
        mainPanel.add(inputPanel);
        mainPanel.add(buttonPanel);

        add(mainPanel, BorderLayout.CENTER);
        add(resultLabel, BorderLayout.SOUTH);

        celsiusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputText = inputField.getText();
                try {
                    double fahrenheit = Double.parseDouble(inputText);
                    double celsius = (fahrenheit - 32) * 5 / 9;
                    resultLabel.setText(fahrenheit + "°F is equal to " + celsius + "°C");
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Invalid input!");
                }
            }
        });

        fahrenheitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputText = inputField.getText();
                try {
                    double celsius = Double.parseDouble(inputText);
                    double fahrenheit = (celsius * 9 / 5) + 32;
                    resultLabel.setText(celsius + "°C is equal to " + fahrenheit + "°F");
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Invalid input!");
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                TemperatureConverterGUI converterGUI = new TemperatureConverterGUI();
                converterGUI.setVisible(true);
            }
        });
    }
}
