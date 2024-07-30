package live.mukeshtechlab.assignment.guessGame;

import java.util.Random;

public class Game {
    private int computerGuess;
    Player p1;
    Player p2;
    Player p3;
    Random random;

    public Game(Player p1, Player p2, Player p3, Random random) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.random = random;
    }

    public void launch() {
        System.out.println("----Welcome to Game----");
        this.computerGuess = random.nextInt(9) + 1;

        while(true){
            System.out.println("Computer Guess " + this.computerGuess);
            p1.makeGuess();
            p2.makeGuess();
            p3.makeGuess();
            if(checkWinner()){
                System.out.println("----Game Over----");
                break;
            }
            else{
                System.out.println("----Restart Game----");
                this.computerGuess = random.nextInt(9) + 1;
            }

        }
    }

    private boolean checkWinner(){
        if(this.computerGuess == p1.getGuess()){
            System.out.println(this.p1.name + " wins");
            return true;
        }
        else if (this.computerGuess == p2.getGuess()){
            System.out.println(this.p2.name + " wins");
            return true;
        }
        else if(this.computerGuess == p3.getGuess()){
            System.out.println(this.p3.name + " wins");
            return true;
        }
        else{
            return false;
        }
    }


}
