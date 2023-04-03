package cruciblegaming.net;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {
    // Main shouldn't do much; just instantiate a game
    public static void main(String[] args) {
        ReelsGame reelsGame = new ReelsGame();
        double bet = 10;
        double totWin = 0;
        double totCost = 0;
        HashMap<String, HashMap<String,Integer>> wins = new HashMap<>();

        for(int i=0;i<1000000;i++){
            totCost += bet;

            String winstr = reelsGame.playGame();
            if(!winstr.equals("")) {
                String windata[] = winstr.split("&");
                for (int w = 0; w < windata.length; w++) {
                    String[] data = windata[w].split(",");
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

        for(Map.Entry<String, HashMap<String, Integer>> t : wins.entrySet()){
            System.out.println("Symbol " + t.getKey());
            for(Map.Entry<String, Integer> hits : t.getValue().entrySet()){
                System.out.println(hits.getKey() + " oak: " + hits.getValue() + " hits");
            }
        }
        System.out.println("");
        System.out.println("Total cost: " + totCost);
        System.out.println("Total win: " + totWin);
        System.out.println("RTP: " + totWin/totCost*100 + "%");
        System.out.println("Balance: " + (totWin-totCost));
    }
}
