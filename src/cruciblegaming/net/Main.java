package cruciblegaming.net;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ReelsGame reelsGame = new ReelsGame();
        int playerBalance = 1000000;
        int spins = Integer.parseInt(args[0]);
        int bet = Integer.parseInt(args[1]);
        int totalCost = 0;
        int totalWon=0;

        // Run game
        for(int i=0;i<spins;i++){
            // Handle spin cost
            // ..
            totalCost += bet;

            // Evaluate spin result
            String sWinString = reelsGame.playGame();

            // Handle winnings
            // ..
        }

        // Output overall results
        // ..
        playerBalance -= totalCost;
        System.out.println("Total cost " + totalCost);
        System.out.println("Total won " + totalWon);
        System.out.println("Player balance " + (playerBalance-totalCost+totalWon));
    }
}
