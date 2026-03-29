import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Problem8 extends JFrame implements ActionListener {

    JTextField amountField, rateField, timeField, resultField;
    JButton calculateBtn;

    Problem8() {
        setTitle("Investment Calculator");
        setSize(350, 300);
        setLayout(new GridLayout(5, 2, 10, 10));

        add(new JLabel("Principal Amount:"));
        amountField = new JTextField();
        add(amountField);

        add(new JLabel("Rate (%):"));
        rateField = new JTextField();
        add(rateField);

        add(new JLabel("Time (years):"));
        timeField = new JTextField();
        add(timeField);

        add(new JLabel("Total Amount:"));
        resultField = new JTextField();
        resultField.setEditable(false);
        add(resultField);

        calculateBtn = new JButton("Calculate");
        add(calculateBtn);

        calculateBtn.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            double p = Double.parseDouble(amountField.getText());
            double r = Double.parseDouble(rateField.getText());
            double t = Double.parseDouble(timeField.getText());

            double amount = p * Math.pow((1 + r / 100), t);

            resultField.setText(String.format("%.2f", amount));

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Invalid Input");
        }
    }

    public static void main(String[] args) {
        new Problem8();
    }
}