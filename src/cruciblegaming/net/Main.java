package cruciblegaming.net;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class Main {
    /**
     * TODO: Run game 1m times and collect statistics:
     *          total amounts spent and won
     *          RTP (what percentage of the total cost do you win back)
     *          Average value of a win
     *          Percentage of winning spins
     *          Print to console in a readable format
     *          How many wins for each symbol, and of what length (i.e. 3,4 or 5 of a kind)
     * @param args String[]
     */
    public static void main(String[] args) {
        ReelsGame reelsGame = new ReelsGame();
        int bet = 10;
        double totWin = 0;
        double totCost = 0;
        double winSpins = 0;
        HashMap<String, HashMap<String,Integer>> wins = new HashMap<>();


        for(int i=0;i<1000000;i++){
            totCost += bet;

            String sWinString = reelsGame.playGame();
            if(!sWinString.equals("")) {
                ++winSpins;
                String sWinData[] = sWinString.split("&");
                for (String sWinDatum : sWinData) {
                    String[] data = sWinDatum.split(",");
                    String symbolID = data[0];
                    String oak = data[1];
                    totWin += Integer.parseInt(data[2]);
                    if (wins.containsKey(symbolID)) {
                        if (wins.get(symbolID).containsKey(oak)) {
                            wins.get(symbolID).put(oak, wins.get(symbolID).get(oak) + 1);
                        } else {
                            wins.get(symbolID).put(oak, 1);
                        }
                    } else {
                        wins.put(symbolID, new HashMap<>());
                        wins.get(symbolID).put(oak, 1);
                    }
                }
            }
        }

        // Printout
        for(Map.Entry<String, HashMap<String, Integer>> t : wins.entrySet()){
            System.out.println("Symbol " + t.getKey());
            for(Map.Entry<String, Integer> hits : t.getValue().entrySet()){
                System.out.println(hits.getKey() + " oak: " + hits.getValue() + " hits");
            }
        }
        DecimalFormat df = new DecimalFormat("#.###");
        System.out.println("");
        System.out.println("Winning spin pc: " + df.format(winSpins/10000) + "%");
        System.out.println("Average win: " + df.format(totWin/1000000));
        System.out.printf("Total cost: £%.0f" + System.lineSeparator(), totCost/100);
        System.out.printf("Total win: £%.0f" + System.lineSeparator(), totWin/100);
        System.out.println("RTP: " + df.format(totWin/totCost*100) + "%");
        System.out.printf("Balance: £%.0f", (totWin-totCost)/100);
    }
}
