import java.util.Scanner;

public class GameRunner {
    public static void main(String[] args) {
        System.out.println("Welcome to the Game of Nim!");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // create a new game and play
            Game nim = new Game();
            nim.play();

            // ask user if they want to play again
            System.out.println("Would you like to play again? (y/n)\n");
            if (scanner.nextLine().contains("n")) {break;}
        }

        System.out.println("\"Thanks for playing Nim! Goodbye\" -Wilgumn Red (2021)");
    }
}
