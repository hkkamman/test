package tafelsoefenen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

class CalcPanel extends JPanel {

    private JPanel panelNorth, panelCenter, panelSouth;
    private JTextField inputField;
    private JTextField outputField;
    private ArrayList<Integer> resultList;
    private ArrayList<JButton> buttonList;
    private int random;
    private int answer;

    public CalcPanel() {

        buttonList = new ArrayList<>();
        resultList = new ArrayList<>();

        setLayout(new BorderLayout());

        panelNorth = new JPanel();
        panelCenter = new JPanel();
        panelSouth = new JPanel();
        inputField = new JTextField();
        outputField = new JTextField();
        
        outputField.setEditable(false);

        panelCenter.setLayout(new GridLayout(10, 10));
        panelNorth.setLayout(new GridLayout(1,1));
        panelSouth.setLayout(new GridLayout(1,1));

        for (int a = 1; a < 11; a++) {
            for (int b = 1; b < 11; b++) {
                JButton button = new JButton(b + "x" + a);
                button.setBackground(Color.lightGray);
                panelCenter.add(button);
                resultList.add(a * b);
                buttonList.add(button);
            }
        }

        panelNorth.add(outputField);
        panelSouth.add(inputField);

        add(panelNorth, BorderLayout.NORTH);
        add(panelCenter, BorderLayout.CENTER);
        add(panelSouth, BorderLayout.SOUTH);

        inputField.addActionListener(new RandomSelection());
        
        selectRandom();
    }

    public class RandomSelection implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            checkAnswer();
            selectRandom();
            inputField.setText("");
        }
    }

    public int getInput() {
        try {
            return Integer.parseInt(inputField.getText());
        } catch (NumberFormatException ex) {
            System.out.println(ex);
            return 0;
        }
    }

    public void checkAnswer() {

        answer = resultList.get(random);

        if (getInput() == answer) {
            outputField.setText("correct");
        } else {
            outputField.setText("het juiste antwoord was " + answer);
        }
    }

    public void selectRandom() {

        for (JButton a : buttonList) {
            a.setBackground(Color.lightGray);
        }

        Random r = new Random();
        random = r.nextInt(100);
        buttonList.get(random).setBackground(Color.white);
    }

}
