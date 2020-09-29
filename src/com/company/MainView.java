package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainView {

    private int screenHeight, screenWidth;

    private JFrame frame;
    private JPanel mainPanel, gameFieldPanel, gameCharsFieldPanel;

    private GameField gameField;
    private DrawX drawX;
    private DrawO drawO;

    private JLabel titleJLabel;
    private JButton addLinesButton;

    public MainView() {
        // Determining screen size
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        screenHeight = (int)screenSize.getHeight();
        screenWidth = (int)screenSize.getWidth();

//      Creating frame
        frame = new JFrame();
        addComponentsToPane();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Tic Tac Toe Game");
        frame.setLocationRelativeTo(null);
        frame.setLocation(((screenWidth/2)-(screenWidth/4)), ((screenHeight/2)-(screenHeight/4)));

//      Display frame
        frame.pack();
        frame.setVisible(true);

//        Creating game field
        gameField.createGameField(gameFieldPanel);

        gameFieldPanel.addMouseListener(gameField);
//        addMouseListener(this);

    }

    protected void addComponentsToPane() {
        // Setting up elements and layout
        mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();


        gameField = new GameField(this);
        gameField.setPreferredSize(new Dimension(screenWidth / 3, screenHeight / 2));
        gameField.setBorder(BorderFactory.createLineBorder(Color.black));

        gameFieldPanel = new JPanel();
        LayoutManager overlay = new OverlayLayout(gameFieldPanel);
        gameFieldPanel.setLayout(overlay);
        gameFieldPanel.add(gameField);

//        gameCharsFieldPanel.setOpaque(true);
//        gameCharsFieldPanel.setPreferredSize(new Dimension(screenWidth/3, screenHeight/3));
//        gameFieldPanel.add(gameCharsFieldPanel);

        drawX = new DrawX();
        gameFieldPanel.add(drawX);

        drawO = new DrawO();
        gameFieldPanel.add(drawO);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 3;
        c.gridx = 0;
        c.gridy = 0;
        mainPanel.add(gameFieldPanel, c);

//        addLinesButton = new JButton("Draw Lines");
//        c.fill = GridBagConstraints.HORIZONTAL;
////        c.gridwidth = 3;
//        c.gridx = 0;
//        c.gridy = 1;
//        mainPanel.add(addLinesButton, c);
//
        frame.add(mainPanel);
    }


    public JPanel getMainPanel() {
        return mainPanel;
    }

    public JPanel getGameFieldPanel() {
        return gameFieldPanel;
    }

    public GameField getGameField() {
        return gameField;
    }

    public DrawX getDrawX() {
        return drawX;
    }

    public DrawO getDrawO() {
        return drawO;
    }
}

