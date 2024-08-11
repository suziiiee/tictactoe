public class Board {
    private final char[][] board;

    public Board() {
        board = new char[3][3];
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    public void printBoard() {
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 3; j++) {
//                System.out.println(board[i][j]);
//                if (j < 2) System.out.println("|");
//            }
//
//            System.out.println();
//            if (i < 2) System.out.println("--------------");
//        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j]);
                if (j < board[i].length - 1) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (i < board.length - 1) {
                System.out.println("---------");
            }
        }
    }

    public boolean isFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean placeMark(int row, int col, char mark) {
        if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == '-') {
            board[row][col] = mark;
            return true;
        }
        return false;

    }

    public boolean checkWin (char mark){
        return (checkRows(mark) || checkColumns(mark) || checkDiagonals(mark));

    }

    private boolean checkDiagonals(char mark) {
        return (board[0][0] == mark && board [1][1] == mark && board[2][2] == mark) ||
                (board[0][2] == mark && board[1][1] == mark && board[2][0] == mark);
    }

    private boolean checkColumns(char mark) {
        for (int i =0; i<3; i++){
            if (board[0][i] == mark && board[1][i] == mark && board[2][i] == mark)
                return true;
        }
        return false;
    }

    private boolean checkRows(char mark) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == mark && board[i][1] == mark && board[i][2] == mark) {
                return true;
            }
        }
        return false;
    }
}
