package cruciblegaming.net;

import java.util.Arrays;
import java.util.Random;

/**
 * TODO: Check payouts involving WILD symbol
 * TODO: What would you do to make this code more readable?
 * TODO: Run game 10,000 times and collect statistics:
 *          total amounts spent and won
 *          RTP (what percentage of the total cost do you win back)
 *          Average value of a win
 *          Print to console in a readable format
 * TODO: Note any bugfixes made
 * TODO: Convert primitives to Generics
 * TODO: How many wins for each symbol, and of what length (i.e. 3,4 or 5 of a kind)
 * TODO: Use streams
 */
public class ReelsGame {

    private int m_nTotalWin;

    public ReelsGame() {
        m_nTotalWin = 0;
    }

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
            {0, 0, 20, 200, 2000}
    };
    private int[][] Display = new int[5][3];
    private int[] m_nStops = new int[5];
    private Random m_cRng = new Random(123);

    /**
     * Response string is optional. Feel free to change from String to something more useful if required.
     *
     * @return
     */
    public String playGame() {
        m_nTotalWin = 0;
        // Decide where the reels are going to stop
        for (int i = 0; i < 5; i++) {
            m_nStops[i] = m_cRng.nextInt(Reels.length);
        }

        // Build a display
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                Display[i][j] = Reels[i][m_nStops[i] + j];
            }
        }

        PrintDisplay();

        // Collect any wins
        // TODO: Use Symbol '12' as a WILD symbol
        // TODO: Get the average number of wins per spin
        for (int[] payline : PayLines) {
            // Example:
            int count = 0;
            int startSymbol = Display[0][payline[0]];
            for (count = 0; count < payline.length; count++) {
                if (Display[count][payline[count]] != startSymbol && Display[count][payline[count]] != 12) {
                    break;
                }
            }
            int win = PayTable[startSymbol][count - 1];
            if (win > 0) {
                // TODO: Refactor this win data into a useful class
                System.out.println("PayLine is " + Arrays.toString(payline));
                System.out.println("Symbol: " + startSymbol + " Count: " + count + " Payout: " + PayTable[startSymbol][count - 1]);
                m_nTotalWin += win;
            }
        }

        return String.valueOf(m_nTotalWin);
    }

    private void PrintDisplay() {
        System.out.println(System.lineSeparator() + "Reels:");
        for (int row = 0; row < 3; row++) {
            String sMsg = "";
            for (int col = 0; col < 5; col++) {
                sMsg += Display[col][row] + ",";
            }
            System.out.println(sMsg.substring(0, sMsg.length() - 1));
        }
    }


}
