package cruciblegaming.net;

public class Main {
    /**
     * TODO: Run game 1m times and collect statistics:
     *          total amounts spent and won
     *          RTP (what percentage of the total cost do you win back)
     *          Average value of a win
     *          Percentage of winning spins
     *          Print to console in a readable format
     *          How many wins for each symbol, and of what length (i.e. 2, 3, 4 or 5 of a kind)
     * @param args String[]
     */
    public static void main(String[] args) {
        final int bet = 10;
        ReelsGame reelsGame = new ReelsGame();

        // Loop 1m games
        for(int i=0; i<1000000; i++){
            String sWinString = reelsGame.playGame();
            // ...
        }

        // Printout here

    }
}
