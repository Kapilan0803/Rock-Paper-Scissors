package com.game.rps;

/**
 * Class to track and display game statistics
 */
public class Statistics {
    private int playerWins;
    private int computerWins;
    private int ties;
    private int totalGames;
    private int currentWinStreak;
    private int maxWinStreak;
    private int currentLoseStreak;
    private int maxLoseStreak;

    public Statistics() {
        this.playerWins = 0;
        this.computerWins = 0;
        this.ties = 0;
        this.totalGames = 0;
        this.currentWinStreak = 0;
        this.maxWinStreak = 0;
        this.currentLoseStreak = 0;
        this.maxLoseStreak = 0;
    }

    /**
     * Record a player win
     */
    public void recordPlayerWin() {
        playerWins++;
        totalGames++;
        currentWinStreak++;
        currentLoseStreak = 0;

        if (currentWinStreak > maxWinStreak) {
            maxWinStreak = currentWinStreak;
        }
    }

    /**
     * Record a computer win
     */
    public void recordComputerWin() {
        computerWins++;
        totalGames++;
        currentLoseStreak++;
        currentWinStreak = 0;

        if (currentLoseStreak > maxLoseStreak) {
            maxLoseStreak = currentLoseStreak;
        }
    }

    /**
     * Record a tie
     */
    public void recordTie() {
        ties++;
        totalGames++;
        currentWinStreak = 0;
        currentLoseStreak = 0;
    }

    /**
     * Calculate player's win rate
     */
    public double getWinRate() {
        if (totalGames == 0) return 0.0;
        return (playerWins * 100.0) / totalGames;
    }

    /**
     * Get player's win percentage (excluding ties)
     */
    public double getWinPercentageExcludingTies() {
        int decisiveGames = playerWins + computerWins;
        if (decisiveGames == 0) return 0.0;
        return (playerWins * 100.0) / decisiveGames;
    }

    /**
     * Display current game statistics
     */
    public void displayCurrent() {
        System.out.println("\n--- Current Stats ---");
        System.out.println("Games Played: " + totalGames);
        System.out.println("Your Score: " + playerWins);
        System.out.println("Computer Score: " + computerWins);
        System.out.println("Ties: " + ties);

        if (currentWinStreak > 0) {
            System.out.println("Win Streak: " + currentWinStreak + " 🔥");
        } else if (currentLoseStreak > 0) {
            System.out.println("Lose Streak: " + currentLoseStreak + " 💀");
        }
    }

    /**
     * Display comprehensive final statistics
     */
    public void displayFinal() {
        System.out.println("\n╔════════════════════════════════════╗");
        System.out.println("║      FINAL GAME STATISTICS         ║");
        System.out.println("╚════════════════════════════════════╝");
        System.out.println();
        System.out.println("Total Games Played: " + totalGames);
        System.out.println("─────────────────────────────────────");
        System.out.println("Your Wins:      " + playerWins);
        System.out.println("Computer Wins:  " + computerWins);
        System.out.println("Ties:           " + ties);
        System.out.println("─────────────────────────────────────");

        if (totalGames > 0) {
            System.out.printf("Win Rate:       %.1f%%\n", getWinRate());

            if (playerWins + computerWins > 0) {
                System.out.printf("Win %% (no ties): %.1f%%\n",
                        getWinPercentageExcludingTies());
            }
        }

        if (maxWinStreak > 0) {
            System.out.println("Best Win Streak: " + maxWinStreak + " 🏆");
        }

        System.out.println("─────────────────────────────────────");
        displayOverallResult();
        System.out.println();
    }

    /**
     * Display the overall game result
     */
    private void displayOverallResult() {
        if (playerWins > computerWins) {
            int margin = playerWins - computerWins;
            System.out.println("🏆 YOU ARE THE CHAMPION! 🏆");
            System.out.println("   (Won by " + margin + " game" + (margin > 1 ? "s" : "") + ")");
        } else if (computerWins > playerWins) {
            int margin = computerWins - playerWins;
            System.out.println("💻 COMPUTER WINS! 💻");
            System.out.println("   (Lost by " + margin + " game" + (margin > 1 ? "s" : "") + ")");
        } else {
            System.out.println("🤝 IT'S A PERFECT TIE! 🤝");
        }
    }

    /**
     * Reset all statistics
     */
    public void reset() {
        playerWins = 0;
        computerWins = 0;
        ties = 0;
        totalGames = 0;
        currentWinStreak = 0;
        maxWinStreak = 0;
        currentLoseStreak = 0;
        maxLoseStreak = 0;
    }

    // Getters
    public int getPlayerWins() { return playerWins; }
    public int getComputerWins() { return computerWins; }
    public int getTies() { return ties; }
    public int getTotalGames() { return totalGames; }
    public int getCurrentWinStreak() { return currentWinStreak; }
    public int getMaxWinStreak() { return maxWinStreak; }
    public int getCurrentLoseStreak() { return currentLoseStreak; }
    public int getMaxLoseStreak() { return maxLoseStreak; }
}