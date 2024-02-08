package lab1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UI {
        private JFrame frame;
        private JTextField amountField;
        private JComboBox<String> fromCurrencyComboBox;
        private JComboBox<String> toCurrencyComboBox;
        private JLabel resultLabel;

        public UI() {
            frame = new JFrame("Currency Converter");
            frame.setLayout(new GridLayout(5, 2));

            JLabel amountLabel = new JLabel("Amount:");
            amountField = new JTextField();

            JLabel fromCurrencyLabel = new JLabel("From Currency:");
            fromCurrencyComboBox = new JComboBox<>(new String[]{"USD", "EUR", "JPY"});

            JLabel toCurrencyLabel = new JLabel("To Currency:");
            toCurrencyComboBox = new JComboBox<>(new String[]{"USD", "EUR", "JPY"});

            JButton convertButton = new JButton("Convert");
            resultLabel = new JLabel("");

            frame.add(amountLabel);
            frame.add(amountField);
            frame.add(fromCurrencyLabel);
            frame.add(fromCurrencyComboBox);
            frame.add(toCurrencyLabel);
            frame.add(toCurrencyComboBox);
            frame.add(convertButton);
            frame.add(resultLabel);

            frame.setSize(300, 150);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);

            convertButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String fromCurrency = fromCurrencyComboBox.getSelectedItem().toString();
                    String toCurrency = toCurrencyComboBox.getSelectedItem().toString();
                    double value =  Double.parseDouble(amountField.getText());
                    switch (fromCurrency) {
                        case "USD":
                            USDConverter converter = new USDConverter(value, toCurrency);
                            String result = value + " USD = " + converter.convert() + toCurrency;
                            System.out.println(result);
                            resultLabel.setText(result);
                            break;
                       case "EUR":
                           EURConverter eurconverter = new EURConverter(value, toCurrency);
                           String eurresult = value + " EUR = " + eurconverter.convert() + toCurrency;
                           System.out.println(eurresult);
                           resultLabel.setText(eurresult);
                           break;
                        case "JPY":
                            JPYConverter jpyconverter = new JPYConverter(value, toCurrency);
                            String jpyresult = value + " JPY = " + jpyconverter.convert() + toCurrency;
                            System.out.println(jpyresult);
                            resultLabel.setText(jpyresult);
                            break;
                        default: resultLabel.setText("Something went wrong!");
                    }
                }
            });
        }



        public static void main(String[] args) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new UI();
                }
            });
        }
    }
