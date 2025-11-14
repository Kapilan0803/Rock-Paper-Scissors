# 🎮 Rock Paper Scissors Game

A feature-rich, console-based Rock Paper Scissors game built with Java. Play against a strategic AI opponent with multiple difficulty levels!

## ✨ Features

- 🎯 **Three Difficulty Levels**: Easy, Medium, and Hard
- 📊 **Comprehensive Statistics**: Track wins, losses, ties, and win streaks
- 🤖 **Strategic AI**: Computer learns from your moves in higher difficulties
- 🎨 **Beautiful UI**: Clean console interface with emojis
- ⚡ **Smooth Animations**: Typing effects and delays for immersive gameplay
- 📈 **Win Rate Tracking**: See your performance over multiple games
- 🏆 **Streak Tracking**: Monitor your winning and losing streaks
- ✅ **Unit Tests**: Comprehensive test coverage with JUnit 5

## 🛠️ Prerequisites

- **Java Development Kit (JDK)**: Version 8 or higher
- **Apache Maven**: Version 3.6 or higher
- **Terminal/Command Prompt**: For running the console application


### Gameplay Instructions

1. **Enter your name** when prompted (or press Enter for default)
2. **Choose difficulty level**:
   - Easy: Random computer moves
   - Medium: 50% strategic, 50% random
   - Hard: 70% strategic, 30% random
3. **Make your choice** each round:
   - Type `R` or `Rock` for Rock ✊
   - Type `P` or `Paper` for Paper ✋
   - Type `S` or `Scissors` for Scissors ✌
4. **View results** after each round
5. **Play again** or view final statistics

## 📁 Project Structure

```
rock-paper-scissors/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── game/
│   │   │           └── rps/
│   │   │               ├── Main.java              # Entry point
│   │   │               ├── Game.java              # Game orchestration
│   │   │               ├── Player.java            # Human player
│   │   │               ├── Computer.java          # AI opponent
│   │   │               ├── Statistics.java        # Stats tracking
│   │   │               └── enums/
│   │   │                   └── Choice.java        # Game choices enum
│   │   └── resources/
│   │       └── config.properties                  # Configuration
│   └── test/
│       └── java/
│           └── com/
│               └── game/
│                   └── rps/
│                       ├── GameTest.java          # Game logic tests
│                       └── StatisticsTest.java    # Statistics tests
├── pom.xml                                        # Maven config
├── README.md                                      # This file
├── .gitignore                                     # Git ignore rules
└── LICENSE                                        # License file
```


## 🏗️ Architecture

### Design Patterns Used

- **Enum Pattern**: For game choices with built-in logic
- **Strategy Pattern**: Different AI strategies based on difficulty
- **Single Responsibility**: Each class has one clear purpose
- **Encapsulation**: Private fields with public methods

### Class Responsibilities

- **Main**: Application entry point
- **Game**: Orchestrates game flow and rounds
- **Player**: Handles human input and choices
- **Computer**: AI opponent with strategic logic
- **Statistics**: Tracks and displays game metrics
- **Choice**: Enum with game rules logic

## 🎯 Game Rules

- ✊ **Rock** crushes ✌ **Scissors**
- ✋ **Paper** covers ✊ **Rock**
- ✌ **Scissors** cuts ✋ **Paper**
- Same choice = Tie


## 🙏 Acknowledgments

- Inspired by the classic Rock Paper Scissors game
- Built as a learning project for Java and Maven
- Thanks to the Java and open-source community
