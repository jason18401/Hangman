package com.company;

public class Main {
    public static void main(String[] args) {
        Game game = new Game("hangman");
        Prompter prompter = new Prompter(game);
        while (game.getRemainingTries() > 0 && !game.isWon()) {
            prompter.promptForGuess();
            prompter.displayProgress();
        }
        prompter.displayOutcome();
    }
}

