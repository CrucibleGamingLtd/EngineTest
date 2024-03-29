package cruciblegaming.net;
import java.util.Arrays;
import java.util.Random;

public class ReelsGame {
    private Random m_cRng = new Random(123);

    /**
     * Each of these numbers represents the relevant symbol
     */
    private int[][] Reels = {
            {0, 2, 3, 1, 5, 8, 0, 6, 1, 2, 4, 1, 0, 10, 2, 5, 4, 7, 6, 8, 1, 7, 2, 9, 4, 2, 0, 3, 4, 5, 0, 8, 4, 0, 3, 6, 1, 2, 10, 6, 8, 1, 2, 9, 4, 2, 1, 3, 4, 0, 9, 3, 0, 4, 3, 0, 1, 1, 0, 2, 3, 4, 2, 3, 4, 2, 1, 3, 7, 0, 3, 1, 2, 3, 0, 1, 5},
            {0, 3, 5, 4, 2, 0, 5, 1, 0, 10, 4, 2, 3, 1, 0, 6, 1, 4, 0, 3, 5, 10, 2, 1, 6, 2, 8, 1, 3, 8, 6, 1, 0, 4, 3, 5, 1, 9, 0, 1, 3, 0, 4, 9, 3, 2, 0, 7, 1, 3, 4, 7, 2, 3, 0, 7, 2, 3, 0, 4, 2, 5, 4, 7, 0, 2, 7, 1, 2, 9, 4, 5, 1, 4, 8, 2, 1},
            {3, 2, 1, 8, 4, 0, 7, 4, 1, 6, 3, 0, 6, 5, 1, 0, 5, 4, 10, 3, 0, 1, 4, 2, 9, 3, 0, 1, 9, 2, 3, 5, 4, 2, 8, 1, 4, 10, 0, 3, 6, 1, 2, 7, 3, 0, 5, 1, 2, 9, 4, 2, 3, 5, 10, 2, 8, 1, 0, 5, 2, 7, 0, 1, 8, 3, 2, 6, 0, 4, 6, 1, 0, 7, 1, 6, 3},
            {0, 5, 2, 4, 8, 2, 1, 2, 5, 1, 10, 3, 1, 2, 5, 4, 3, 7, 2, 1, 6, 3, 0, 7, 1, 2, 3, 10, 5, 2, 0, 4, 3, 6, 4, 7, 0, 3, 6, 0, 1, 9, 4, 2, 3, 5, 2, 4, 6, 0, 1, 8, 0, 4, 7, 1, 0, 9, 2, 5, 1, 0, 8, 1, 0, 6, 4, 2, 8, 0, 1, 2, 6, 1, 0, 3, 5},
            {0, 3, 6, 1, 4, 8, 2, 0, 4, 5, 10, 0, 2, 6, 1, 2, 9, 4, 10, 3, 7, 1, 0, 6, 4, 0, 2, 7, 0, 3, 2, 5, 4, 1, 0, 6, 7, 1, 0, 8, 3, 2, 1, 3, 4, 7, 1, 3, 6, 2, 5, 0, 1, 3, 8, 0, 2, 9, 4, 2, 1, 4, 5, 2, 8, 3, 0, 6, 1, 2, 5, 0, 1, 5, 2, 1, 3}
    };

    /**
    * Example:
    * In the following display there are five "Ace" symbols on winline 5
    * and 4 "Double Bar" symbols on winline 8
    * 8, 4, 4, 4, 0
    * 4, 6, 7, 2, 4
    * 7, 7, 2, 7, 3
    */
    private int[][] PayLines = {
            {0, 0, 0, 0, 0},
            {1, 1, 1, 1, 1},
            {2, 2, 2, 2, 2},
            {0, 1, 2, 1, 0},
            {2, 1, 0, 1, 2},
            {1, 0, 0, 0, 1},
            {1, 2, 2, 2, 1},
            {0, 0, 1, 2, 2},
            {2, 2, 1, 2, 2},
            {1, 2, 1, 0, 1},
    };

    private String[] symbolNames = {"Ten","Jack","Queen","King","Ace","Bell","Bar","Double Bar","Star","Wild","Scatter"};
    private int[][] PayTable = {
            {0, 0, 5, 10, 25},
            {0, 0, 5, 10, 25},
            {0, 0, 10, 25, 50},
            {0, 0, 10, 25, 50},
            {0, 0, 25, 50, 100},
            {0, 5, 30, 50, 150},
            {0, 5, 30, 50, 150},
            {0, 10, 40, 100, 200},
            {0, 50, 100, 500, 2000},
            {0, 50, 100, 500, 2000},
            {0, 0, 100, 10000, 50000}
    };
    private int[][] Display = new int[5][3];

    int WILD = 9;
    int SCATTER = 10;

    public String playGame() {

        String sResultsString = "";

        // Set number of plays
        int numberOfPlays = 1;

        // Run game
        for(int play=0; play<numberOfPlays; play++) {

            // Build a display
            // ...

            // Evaluate winlines
            // ...

            // Construct a results string
            // ...

            // Output spin results to console
            // ...

        }

        return sResultsString;
    }

}
