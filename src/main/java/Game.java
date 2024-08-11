import java.util.Scanner;

public class Game {
    private final Board board;
    private final Player player1;
    private final Player player2;
    private Player currentPlayer;

    public Game() {
        board = new Board();
        player1 = new Player('X');
        player2 = new Player('0');
        currentPlayer = player2;
    }

    public void start() {
        boolean endGame = false;

        Scanner scanner = new Scanner(System.in);


        while (!board.isFull() && !endGame) {
            board.printBoard();
            System.out.println("Enter the mark:");
            int co1 = scanner.nextInt();
            int co2 = scanner.nextInt();

            board.placeMark(co1, co2, currentPlayer.getSymbol());
            if (board.checkWin(currentPlayer.getSymbol())) {
                endGame = true;
                System.out.println("Player " + currentPlayer.getSymbol() + " You won");
            } else if (board.isFull()) {
                endGame = true;
                System.out.println("Draw!!!");
            } else {
                switchPlayer();
            }
        }


    }

    private void switchPlayer() {
//        currentPlayer = (currentPlayer == player2) ;
        if (currentPlayer.getSymbol() == '0') {
            currentPlayer = player1;
        } else {
            currentPlayer = player2;
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }

}
