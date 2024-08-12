import java.util.HashMap;
import java.util.Map;

public class Score {

    //Creating an empty hashmap by declaring the object of character and integer type
    private final Map<Character, Integer> scores;


    public Score(char player1Symbol, char player2Symbol) {
        scores = new HashMap<>();

        //Initializing the scores for both players to map

        scores.put(player2Symbol, 0);
        scores.put(player1Symbol, 0);
    }

    public void addWin(char playerSymbol) {
        scores.put(playerSymbol, scores.get(playerSymbol) + 1);

    }

    public Integer getScore(char playerSymbol) {
        return scores.get(playerSymbol);
    }

    public void resetScore() {
        scores.replaceAll((key, value) -> 0);
    }

    public void printScores() {
        System.out.println("The scores are:");
        scores.forEach((key, value) ->
                System.out.println("Player " + key + ": " + value + " wins."));

    }
}





