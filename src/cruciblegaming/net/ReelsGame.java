package cruciblegaming.net;

import java.util.Arrays;
import java.util.Random;

/**
 * Make one of the symbols WILD
 */
public class ReelsGame {

    private int m_nTotalWin;

    public ReelsGame(){
        m_nTotalWin = 0;
    }
    private int[][] Reels = {
        {2,1,10,4,2,8,6,3,9,2,4,7,2,9,1,11,2,8,5,7,4,11,5,10,6,4,0,3,2,12},
        {3,4,0,6,4,9,3,4,8,3,7,4,3,10,5,2,8,6,12,1,11,2,10,3,11,5,9,4,1,7},
        {2,7,1,5,12,1,7,5,8,1,4,10,2,1,11,5,6,8,2,6,11,3,1,9,2,4,0,3,5,9},
        {3,9,5,2,12,4,6,8,2,3,7,4,9,3,8,2,11,3,10,6,7,1,5,0,6,1,10,6,1,8},
        {0,3,2,9,1,6,0,11,1,8,4,9,2,3,7,5,4,10,3,0,1,9,4,7,2,8,6,4,8,6,1,12,3,6,7,2,11,5,0,2,5,10},
    };
    private int [][] PayLines = {
            {0,0,0,0,0},
            {1,1,1,1,1},
            {2,2,2,2,2},
            {0,1,2,1,0},
            {2,1,0,1,2},
            {1,0,0,0,1},
            {1,2,2,2,1},
            {0,0,1,2,2},
            {2,2,1,0,0},
            {1,2,1,0,1},
            {1,0,1,2,1},
            {0,1,1,1,0},
            {2,1,1,1,2},
            {0,1,0,1,0},
            {2,1,2,1,2},
            {1,1,0,1,1},
            {1,1,2,1,1},
            {0,0,2,0,0},
            {2,2,0,2,2},
            {0,2,2,2,0}
    };
    private int[][] PayTable = {
            {0,0,5,25,100},
            {0,0,5,25,100},
            {0,0,5,25,100},
            {0,0,5,25,100},
            {0,0,5,50,100},
            {0,0,10,50,125},
            {0,0,10,50,250},
            {0,0,10,75,250},
            {0,0,15,100,400},
            {0,2,5,20,100},
            {0,10,200,2000,10000},
    };
    private int[][] Display = new int[5][3];
    private int [] m_nStops = new int[5];
    private Random m_cRng = new Random(123);
    
    /**
     * Response string is optional. Feel free to change from String to something more useful if required.
     * @return
     */
    public String GetResponse(){
        for(int i=0; i<5; i++){
            m_nStops[i] = m_cRng.nextInt(Reels.length);
        }
        
        for(int i=0; i<5; i++){
            for(int j=0; j<3; j++){
                Display[i][j] = Reels[i][m_nStops[i]+j];
            }
        }

        System.out.println(System.lineSeparator() + "Reels:");
        for(int row=0; row<3; row++){
            String sMsg = "";
            for(int col=0;col<5;col++){
                sMsg += Display[col][row] + ",";
            }
            System.out.println(sMsg.substring(0,sMsg.length()-1));
        }

        // TODO: Use Symbol '12' as a WILD symbol
        // TODO: Get the average number of wins per spin
        for(int [] payline : PayLines){
            // If the symbols on the Display in the pattern provided by this payline match,
            // it's a win if that number of symbols in a line pays > 0 (see PayTable)
            // Example:
            int count = 0;
            int startSymbol = Display[0][payline[0]];
            for(count=0; count<payline.length; count++){
                if(Display[count][payline[count]] != startSymbol && Display[count][payline[count]] != 12){
                    break;
                }
            }
            int win = PayTable[startSymbol][count-1];
            if(win > 0) {
                // TODO: Refactor this win data into a useful class
                System.out.println("PayLine is " + Arrays.toString(payline));
                System.out.println("Symbol: " + startSymbol + " Count: " + count + " Payout: " + PayTable[startSymbol][count - 1]);
                m_nTotalWin += win;
            }
        }
        
        return String.valueOf(m_nTotalWin);
    }
    
    
}
