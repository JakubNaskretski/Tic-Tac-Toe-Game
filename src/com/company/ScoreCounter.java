package com.company;

public class ScoreCounter {

    private int[][] score = new int[3][3];
//    private int[][] scoreY = new int[3][3];
    private int whosMove = 1;

    public ScoreCounter() {
    }

    public boolean ifWonX() {
        for (int i = 0; i < 3; i++) {
            int verticalSum = 0;
            int sum = 0;
            for (int j = 0; j < 3; j++) {
//                Counting if vertical sum is 3 in any row
                    verticalSum += score[j][i];
                if (verticalSum == 3) {
                    return true;}
//                Counting if horizontal sum is 3 in any row
                    sum += score[i][j];
                    if (sum == 3) {
                    return true;
                    }
            }
            if (score[0][0] + score[1][1] + score[2][2] == 3) {
                return true;
            } else if (score[0][2] + score[1][1] + score[2][0] == 3) {
                return true;
            }
        }
        return false;
    }

    public boolean ifWonY() {
        for (int i = 0; i < 3; i++) {
            int verticalSum = 0;
            int sum = 0;
            for (int j = 0; j < 3; j++) {
//                Counting if vertical sum is 3 in any row
                verticalSum += score[j][i];
                if (verticalSum == 15) {
                    return true;}
//                Counting if horizontal sum is 3 in any row
                sum += score[i][j];
                if (sum == 15) {
                    return true;
                }
            }
            if (score[0][0] + score[1][1] + score[2][2] == 15) {
                return true;
            } else if (score[0][2] + score[1][1] + score[2][0] == 15) {
                return true;
            }
        }
        return false;
    }


    protected int moveMade(int yPoint, int xPoint){
        if (whosMove == 1){
            if (score[yPoint][xPoint] == 0){
                score[yPoint][xPoint] = 1;
                System.out.println("X");
            if (ifWonX() == true){
                new winPopUpView("X");
                System.out.println("Player X won!");
                return 1;
            } else if (ifWonX() == false){
            whosMove = 2;
            return 1;}}
        } else if (whosMove == 2) {
            if (score[yPoint][xPoint] == 0) {
                score[yPoint][xPoint] = 5;
                System.out.println("O");
                if (ifWonY() == true) {
                    new winPopUpView("O");
                    System.out.println("Player O won!");
                    return 2;
                } else if (ifWonY() == false) {
                    whosMove = 1;
                return 2;}}
        }
        return 0;
    }

    public int getWhosMove() {
        return whosMove;
    }

    public int[][] getScore() {
        return score;
    }

    public void setScore(int[][] score) {
        this.score = score;
    }
}
