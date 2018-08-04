package com.company;

public class Game {
    private String answer;
    private String hits;
    private String misses;
    public static final int MAX_TRIES = 7;

    public Game(String answer) {
        this.answer = answer.toLowerCase();
        hits = "";
        misses = "";
    }

    public String getAnswer() {
        return answer;
    }

    private char normalizedGuess(char letter) {
        if (!Character.isLetter(letter)) {
            throw new IllegalArgumentException("A letter is required");
        }
        letter = Character.toLowerCase(letter);
        if (misses.indexOf(letter) != -1 || hits.indexOf(letter) != -1) {
            throw new IllegalArgumentException(letter + " has already been guessed");
        }
        return letter;
    }

    public boolean applyGuess(String letters) {
        if (letters.length() == 0) {
            throw new IllegalArgumentException("No letter found");
        }
        return applyGuess(letters.charAt(0));
    }

    public boolean applyGuess(char letter) {
        letter = normalizedGuess(letter);
        boolean isHit = answer.indexOf(letter) != -1; //check if letter is in the answer
        if (isHit) {
            hits += letter;     //concatenate letter to hit if in the letter
        } else {
            misses += letter;   //concatenate letter to miss if we guessed incorrect
        }
        return isHit;
        //can use: return tiles.indexOf(tile) >= 0;
    }

    public int getRemainingTries() {
        return MAX_TRIES - misses.length();
    }

    public String getCurrentProgress() {
        String progress = "";
        for (char letter : answer.toCharArray()) {
            char display = '_';
            if (hits.indexOf(letter) != -1) {
                display = letter;
            }
            progress += display;
        }
        return progress;
    }

    public boolean isWon() { //isWon not getWon because it's a boolean 
        return getCurrentProgress().indexOf('_') == -1; //_ not found 
    }
}