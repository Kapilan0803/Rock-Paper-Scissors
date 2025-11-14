package com.game.rps;

import com.game.rps.enums.Choice;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for game logic
 */
class GameTest {

    @BeforeEach
    void setUp() {
        // Setup code if needed
    }

    @Test
    void testRockBeatsScissors() {
        assertTrue(Choice.ROCK.beats(Choice.SCISSORS));
    }

    @Test
    void testPaperBeatsRock() {
        assertTrue(Choice.PAPER.beats(Choice.ROCK));
    }

    @Test
    void testScissorsBeatsPaper() {
        assertTrue(Choice.SCISSORS.beats(Choice.PAPER));
    }

    @Test
    void testRockDoesNotBeatPaper() {
        assertFalse(Choice.ROCK.beats(Choice.PAPER));
    }

    @Test
    void testPaperDoesNotBeatScissors() {
        assertFalse(Choice.PAPER.beats(Choice.SCISSORS));
    }

    @Test
    void testScissorsDoesNotBeatRock() {
        assertFalse(Choice.SCISSORS.beats(Choice.ROCK));
    }

    @Test
    void testSameChoiceDoesNotBeat() {
        assertFalse(Choice.ROCK.beats(Choice.ROCK));
        assertFalse(Choice.PAPER.beats(Choice.PAPER));
        assertFalse(Choice.SCISSORS.beats(Choice.SCISSORS));
    }

    @Test
    void testChoiceFromStringRock() {
        assertEquals(Choice.ROCK, Choice.fromString("r"));
        assertEquals(Choice.ROCK, Choice.fromString("R"));
        assertEquals(Choice.ROCK, Choice.fromString("rock"));
        assertEquals(Choice.ROCK, Choice.fromString("ROCK"));
        assertEquals(Choice.ROCK, Choice.fromString("Rock"));
    }

    @Test
    void testChoiceFromStringPaper() {
        assertEquals(Choice.PAPER, Choice.fromString("p"));
        assertEquals(Choice.PAPER, Choice.fromString("P"));
        assertEquals(Choice.PAPER, Choice.fromString("paper"));
        assertEquals(Choice.PAPER, Choice.fromString("PAPER"));
    }

    @Test
    void testChoiceFromStringScissors() {
        assertEquals(Choice.SCISSORS, Choice.fromString("s"));
        assertEquals(Choice.SCISSORS, Choice.fromString("S"));
        assertEquals(Choice.SCISSORS, Choice.fromString("scissors"));
        assertEquals(Choice.SCISSORS, Choice.fromString("SCISSORS"));
    }

    @Test
    void testChoiceFromStringInvalid() {
        assertNull(Choice.fromString("invalid"));
        assertNull(Choice.fromString(""));
        assertNull(Choice.fromString(null));
        assertNull(Choice.fromString("123"));
    }

    @Test
    void testChoiceDisplay() {
        assertTrue(Choice.ROCK.getDisplay().contains("Rock"));
        assertTrue(Choice.PAPER.getDisplay().contains("Paper"));
        assertTrue(Choice.SCISSORS.getDisplay().contains("Scissors"));
    }

    @Test
    void testComputerMakesValidChoice() {
        Computer computer = new Computer();
        Choice choice = computer.makeChoice();
        assertNotNull(choice);
        assertTrue(choice == Choice.ROCK || choice == Choice.PAPER || choice == Choice.SCISSORS);
    }

    @Test
    void testComputerDifficultySettings() {
        Computer computer = new Computer();

        computer.setDifficulty(0);
        assertEquals("Easy", computer.getDifficultyString());

        computer.setDifficulty(1);
        assertEquals("Medium", computer.getDifficultyString());

        computer.setDifficulty(2);
        assertEquals("Hard", computer.getDifficultyString());
    }
}