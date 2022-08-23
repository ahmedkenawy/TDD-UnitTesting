package com.a7medkenawy.tdd;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class GameTest {

    Game game;

    @Before
    public void setUp() throws Exception {
        game = new Game();
    }

    @After
    public void tearDown() throws Exception {
        game = null;
    }

    @Test
    public void rollZeroScoreIsZero() {
        game.roll(0);
        assertEquals(0, game.score());
    }

    @Test
    public void openFrameAddsPins() {
        game.roll(2);
        game.roll(4);
        assertEquals(6, game.score());
    }

    @Test
    public void spareAddsNextBall() {
        game.roll(4);
        game.roll(6);
        game.roll(3);
        game.roll(0);
        assertEquals(16, game.score());
    }

    @Test
    public void aTenInTwoFramesIsNotASpare() {
        game.roll(3);
        game.roll(6);
        game.roll(4);
        game.roll(5);
        assertEquals(18, game.score());
    }

    @Test
    public void aStrikeAddsNextTwoBalls() {
        game.roll(10);
        game.roll(6);
        game.roll(3);
        assertEquals(28, game.score());
    }
}