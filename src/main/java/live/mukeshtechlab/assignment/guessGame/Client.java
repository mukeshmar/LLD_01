package live.mukeshtechlab.assignment.guessGame;

import java.util.Random;

public class Client {
    public static void main(String[] args) {
        Random random = new Random();
        Player p1 = new Player("Mukesh", random);
        Player p2 = new Player("Saumya", random);
        Player p3 = new Player("Bhavesh", random);

        Game game = new Game(p1, p2, p3, random);
        game.launch();

    }
}
