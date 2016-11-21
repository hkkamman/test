package tafelsoefenen;

import javax.swing.JFrame;

public class Calculator extends JFrame{

    public static void main(String[] args) {
        JFrame frame = new Calculator();
        frame.setSize(1000, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Calculator");
        frame.setContentPane(new CalcPanel());
        frame.setVisible(true);
    }
    
}
