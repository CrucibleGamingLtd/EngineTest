package cruciblegaming.net;
import java.util.Random;

/**
 * TASK: Given the following reels describing a 5-reel, 3-high slot game, paylines and win table,
 * set up an engine which on each spin sets each reel to a random position and evaluates each payline for wins
 * of 2, 3, 4, and 5 of a kind.
 * TODO: Deal with any compiler warnings.
 * TODO: What would you do to make this code more readable?
 * TODO: Consider making sWinString into a useful class.
 * TODO: Stretch target 1: Use symbolID 10 a WILD symbol which can substitute for any other.
 * TODO: Stretch target 2: If three WILD symbols land anywhere in the display on the first spin only, award 5 free spins.
 * TODO: Stretch target 3: Convert primitives to Generics
 * TODO: Stretch target 4: Employ java streams
 */
public class ReelsGame {
    private Random m_cRng = new Random(123);

    private int[][] Reels = {
            {0, 2, 3, 1, 5, 8, 0, 6, 1, 2, 4, 1, 0, 10, 2, 5, 4, 7, 6, 8, 1, 7, 2, 9, 4, 2, 0, 3, 4, 5, 0, 8, 4, 0, 3, 6, 1, 2, 10, 6, 8, 1, 2, 9, 4, 2, 1, 3, 4, 0, 9, 3, 0, 4, 3, 0, 1, 1, 0, 2, 3, 4, 2, 3, 4, 2, 1, 3, 7, 0, 3, 1, 2, 3, 0, 1, 5},
            {0, 3, 5, 4, 2, 0, 5, 1, 0, 10, 4, 2, 3, 1, 0, 6, 1, 4, 0, 3, 5, 10, 2, 1, 6, 2, 8, 1, 3, 8, 6, 1, 0, 4, 3, 5, 1, 9, 0, 1, 3, 0, 4, 9, 3, 2, 0, 7, 1, 3, 4, 7, 2, 3, 0, 7, 2, 3, 0, 4, 2, 5, 4, 7, 0, 2, 7, 1, 2, 9, 4, 5, 1, 4, 8, 2, 1},
            {3, 2, 1, 8, 4, 0, 7, 4, 1, 6, 3, 0, 6, 5, 1, 0, 5, 4, 10, 3, 0, 1, 4, 2, 9, 3, 0, 1, 9, 2, 3, 5, 4, 2, 8, 1, 4, 10, 0, 3, 6, 1, 2, 7, 3, 0, 5, 1, 2, 9, 4, 2, 3, 5, 10, 2, 8, 1, 0, 5, 2, 7, 0, 1, 8, 3, 2, 6, 0, 4, 6, 1, 0, 7, 1, 6, 3},
            {0, 5, 2, 4, 8, 2, 1, 2, 5, 1, 10, 3, 1, 2, 5, 4, 3, 7, 2, 1, 6, 3, 0, 7, 1, 2, 3, 10, 5, 2, 0, 4, 3, 6, 4, 7, 0, 3, 6, 0, 1, 9, 4, 2, 3, 5, 2, 4, 6, 0, 1, 8, 0, 4, 7, 1, 0, 9, 2, 5, 1, 0, 8, 1, 0, 6, 4, 2, 8, 0, 1, 2, 6, 1, 0, 3, 5},
            {0, 3, 6, 1, 4, 8, 2, 0, 4, 5, 10, 0, 2, 6, 1, 2, 9, 4, 10, 3, 7, 1, 0, 6, 4, 0, 2, 7, 0, 3, 2, 5, 4, 1, 0, 6, 7, 1, 0, 8, 3, 2, 1, 3, 4, 7, 1, 3, 6, 2, 5, 0, 1, 3, 8, 0, 2, 9, 4, 2, 1, 4, 5, 2, 8, 3, 0, 6, 1, 2, 5, 0, 1, 5, 2, 1, 3}
    };
    private int[][] PayLines = {
            {0, 0, 0, 0, 0},
            {1, 1, 1, 1, 1},
            {2, 2, 2, 2, 2},
            {0, 1, 2, 1, 0},
            {2, 1, 0, 1, 2},
            {1, 0, 0, 0, 1},
            {1, 2, 2, 2, 1},
            {0, 0, 1, 2, 2},
            {2, 2, 1, 0, 0},
            {1, 2, 1, 0, 1},
    };

    private int[][] PayTable = {
            {0, 0, 5, 25, 100},
            {0, 0, 5, 25, 100},
            {0, 0, 5, 25, 100},
            {0, 0, 5, 40, 150},
            {0, 0, 5, 40, 150},
            {0, 5, 30, 100, 750},
            {0, 5, 30, 100, 750},
            {0, 5, 40, 400, 2000},
            {0, 5, 40, 400, 2000},
            {0, 10, 100, 1000, 5000},
            {0, 0, 0, 0, 10000}
    };

    /**
     * Response string is optional. Feel free to change from String to something more useful if required.
     * @return some data
     */
    public String playGame() {
        return "";
    }


}
