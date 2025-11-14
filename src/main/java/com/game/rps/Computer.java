package com.game.rps;

import com.game.rps.enums.Choice;
import java.util.Random;

/**
 * Class representing the computer opponent with strategic AI
 */
public class Computer {
    private String name;
    private Random random;
    private Choice lastPlayerChoice;
    private int difficulty; // 0 = Easy, 1 = Medium, 2 = Hard

    public Computer(String name, int difficulty) {
        this.name = name;
        this.random = new Random();
        this.difficulty = difficulty;
        this.lastPlayerChoice = null;
    }

    public Computer() {
        this("Computer", 0); // Default to easy mode
    }

    /**
     * Get the computer's name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the difficulty level
     */
    public void setDifficulty(int difficulty) {
        this.difficulty = Math.max(0, Math.min(2, difficulty));
    }

    /**
     * Computer makes a choice based on difficulty level
     * @return The computer's chosen move
     */
    public Choice makeChoice() {
        switch (difficulty) {
            case 0:
                return makeRandomChoice();
            case 1:
                return makeMediumChoice();
            case 2:
                return makeHardChoice();
            default:
                return makeRandomChoice();
        }
    }

    /**
     * Easy mode - completely random choice
     */
    private Choice makeRandomChoice() {
        Choice[] choices = Choice.values();
        return choices[random.nextInt(choices.length)];
    }

    /**
     * Medium mode - 50% random, 50% counter to player's last move
     */
    private Choice makeMediumChoice() {
        if (lastPlayerChoice == null || random.nextBoolean()) {
            return makeRandomChoice();
        }
        return getCounterChoice(lastPlayerChoice);
    }

    /**
     * Hard mode - 70% counter to player's last move, 30% random
     */
    private Choice makeHardChoice() {
        if (lastPlayerChoice == null || random.nextInt(100) < 30) {
            return makeRandomChoice();
        }
        return getCounterChoice(lastPlayerChoice);
    }

    /**
     * Get the choice that beats the given choice
     */
    private Choice getCounterChoice(Choice choice) {
        switch (choice) {
            case ROCK:
                return Choice.PAPER;
            case PAPER:
                return Choice.SCISSORS;
            case SCISSORS:
                return Choice.ROCK;
            default:
                return makeRandomChoice();
        }
    }

    /**
     * Update the computer's memory with player's last choice
     */
    public void rememberPlayerChoice(Choice choice) {
        this.lastPlayerChoice = choice;
    }

    /**
     * Reset the computer's memory
     */
    public void resetMemory() {
        this.lastPlayerChoice = null;
    }

    /**
     * Get difficulty level as string
     */
    public String getDifficultyString() {
        switch (difficulty) {
            case 0: return "Easy";
            case 1: return "Medium";
            case 2: return "Hard";
            default: return "Unknown";
        }
    }
}