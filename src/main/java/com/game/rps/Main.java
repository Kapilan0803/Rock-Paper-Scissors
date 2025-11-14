package com.game.rps;

import java.util.Scanner;

/**
 * Main entry point for the Rock Paper Scissors game application
 *
 * @author Your Name
 * @version 1.0.0
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Create and start the game
            Game game = new Game(scanner);
            game.start();

        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Clean up resources
            scanner.close();
        }
    }
}