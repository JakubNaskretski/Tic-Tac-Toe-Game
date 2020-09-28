package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;

public class GameField extends JComponent implements MouseListener {

    private MainView mainView;
    private ScoreCounter scoreCounter;
    int[][][] pointsList;
    private int gamePanelWidth, gamePanelHeight, dividedWidth, dividedHeight;


    public GameField(MainView mainView) {
        this.mainView = mainView;
        this.scoreCounter = new ScoreCounter();
        pointsList = new int[4][4][2];

    }

    private static class Rectangle {
        final int x1;
        final int y1;
        final int width;
        final int height;
        final Color color;

        public Rectangle(int x1, int y1, int width, int height, Color color) {
            this.x1 = x1;
            this.y1 = y1;
            this.width = width;
            this.height = height;
            this.color = color;
        }
    }

    private final LinkedList<Rectangle> rectangles = new LinkedList<Rectangle>();

    public void addRectangle(int x1, int y1, int width, int height) {
        addRectangle(x1, y1, width, height, Color.black);
    }

    public void addRectangle(int x1, int y1, int width, int height, Color color) {
        rectangles.add(new Rectangle(x1, y1, width, height, color));
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        for (Rectangle rectangle : rectangles) {
            g2.setColor(rectangle.color);
            g2.setStroke(new BasicStroke(2));
            g2.drawRect(rectangle.x1, rectangle.y1, rectangle.width, rectangle.height);
        }
    }


    protected void createGameField(JPanel gameFieldPanel){
        // Creating game field variables
        java.awt.Rectangle r = gameFieldPanel.getBounds();
        this.gamePanelWidth = r.width;
        this.gamePanelHeight = r.height;
        this.dividedWidth = gamePanelWidth/3;
        this.dividedHeight = gamePanelHeight/3;

        //        Creating game field and making map of game field
        int pointX, savePointCounter = 0, pointYToSaveCounter = 0, pointXToSaveCounter = 0;
        for (int pointY=0;pointY<=gamePanelHeight;pointY+=(dividedHeight)){
            for (pointX=0;pointX<gamePanelWidth;pointX+=dividedWidth) {

                addRectangle(pointX, pointY, dividedWidth, dividedHeight);

//              Adds each points coordinates to the long list, starting from X
                pointsList[pointYToSaveCounter][pointXToSaveCounter][savePointCounter] = pointX;
                savePointCounter++;
                pointsList[pointYToSaveCounter][pointXToSaveCounter][savePointCounter] = pointY;
                savePointCounter=0;
                pointXToSaveCounter++;
            }
            if ((pointX+dividedWidth)>=gamePanelWidth){
                pointX = 0;
            }
            pointXToSaveCounter=0;
            pointYToSaveCounter++;
        }

//        Verify printout
        for (int i=0;i<pointsList.length;i++){
            for (int j=0;j<pointsList[i].length;j++){
                System.out.println("X "+pointsList[i][j][0]+" Y "+pointsList[i][j][1]);
            }
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int mouseX = mainView.getGameFieldPanel().getMousePosition().x;
        int mouseY = mainView.getGameFieldPanel().getMousePosition().y;

        if (mouseX >= 0 && mouseX <= dividedWidth) {
            if (mouseY >= 0 && mouseY <= dividedHeight) {
                System.out.println(1);
                drawMove(0,0);
            } else if (mouseY >= dividedHeight && mouseY <= dividedHeight * 2) {
                System.out.println(4);
                drawMove(1,0);
            } else if (mouseY >= dividedHeight * 2 && mouseY <= gamePanelHeight) {
                System.out.println(7);
                drawMove(2,0);
            }
        } else if (mouseX >= dividedWidth && mouseX <= dividedWidth * 2) {
            if (mouseY >= 0 && mouseY <= dividedHeight) {
                System.out.println(2);
                drawMove(0,1);
            } else if (mouseY >= dividedHeight && mouseY <= dividedHeight * 2) {
                System.out.println(5);
                drawMove(1,1);
            } else if (mouseY >= dividedHeight * 2 && mouseY <= gamePanelHeight) {
                System.out.println(8);
                drawMove(2,1);
            }
        } else if (mouseX >= dividedWidth * 2 && mouseX <= gamePanelWidth) {
            if (mouseY >= 0 && mouseY <= dividedHeight) {
                System.out.println(3);
                drawMove(0,2);
            } else if (mouseY >= dividedHeight && mouseY <= dividedHeight * 2) {
                System.out.println(6);
                drawMove(1,2);
            } else if (mouseY >= dividedHeight * 2 && mouseY <= gamePanelHeight) {
                System.out.println(9);
                drawMove(2,2);
            }
        }
    }

    public void drawMove(int yPoint, int xPoint){
        if (scoreCounter.getWhosMove() == 1){
//            ruch X
            if (scoreCounter.moveMade(yPoint, xPoint) == 1){
                System.out.println("X "+pointsList[yPoint][xPoint][0]);
                System.out.println("Y "+pointsList[yPoint][xPoint][1]);
                mainView.getDrawX().addMarkX(pointsList[yPoint][xPoint][0], pointsList[yPoint][xPoint][1], pointsList[yPoint+1][xPoint+1][0], pointsList[yPoint+1][xPoint+1][1]);
                mainView.getDrawX().addMarkX(pointsList[yPoint+1][xPoint][0], pointsList[yPoint+1][xPoint][1], pointsList[yPoint][xPoint+1][0], pointsList[yPoint][xPoint+1][1]);
            }
        } else if (scoreCounter.getWhosMove() == 2){
//            ruch Y
            if (scoreCounter.moveMade(yPoint, xPoint) == 2){
                mainView.getDrawO().addMarkO(pointsList[yPoint][xPoint][0], pointsList[yPoint][xPoint][1], dividedWidth, dividedHeight);
            }
        }
    }


    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}