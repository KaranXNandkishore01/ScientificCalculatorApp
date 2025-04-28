import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Math;

public class ScientificCalculator extends JFrame implements ActionListener {
    // Components
    JTextField input;
    JPanel panel;
    String[] buttonLabels = {
            "7", "8", "9", "/", "sqrt",
            "4", "5", "6", "*", "x^y",
            "1", "2", "3", "-", "log",
            "0", ".", "=", "+", "C",
            "sin", "cos", "tan"
    };
    JButton[] buttons = new JButton[buttonLabels.length];

    double num1, num2, result;
    String operator;

    ScientificCalculator() {
        // Frame setup
        setTitle("Scientific Calculator");
        setSize(400, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        input = new JTextField();
        input.setFont(new Font("Arial", Font.BOLD, 24));
        input.setHorizontalAlignment(SwingConstants.RIGHT);
        input.setEditable(false);

        panel = new JPanel();
        panel.setLayout(new GridLayout(5, 5, 5, 5));

        // Clickable buttons Adding 
        for (int i = 0; i < buttonLabels.length; i++) {
            buttons[i] = new JButton(buttonLabels[i]);
            buttons[i].setFont(new Font("Arial", Font.BOLD, 18));
            buttons[i].addActionListener(this);
            panel.add(buttons[i]);
        }

        add(input, BorderLayout.NORTH);
        add(panel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        try {
            if ((command.charAt(0) >= '0' && command.charAt(0) <= '9') || command.equals(".")) {
                input.setText(input.getText() + command);
            } else if (command.equals("C")) {
                input.setText("");
            } else if (command.equals("=")) {
                num2 = Double.parseDouble(input.getText());
                switch (operator) {
                    case "+": result = num1 + num2; break;
                    case "-": result = num1 - num2; break;
                    case "*": result = num1 * num2; break;
                    case "/": result = num1 / num2; break;
                    case "x^y": result = Math.pow(num1, num2); break;
                }
                input.setText(String.valueOf(result));
            } else if (command.equals("sqrt")) {
                num1 = Double.parseDouble(input.getText());
                result = Math.sqrt(num1);
                input.setText(String.valueOf(result));
            } else if (command.equals("log")) {
                num1 = Double.parseDouble(input.getText());
                result = Math.log10(num1);
                input.setText(String.valueOf(result));
            } else if (command.equals("sin")) {
                num1 = Double.parseDouble(input.getText());
                result = Math.sin(Math.toRadians(num1));
                input.setText(String.valueOf(result));
            } else if (command.equals("cos")) {
                num1 = Double.parseDouble(input.getText());
                result = Math.cos(Math.toRadians(num1));
                input.setText(String.valueOf(result));
            } else if (command.equals("tan")) {
                num1 = Double.parseDouble(input.getText());
                result = Math.tan(Math.toRadians(num1));
                input.setText(String.valueOf(result));
            } else {
                // This is an operator
                operator = command;
                num1 = Double.parseDouble(input.getText());
                input.setText("");
            }
        } catch (Exception ex) {
            input.setText("Error");
        }
    }

    public static void main(String[] args) {
        new ScientificCalculator();
    }
}
