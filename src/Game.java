import java.util.Scanner;
import java.lang.Math;

public class Game {
    private Scanner sc = new Scanner(System.in);
    private String playerOne;
    private String playerTwo;
    private int turn;

    public Game() {
        // get players names
        System.out.println("Please enter your name (player 1):");
        this.playerOne = sc.nextLine();
        System.out.println("Please enter your name (player 2):");
        this.playerTwo = sc.nextLine();

        // randomize turn and populate board
        this.turn = (int) (Math.random() * 2 + 1);
        Board.populate();
    }

    public void play() {
        // display variables
        System.out.println("\nGame of Nim: " + playerOne + " vs. " + playerTwo +
                "\n  Pieces: " + Board.numPieces +
                "\n  Turn: Player " + turn);

        // game loop (until all pieces are taken)
        while (Board.numPieces > 0) {
            if (this.turn == 1) {
                takeTurn(playerOne);
            } else if (this.turn == 2) {
                takeTurn(playerTwo);
            }
        }

        // state winner
        if (this.turn == 1) {
            declareWinner(playerOne);
        } else if (this.turn == 2) {
            declareWinner(playerTwo);
        }

        // Wilgumn's message
        System.out.println("\"I would like to personally thank the bulbous " + playerOne + " and genial " +
                playerTwo + " for playing my wonderful game.\" -Wilgumn Red (2021)");
    }

    public void takeTurn(String player) {
        System.out.println("\nIt is " + player + "'s turn." +
                "\n  There are " + Board.numPieces + " pieces on the board.");

        // take pieces (check if input is in range)
        int take = 0;
        while (!(take >= 1 && take <= (int)Math.ceil((double)Board.numPieces/2))) {
            System.out.println("How many pieces would you like to take? (1 to " + (int)Math.ceil((double)Board.numPieces/2) + ")");
            take = Integer.parseInt(sc.nextLine());
        }
        Board.takePieces(take);

        // switch turn
        if (this.turn == 1) {this.turn = 2;} else if (this.turn == 2) {this.turn = 1;}
    }

    private static void declareWinner(String winner) {
        // pretty winner statement (useless but fun string manipulation stuff)
        String winnerStatement = "\uD83C\uDFC6 The winner is " + winner + "! \uD83C\uDFC6";
        String line = new String(new char[winnerStatement.length()]).replace('\0', '≈');
        System.out.println("\n" + line);
        System.out.println(winnerStatement);
        System.out.println(line + "\n");
    }
}
