package com.game.rps.enums;

/**
 * Enum representing the possible choices in Rock Paper Scissors
 */
public enum Choice {
    ROCK("Rock", "✊", "R"),
    PAPER("Paper", "✋", "P"),
    SCISSORS("Scissors", "✌", "S");

    private final String name;
    private final String emoji;
    private final String shortCode;

    Choice(String name, String emoji, String shortCode) {
        this.name = name;
        this.emoji = emoji;
        this.shortCode = shortCode;
    }

    public String getName() {
        return name;
    }

    public String getEmoji() {
        return emoji;
    }

    public String getShortCode() {
        return shortCode;
    }

    /**
     * Get formatted display string for the choice
     */
    public String getDisplay() {
        return emoji + " " + name;
    }

    /**
     * Determine if this choice beats another choice
     * @param other The other choice to compare against
     * @return true if this choice wins, false otherwise
     */
    public boolean beats(Choice other) {
        return (this == ROCK && other == SCISSORS) ||
                (this == PAPER && other == ROCK) ||
                (this == SCISSORS && other == PAPER);
    }

    /**
     * Parse a string input to a Choice
     * @param input The user input string
     * @return The corresponding Choice, or null if invalid
     */
    public static Choice fromString(String input) {
        if (input == null || input.isEmpty()) {
            return null;
        }

        String normalized = input.trim().toUpperCase();

        for (Choice choice : Choice.values()) {
            if (choice.name.equalsIgnoreCase(input) ||
                    choice.shortCode.equalsIgnoreCase(input) ||
                    normalized.equals(choice.name.toUpperCase())) {
                return choice;
            }
        }

        return null;
    }

    @Override
    public String toString() {
        return name;
    }
}