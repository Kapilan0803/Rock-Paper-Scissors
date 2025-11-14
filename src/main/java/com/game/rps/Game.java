package com.game.rps;

import com.game.rps.enums.Choice;
import java.util.Scanner;

/**
 * Main game class that orchestrates the Rock Paper Scissors game
 */
public class Game {
    private Player player;
    private Computer computer;
    private Statistics stats;
    private Scanner scanner;

    public Game(Scanner scanner) {
        this.scanner = scanner;
        this.player = new Player(scanner);
        this.computer = new Computer();
        this.stats = new Statistics();
    }

    /**
     * Start and run the game
     */
    public void start() {
        displayWelcome();
        setupGame();

        boolean playing = true;
        while (playing) {
            playRound();
            playing = player.wantsToPlayAgain();
        }

        displayGameOver();
    }

    /**
     * Display welcome message
     */
    private void displayWelcome() {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║                                        ║");
        System.out.println("║    ROCK ✊  PAPER ✋  SCISSORS ✌       ║");
        System.out.println("║                                        ║");
        System.out.println("║         Welcome to the Game!           ║");
        System.out.println("║                                        ║");
        System.out.println("╚════════════════════════════════════════╝\n");
    }

    /**
     * Setup game with player name and difficulty
     */
    private void setupGame() {
        System.out.print("Enter your name (or press Enter for 'Player'): ");
        String name = scanner.nextLine().trim();
        if (!name.isEmpty()) {
            player.setName(name);
        }

        if (player.wantsToSeeRules()) {
            displayRules();
        }

        selectDifficulty();

        System.out.println("\n" + player.getName() + " vs " + computer.getName());
        System.out.println("Difficulty: " + computer.getDifficultyString());
        System.out.println("\nLet's begin!\n");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    /**
     * Display game rules
     */
    private void displayRules() {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║              GAME RULES                ║");
        System.out.println("╠════════════════════════════════════════╣");
        System.out.println("║  ✊ Rock crushes ✌ Scissors            ║");
        System.out.println("║  ✋ Paper covers ✊ Rock                ║");
        System.out.println("║  ✌ Scissors cuts ✋ Paper              ║");
        System.out.println("╚════════════════════════════════════════╝\n");
    }

    /**
     * Let player select difficulty level
     */
    private void selectDifficulty() {
        System.out.println("\nSelect difficulty level:");
        System.out.println("  [1] Easy (Random moves)");
        System.out.println("  [2] Medium (Somewhat strategic)");
        System.out.println("  [3] Hard (Very strategic)");
        System.out.print("Enter difficulty (1-3): ");

        String input = scanner.nextLine().trim();
        int difficulty = 0;

        try {
            int choice = Integer.parseInt(input);
            difficulty = Math.max(0, Math.min(2, choice - 1));
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Defaulting to Easy.");
        }

        computer.setDifficulty(difficulty);
    }

    /**
     * Play a single round of the game
     */
    public void playRound() {
        System.out.println("\n========================================");
        System.out.println("           ROUND " + (stats.getTotalGames() + 1));
        System.out.println("========================================");

        // Get choices
        Choice playerChoice = player.makeChoice();
        Choice computerChoice = computer.makeChoice();

        // Display choices with animation
        displayChoices(playerChoice, computerChoice);

        // Determine winner
        int result = determineWinner(playerChoice, computerChoice);

        // Update statistics
        updateStatistics(result);

        // Display result
        displayRoundResult(result, playerChoice, computerChoice);

        // Update computer's memory for strategic play
        computer.rememberPlayerChoice(playerChoice);

        // Show current stats
        stats.displayCurrent();
    }

    /**
     * Display player and computer choices with animation
     */
    private void displayChoices(Choice playerChoice, Choice computerChoice) {
        System.out.println("\n" + player.getName() + " chose: " + playerChoice.getDisplay());

        try {
            Thread.sleep(500);
            System.out.print("Computer is choosing");
            for (int i = 0; i < 3; i++) {
                Thread.sleep(300);
                System.out.print(".");
            }
            System.out.println();
            Thread.sleep(300);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println(computer.getName() + " chose: " + computerChoice.getDisplay());
    }

    /**
     * Determine the winner of the round
     * @return 1 if player wins, -1 if computer wins, 0 if tie
     */
    private int determineWinner(Choice playerChoice, Choice computerChoice) {
        if (playerChoice == computerChoice) {
            return 0;
        } else if (playerChoice.beats(computerChoice)) {
            return 1;
        } else {
            return -1;
        }
    }

    /**
     * Update statistics based on round result
     */
    private void updateStatistics(int result) {
        if (result == 1) {
            stats.recordPlayerWin();
        } else if (result == -1) {
            stats.recordComputerWin();
        } else {
            stats.recordTie();
        }
    }

    /**
     * Display the result of the round
     */
    private void displayRoundResult(int result, Choice playerChoice, Choice computerChoice) {
        System.out.println("\n─────────────────────────────────────");

        if (result == 1) {
            System.out.println("    ✅ YOU WIN THIS ROUND! ✅");
            System.out.println("  " + playerChoice.getDisplay() + " beats " + computerChoice.getDisplay());
        } else if (result == -1) {
            System.out.println("    ❌ YOU LOSE THIS ROUND! ❌");
            System.out.println("  " + computerChoice.getDisplay() + " beats " + playerChoice.getDisplay());
        } else {
            System.out.println("    🤝 IT'S A TIE! 🤝");
            System.out.println("  Both chose " + playerChoice.getDisplay());
        }

        System.out.println("─────────────────────────────────────");
    }

    /**
     * Display game over message and final statistics
     */
    private void displayGameOver() {
        System.out.println("\n\n╔════════════════════════════════════════╗");
        System.out.println("║            GAME OVER!                  ║");
        System.out.println("╚════════════════════════════════════════╝");

        stats.displayFinal();

        System.out.println("Thanks for playing, " + player.getName() + "!");
        System.out.println("See you next time! 👋\n");
    }

    // Getters for testing
    public Statistics getStatistics() {
        return stats;
    }

    public Player getPlayer() {
        return player;
    }

    public Computer getComputer() {
        return computer;
    }
}