package com.game.rps;

import com.game.rps.enums.Choice;
import java.util.Scanner;

/**
 * Class representing the human player
 */
public class Player {
    private String name;
    private Scanner scanner;

    public Player(String name, Scanner scanner) {
        this.name = name;
        this.scanner = scanner;
    }

    public Player(Scanner scanner) {
        this("Player", scanner);
    }

    /**
     * Get the player's name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the player's name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Prompt the player to make a choice
     * @return The player's chosen move
     */
    public Choice makeChoice() {
        displayChoiceMenu();

        while (true) {
            System.out.print("\nEnter your choice: ");
            String input = scanner.nextLine();

            Choice choice = Choice.fromString(input);

            if (choice != null) {
                return choice;
            }

            System.out.println("❌ Invalid choice! Please enter R, P, S or the full name.");
        }
    }

    /**
     * Display the menu of available choices
     */
    private void displayChoiceMenu() {
        System.out.println("\n╔════════════════════════════════╗");
        System.out.println("║   Choose your weapon:          ║");
        System.out.println("╠════════════════════════════════╣");
        System.out.println("║  [R] ✊  Rock                  ║");
        System.out.println("║  [P] ✋  Paper                 ║");
        System.out.println("║  [S] ✌  Scissors              ║");
        System.out.println("╚════════════════════════════════╝");
    }

    /**
     * Ask if the player wants to play again
     * @return true if player wants to continue, false otherwise
     */
    public boolean wantsToPlayAgain() {
        System.out.print("\nPlay again? (y/n): ");
        String response = scanner.nextLine().trim().toLowerCase();
        return response.equals("y") || response.equals("yes");
    }

    /**
     * Ask if player wants to see rules
     * @return true if player wants to see rules
     */
    public boolean wantsToSeeRules() {
        System.out.print("Would you like to see the rules? (y/n): ");
        String response = scanner.nextLine().trim().toLowerCase();
        return response.equals("y") || response.equals("yes");
    }
}