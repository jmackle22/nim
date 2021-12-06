import java.lang.Math;

public class Board {
    public static int numPieces;

    public static void populate() {numPieces = (int) (Math.random() * 41 + 10);}

    public static void takePieces(int amount) {
        numPieces -= amount;
    }
}
