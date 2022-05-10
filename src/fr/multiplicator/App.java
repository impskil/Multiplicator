package fr.multiplicator;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App {
    private JButton button_msg;
    private JPanel panelMain;
    private JTextField textFieldReponse;
    private JLabel labelCalcul;
    private JButton buttonGenerer;
    private JLabel labelResult;
    private JSlider sliderDifficult;
    private JLabel labelDifficult;
    private JLabel labelMessage;
    private JButton resetButton;
    private JLabel labelScore;
    private JLabel labelTotal;
    private JLabel labelRatio;

    public App() {
        labelDifficult.setText(Integer.toString(sliderDifficult.getValue()));
        methodeNvCalcul();
        button_msg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textFieldReponse.getText().matches("-?\\d+") && textFieldReponse.getText().length() != 0) {
                    //Saisie correcte
                    int result = Integer.parseInt(labelResult.getText());
                    int verifResultat = Integer.parseInt(textFieldReponse.getText());
                    int resultatAVerifier = Integer.parseInt(labelResult.getText());
                    if (verifResultat == resultatAVerifier) {
                        //JOptionPane.showConfirmDialog(null, "Bien joué !");
                        labelMessage.setText("Bien joué !");
                        int Score = Integer.parseInt(labelScore.getText()) + 1 ;
                        int Total = Integer.parseInt(labelTotal.getText()) + 1 ;
                        labelScore.setText(Integer.toString(Score));
                        labelTotal.setText(Integer.toString(Total));

                    } else {
                        //JOptionPane.showConfirmDialog(null, "C'est raté");
                        labelMessage.setText("C'est raté");
                        int Total = Integer.parseInt(labelTotal.getText()) + 1 ;
                        labelTotal.setText(Integer.toString(Total));
                    }
                } else {
                    //saisie incorrecte
                    //JOptionPane.showConfirmDialog(null, "Saisir incorrecte");
                    labelMessage.setText("Saisir incorrecte");
                }
                float Ratio = Float.parseFloat(labelScore.getText()) / Float.parseFloat(labelTotal.getText()) * 100;
                labelRatio.setText(Float.toString(Math.round(Ratio)) + "%");
                textFieldReponse.setText(null);
                methodeNvCalcul();
            }
        });


        sliderDifficult.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                labelDifficult.setText(Integer.toString(sliderDifficult.getValue()));
            }
        });

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labelScore.setText("0");
                labelTotal.setText("0");
                methodeNvCalcul();
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("App");
        frame.setContentPane(new App().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    void methodeNvCalcul() {
        int aMin = 1;
        int bMin = 1;
        int aMax = sliderDifficult.getValue();
        int bMax = 10;
        int a = (int) (Math.random() * (aMax - aMin + 1) + aMin);
        int b = (int) (Math.random() * (bMax - bMin + 1) + bMin);
        int result = a * b;
        labelCalcul.setText(Integer.toString(a) + " x " + Integer.toString(b));
        labelResult.setText(Integer.toString(result));
    }
}
