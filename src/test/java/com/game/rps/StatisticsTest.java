package com.game.rps;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for Statistics class
 */
class StatisticsTest {

    private Statistics stats;

    @BeforeEach
    void setUp() {
        stats = new Statistics();
    }

    @Test
    void testInitialStatistics() {
        assertEquals(0, stats.getPlayerWins());
        assertEquals(0, stats.getComputerWins());
        assertEquals(0, stats.getTies());
        assertEquals(0, stats.getTotalGames());
        assertEquals(0, stats.getCurrentWinStreak());
        assertEquals(0, stats.getMaxWinStreak());
    }

    @Test
    void testRecordPlayerWin() {
        stats.recordPlayerWin();

        assertEquals(1, stats.getPlayerWins());
        assertEquals(0, stats.getComputerWins());
        assertEquals(0, stats.getTies());
        assertEquals(1, stats.getTotalGames());
        assertEquals(1, stats.getCurrentWinStreak());
    }

    @Test
    void testRecordComputerWin() {
        stats.recordComputerWin();

        assertEquals(0, stats.getPlayerWins());
        assertEquals(1, stats.getComputerWins());
        assertEquals(0, stats.getTies());
        assertEquals(1, stats.getTotalGames());
        assertEquals(0, stats.getCurrentWinStreak());
    }

    @Test
    void testRecordTie() {
        stats.recordTie();

        assertEquals(0, stats.getPlayerWins());
        assertEquals(0, stats.getComputerWins());
        assertEquals(1, stats.getTies());
        assertEquals(1, stats.getTotalGames());
        assertEquals(0, stats.getCurrentWinStreak());
    }

    @Test
    void testWinStreak() {
        stats.recordPlayerWin();
        stats.recordPlayerWin();
        stats.recordPlayerWin();

        assertEquals(3, stats.getCurrentWinStreak());
        assertEquals(3, stats.getMaxWinStreak());

        stats.recordComputerWin();
        assertEquals(0, stats.getCurrentWinStreak());
        assertEquals(3, stats.getMaxWinStreak()); // Max should persist
    }

    @Test
    void testLoseStreak() {
        stats.recordComputerWin();
        stats.recordComputerWin();

        assertEquals(2, stats.getCurrentLoseStreak());
        assertEquals(2, stats.getMaxLoseStreak());

        stats.recordPlayerWin();
        assertEquals(0, stats.getCurrentLoseStreak());
        assertEquals(2, stats.getMaxLoseStreak());
    }

    @Test
    void testWinRate() {
        assertEquals(0.0, stats.getWinRate(), 0.01);

        stats.recordPlayerWin();
        stats.recordPlayerWin();
        stats.recordComputerWin();
        stats.recordTie();

        // 2 wins out of 4 games = 50%
        assertEquals(50.0, stats.getWinRate(), 0.01);
    }

    @Test
    void testWinPercentageExcludingTies() {
        stats.recordPlayerWin();
        stats.recordPlayerWin();
        stats.recordComputerWin();
        stats.recordTie();
        stats.recordTie();

        // 2 wins out of 3 decisive games = 66.67%
        assertEquals(66.67, stats.getWinPercentageExcludingTies(), 0.1);
    }

    @Test
    void testReset() {
        stats.recordPlayerWin();
        stats.recordPlayerWin();
        stats.recordComputerWin();

        stats.reset();

        assertEquals(0, stats.getPlayerWins());
        assertEquals(0, stats.getComputerWins());
        assertEquals(0, stats.getTies());
        assertEquals(0, stats.getTotalGames());
        assertEquals(0, stats.getCurrentWinStreak());
        assertEquals(0, stats.getMaxWinStreak());
    }

    @Test
    void testMultipleGameScenario() {
        // Simulate a series of games
        stats.recordPlayerWin();      // Player: 1, Computer: 0
        stats.recordPlayerWin();      // Player: 2, Computer: 0
        stats.recordComputerWin();    // Player: 2, Computer: 1
        stats.recordTie();            // Player: 2, Computer: 1, Ties: 1
        stats.recordPlayerWin();      // Player: 3, Computer: 1

        assertEquals(3, stats.getPlayerWins());
        assertEquals(1, stats.getComputerWins());
        assertEquals(1, stats.getTies());
        assertEquals(5, stats.getTotalGames());
        assertEquals(1, stats.getCurrentWinStreak());
        assertEquals(2, stats.getMaxWinStreak());
    }
}