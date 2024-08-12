import java.util.Scanner;

public class Game {
    private final Board board;
    private final Player player1;
    private final Player player2;
    private Player currentPlayer;
    private static Score score;

    public Game(Score score) {
        this.score = score;
        board = new Board();
        player1 = new Player('X');
        player2 = new Player('0');
        currentPlayer = player2;
    }

    public void start() {
        boolean endGame = false;

        Scanner scanner = new Scanner(System.in);


        while (!endGame) {
            board.printBoard();
            System.out.println("Enter the mark:");
            int co1 = scanner.nextInt();
            int co2 = scanner.nextInt();

            board.placeMark(co1, co2, currentPlayer.getSymbol());

            if (board.checkWin(currentPlayer.getSymbol())) {
                endGame = true;
                score.addWin(currentPlayer.getSymbol());
                System.out.println("Player " + currentPlayer.getSymbol() + " You won");
            } else if (board.isFull()) {
                endGame = true;
                System.out.println("Draw!!!");
            } else {
                switchPlayer();
            }
        }

        board.printBoard();
        score.printScores();

    }

    private void switchPlayer() {
        if (currentPlayer == player1) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
    }
//        currentPlayer = (currentPlayer == player2) ;
//        if (currentPlayer.getSymbol() == '0') {
//            currentPlayer = player1;
//        } else {
//            currentPlayer = player2;
//        }
//    }

    public static void main(String[] args) {
        Score score = new Score('X', '0');
        Scanner scanner = new Scanner(System.in);
        char continueGame = 'N';
        do{
            Game game = new Game(score);
            game.start();
            System.out.println("Do you want to play again ? Y/N");
            continueGame = scanner.next().charAt(0);
        }while (continueGame == 'Y' || continueGame == 'y');
    }

}
