import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class Caculator extends JFrame implements ActionListener {

    // instance variables
    JLabel num1Label = null;
    JTextField num1Text = null;
    JLabel num2Label = null;
    JTextField num2Text = null;
    JButton sumButton = null;
    JButton subtractButton = null;
    JLabel ansLabel = null;
    
    
    // constructor
    public Caculator() {
        setLayout(new GridBagLayout());    // set layout (how elements are arranged in window)
        // ****  label:  num 1
        GridBagConstraints layoutCon = new GridBagConstraints();
        layoutCon.gridx = 0;
        layoutCon.gridy = 0;
        layoutCon.insets = new Insets(10,10,10,10);
        
        num1Label = new JLabel("Num 1:");
        add(num1Label,layoutCon);   // added label to JFrame
        
        
        // ****  text field:  num 1
        layoutCon = new GridBagConstraints();
        layoutCon.gridx = 1;
        layoutCon.gridy = 0;
        layoutCon.insets = new Insets(10,10,10,10);
        
        num1Text = new JTextField(20);
        add(num1Text, layoutCon);
        
        // ****  label:  num 2
        layoutCon = new GridBagConstraints();
        layoutCon.gridx = 0;
        layoutCon.gridy = 1;
        layoutCon.insets = new Insets(10,10,10,10);
        
        num2Label = new JLabel("Num 2:");
        add(num2Label,layoutCon);   // added label to JFrame
        
        
        // ****  text field: num 2
        layoutCon = new GridBagConstraints();
        layoutCon.gridx = 1;
        layoutCon.gridy = 1;
        layoutCon.insets = new Insets(10,10,10,10);
        
        num2Text = new JTextField(20);
        add(num2Text, layoutCon);
        
        // ****  Sum Button
        layoutCon = new GridBagConstraints();
        layoutCon.gridx = 0;
        layoutCon.gridy = 2;
        layoutCon.insets = new Insets(10,10,10,10);
        
        sumButton = new JButton("Sum");
        add(sumButton, layoutCon);
        sumButton.addActionListener(this);  // register sumButton with the ActionListener in Calculator
                
        // ****  label:  answer
        layoutCon = new GridBagConstraints();
        layoutCon.gridx = 1;
        layoutCon.gridy = 2;
        layoutCon.insets = new Insets(10,10,10,10);
        
        ansLabel = new JLabel("Answer");
        add(ansLabel,layoutCon);   // added label to JFrame    
        
        // ****  Subtract Button
        layoutCon = new GridBagConstraints();
        layoutCon.gridx = 0;
        layoutCon.gridy = 3;
        layoutCon.insets = new Insets(10,10,10,10);
        
        subtractButton = new JButton("Subtract");
        add(subtractButton, layoutCon);
        subtractButton.addActionListener(this);  // register subtractButton with the ActionListener in Calculator

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Sum")) {
            ansLabel.setText("" + (Integer.parseInt(num1Text.getText()) + Integer.parseInt(num2Text.getText())));
        }
        else if (e.getActionCommand().equals("Subtract")) {
            ansLabel.setText("" + (Integer.parseInt(num1Text.getText()) - Integer.parseInt(num2Text.getText())));
        }
    }
    
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        
        calc.pack();    // resizes window (JFrame) so you can see the elements in it
        calc.setVisible(true);   // make window visible
        calc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit program when close window
    }

}
 