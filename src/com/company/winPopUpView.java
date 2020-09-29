package com.company;

import javax.swing.*;
import java.awt.*;

public class winPopUpView {

    private int screenHeight, screenWidth;
    private JFrame frame;
    private JPanel mainPanel;
    private JButton startNewGame;

    private String wonPlayer;


    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    public winPopUpView(String wonPlayer) {
        this.wonPlayer = wonPlayer;

        screenHeight = (int) screenSize.getHeight();
        screenWidth = (int) screenSize.getWidth();

//      Creating frame
        frame = new JFrame();
        addComponentsToPane();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Tic Tac Toe Game");
        frame.setLocationRelativeTo(null);
        frame.setLocation(((screenWidth / 2) - (screenWidth / 4)), ((screenHeight / 2) - (screenHeight / 4)));

//      Display frame
        frame.pack();
        frame.setVisible(true);
    }

    protected void addComponentsToPane() {
        // Setting up elements and layout
        mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        JLabel congratsLabel1 = new JLabel(" Congratulations to player "+wonPlayer+"  ");
        congratsLabel1.setFont(new Font("serif", Font.BOLD, 25));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 3;
        c.gridx = 0;
        c.gridy = 0;
        mainPanel.add(congratsLabel1, c);

        JLabel congratsLabel2 = new JLabel(" You have won !");
        congratsLabel2.setFont(new Font("serif", Font.BOLD, 25));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 3;
        c.gridx = 0;
        c.gridy = 1;
        mainPanel.add(congratsLabel2, c);


        startNewGame = new JButton("Start new game");
        c.fill = GridBagConstraints.HORIZONTAL;
//        c.gridwidth = 3;
        c.gridx = 0;
        c.gridy = 2;
        mainPanel.add(startNewGame, c);
//
        frame.add(mainPanel);
    }

}
