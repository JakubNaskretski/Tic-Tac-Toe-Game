package com.company.Tests;

import com.company.ScoreCounter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScoreCounterTest {
    @Test
    public void setup(){

        int[][] verticalSum1 = {{0,0,0},{1,1,1},{0,0,0}};
        int[][] verticalSum2 = {{1,1,1},{0,0,0},{0,0,0}};
        int[][] verticalSum3 = {{1,0,0},{0,1,0},{0,0,0}};

        int[][] horizontalSum1 = {{1,0,0},{1,0,0},{1,0,0}};

        ScoreCounter scoreCounter = new ScoreCounter();

        scoreCounter.setScore(verticalSum1);
        assertEquals(true,scoreCounter.ifWonX());

        scoreCounter.setScore(verticalSum2);
        assertEquals(true,scoreCounter.ifWonX());

        scoreCounter.setScore(verticalSum3);
        assertEquals(false,scoreCounter.ifWonX());

        scoreCounter.setScore(horizontalSum1);
        assertEquals(true,scoreCounter.ifWonX());

    }
}