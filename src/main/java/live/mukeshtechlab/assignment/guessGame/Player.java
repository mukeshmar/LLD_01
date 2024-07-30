package live.mukeshtechlab.assignment.guessGame;

import java.util.Random;

public class Player {
    String name;
    private int guess;
    Random random;

    public Player(String name, Random random){
        this.name = name;
        this.random = random;
    }

    public int getGuess(){
        return guess;
    }

    public void makeGuess(){
        this.guess = random.nextInt(9) + 1;
        System.out.println(this.name + " guessed " + this.guess);
    }
}
