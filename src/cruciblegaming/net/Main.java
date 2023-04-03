package cruciblegaming.net;

import java.io.IOException;

public class Main {
    // Main shouldn't do much; just instantiate a game
    public static void main(String[] args) {
        ReelsGame reelsGame = new ReelsGame();
        double bet = 10;
        double totWin = 0;
        double totCost = 0;

        for(int i=0;i<1000;i++){
            totCost += bet;
            totWin += Integer.parseInt(reelsGame.playGame());
        }
        System.out.println("Total cost: " + totCost);
        System.out.println("Total win: " + totWin);
        System.out.println("RTP: " + totWin/totCost*100 + "%");
        System.out.println("Balance: " + (totWin-totCost));
        System.out.println("Any key to finish");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
