
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author EZIO AUDITORY
 */
public class Calculator implements ActionListener {

    JFrame calFrame;
    JPanel calPanel, calButtonsPanel;
    JMenuBar calMenuBar;
    JMenu view, edit, help;
    JMenuItem helpItem1, helpItem2;
    JTextField calTextField;
    JButton[] calButtons = new JButton[30];

    double number1 = 0, number2 = 0, result = 0;
    char operator;
    String zeroText = "0";

    Font font1 = new Font("Tahoma", 000000, 24);
    Font font2 = new Font("Tahoma", 000000, 18);

    public Calculator() {
        components();
    }

    private void components() {
        calFrame = new JFrame("Calculator");
        calFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        calFrame.setBounds(750, 250, 460, 500);
        calFrame.setLayout(null);

        calPanel = new JPanel();
        calPanel.setBounds(0, 0, 460, 500);
        calPanel.setLayout(null);

        calMenuBar = new JMenuBar();
        calMenuBar.setBounds(0, 0, 460, 25);

        view = new JMenu("View");
        calMenuBar.add(view);

        edit = new JMenu("Edit");
        calMenuBar.add(edit);

        help = new JMenu("Help");
        helpItem1 = new JMenuItem("View Help F1");
        help.add(helpItem1);
        helpItem2 = new JMenuItem("About Calculator");
        help.add(helpItem2);
        calMenuBar.add(help);

        calPanel.add(calMenuBar);

        calTextField = new JTextField();
        calTextField.setBounds(60, 50, 320, 50);
        calTextField.setFont(font1);
        calTextField.setEditable(false);
        calTextField.setText(zeroText);
        calPanel.add(calTextField);

        for (int i = 0; i < 30; i++) {
            calButtons[i] = new JButton();
            calButtons[i].addActionListener(this);
            calButtons[i].setFocusable(false);
            calButtons[i].setFont(font2);
        }

        calButtons[0].setText("MC");
        calButtons[1].setText("MR");
        calButtons[2].setText("MS");
        calButtons[3].setText("M+");
        calButtons[4].setText("M-");
        calButtons[5].setText("<--");
        calButtons[6].setText("CE");
        calButtons[7].setText("C");
        calButtons[8].setText("+/-");
        calButtons[9].setText("SQRT");
        calButtons[10].setText("7");
        calButtons[11].setText("8");
        calButtons[12].setText("9");
        calButtons[13].setText("/");
        calButtons[14].setText("%");
        calButtons[15].setText("4");
        calButtons[16].setText("5");
        calButtons[17].setText("6");
        calButtons[18].setText("*");
        calButtons[19].setText("1/X");
        calButtons[20].setText("1");
        calButtons[21].setText("2");
        calButtons[22].setText("3");
        calButtons[23].setText("-");
        calButtons[24].setText("=");
        calButtons[25].setText("0");
        calButtons[26].setText(" ");
        calButtons[27].setText(".");
        calButtons[28].setText("+");
        calButtons[29].setText("Back");

        calButtonsPanel = new JPanel();
        calButtonsPanel.setBounds(10, 120, 420, 320);
        calButtonsPanel.setLayout(new GridLayout(6, 5, 2, 2));

        for (int i = 0; i < 30; i++) {
            calButtonsPanel.add(calButtons[i]);
        }

        calPanel.add(calButtonsPanel);
        calFrame.add(calPanel);
        calFrame.setVisible(true);
    }

    public static void main(String[] args) {
        Calculator cal = new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (zeroText == "0") {
            calTextField.setText("");
            zeroText = "";
        }

        // CE Button
        if (e.getSource() == calButtons[6]) {
            calTextField.setText("");
        }
        // C Button
        if (e.getSource() == calButtons[7]) {
            calTextField.setText("");
            number1 = 0;
            number2 = 0;
            result = 0;
        }
        // +/- Button
        if (e.getSource() == calButtons[8]) {
            double value = Double.parseDouble(calTextField.getText());
            value *= -1;
            calTextField.setText(String.valueOf(value));
        }
        // SQRT Button
        if (e.getSource() == calButtons[9]) {
            number1 = Double.parseDouble(calTextField.getText());
            result = Math.sqrt(number1);
            calTextField.setText(String.valueOf(result));
        }
        // 7 Button
        if (e.getSource() == calButtons[10]) {
            calTextField.setText(calTextField.getText().concat("7"));
        }
        // 8 Button
        if (e.getSource() == calButtons[11]) {
            calTextField.setText(calTextField.getText().concat("8"));
        }
        // 9 Button
        if (e.getSource() == calButtons[12]) {
            calTextField.setText(calTextField.getText().concat("9"));
        }
        // / Button
        if (e.getSource() == calButtons[13]) {
            number1 = Double.parseDouble(calTextField.getText());
            operator = '/';
            calTextField.setText("");
        }
        // % Button
        if (e.getSource() == calButtons[14]) {
            number2 = Double.parseDouble(calTextField.getText());
            result = number2 / 100;
            calTextField.setText(String.valueOf(result));
        }
        // 4 Button
        if (e.getSource() == calButtons[15]) {
            calTextField.setText(calTextField.getText().concat("4"));
        }
        // 5 Button
        if (e.getSource() == calButtons[16]) {
            calTextField.setText(calTextField.getText().concat("5"));
        }
        // 6 Button
        if (e.getSource() == calButtons[17]) {
            calTextField.setText(calTextField.getText().concat("6"));
        }
        // * Button
        if (e.getSource() == calButtons[18]) {
            number1 = Double.parseDouble(calTextField.getText());
            operator = '*';
            calTextField.setText("");
        }
        // 1/X Button
        if (e.getSource() == calButtons[19]) {
            number1 = Double.parseDouble(calTextField.getText());
            result = 1 / number1;
            calTextField.setText(String.valueOf(result));
        }
        // 1 Button
        if (e.getSource() == calButtons[20]) {
            calTextField.setText(calTextField.getText().concat("1"));
        }
        // 2 Button
        if (e.getSource() == calButtons[21]) {
            calTextField.setText(calTextField.getText().concat("2"));
        }
        // 3 Button
        if (e.getSource() == calButtons[22]) {
            calTextField.setText(calTextField.getText().concat("3"));
        }
        // - Button
        if (e.getSource() == calButtons[23]) {
            number1 = Double.parseDouble(calTextField.getText());
            operator = '-';
            calTextField.setText("");
        }
        // = Button
        if (e.getSource() == calButtons[24]) {
            number2 = Double.parseDouble(calTextField.getText());

            switch (operator) {
                case '+':
                    result = number1 + number2;
                    break;
                case '-':
                    result = number1 - number2;
                    break;
                case '/':
                    result = number1 / number2;
                    break;
                case '*':
                    result = number1 * number2;
                    break;
            }
            calTextField.setText(String.valueOf(result));
            number1 = result;
        }
        // 0 Button
        if (e.getSource() == calButtons[25]) {
            calTextField.setText(calTextField.getText().concat("0"));
        }
        // . Button
        if (e.getSource() == calButtons[27]) {
            calTextField.setText(calTextField.getText().concat("."));
        }
        // + Button
        if (e.getSource() == calButtons[28]) {
            number1 = Double.parseDouble(calTextField.getText());
            operator = '+';
            calTextField.setText("");
        }
        // Back Button
        if (e.getSource() == calButtons[29]) {
            String value = calTextField.getText();
            calTextField.setText("");
            for (int i = 0; i < value.length() - 1; i++) {
                calTextField.setText(calTextField.getText() + value.charAt(i));
            }
        }
    }
}
