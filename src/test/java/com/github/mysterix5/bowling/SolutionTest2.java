package com.github.mysterix5.bowling;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class SolutionTest2 {

    @Test
    public void test_11111() {
        // assertEquals("expected", "actual");
        System.out.println("Maybe this bowler should put bumpers on...\n ");
        assertEquals(20, Solution2.bowling_score("11 11 11 11 11 11 11 11 11 11"));
    }
    @Test
    public void test_XXXX(){
        System.out.println("Woah! Perfect game!");
        assertEquals(300, Solution2.bowling_score("X X X X X X X X X XXX"));
    }
    @Test
    public void test_XX0() {
        assertEquals(30, Solution2.bowling_score("X X 00 00 00 00 00 00 00 00"));
    }
    @Test
    public void test_XX42() {
        assertEquals(46, Solution2.bowling_score("X X 42 00 00 00 00 00 00 00"));
    }
    @Test
    public void test_0XXX() {
        assertEquals(30, Solution2.bowling_score("00 00 00 00 00 00 00 00 00 XXX"));
    }
    @Test
    public void test_0XXXX() {
        assertEquals(60, Solution2.bowling_score("00 00 00 00 00 00 00 00 X XXX"));
    }

    @Test
    public void test_arghssss(){
        assertEquals(150, Solution2.bowling_score("5/ 4/ 3/ 2/ 1/ 0/ X 9/ 4/ 8/8"));
    }
    @Test
    public void test_arghssss2(){
        assertEquals(124, Solution2.bowling_score("5/ 4/ 3/ 2/ 1/ 0/ X 9/ 4/ 00"));
    }
}