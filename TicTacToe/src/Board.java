import java.util.Scanner;

public class Board {
    private char[][] board = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '},
    };

    public void printBoard() {
        System.out.println("  0 1 2");
        System.out.println("  ------");
        for (int i = 0; i <= 2; i++) {
            System.out.println(i + "|" + board[i][0] + " " + board[i][1] + " " + board[i][2] + "|");
        }
        System.out.println("  ------");
    }

    public char[][] getBoard() {
        return board;
    }

    public int[] getMove(char player) {
        int[] coord = new int[2];
        Scanner kb = new Scanner(System.in);
        System.out.println(player + "'s Turn!");
        System.out.println("What is the move's x coordinate?");
        coord[0] = kb.nextInt();
        System.out.println("What is the move's y coordinate?");
        coord[1] = kb.nextInt();

        // Put a try-catch statement if it's out of bounds.
        System.out.println(coord[0] + ", " + coord[1]);
        return coord;
    }

    public void update(char[][] b, int[] c, char player) {
        b[c[1]][c[0]] = player;
    }

    public boolean checkWin() {
        char[][] winLines = new char[8][];
        winLines[0] = new char[]{board[0][0], board[0][1], board[0][2]};
        winLines[1] = new char[]{board[1][0], board[1][1], board[1][2]};
        winLines[2] = new char[]{board[2][0], board[2][1], board[2][2]};
        winLines[3] = new char[]{board[0][0], board[1][0], board[2][0]};
        winLines[4] = new char[]{board[0][1], board[1][1], board[2][1]};
        winLines[5] = new char[]{board[0][2], board[1][2], board[2][2]};
        winLines[6] = new char[]{board[0][0], board[1][1], board[2][2]};
        winLines[7] = new char[]{board[2][0], board[1][1], board[0][2]};

        boolean win = false;
        for (int i = 0; i <= 7; i++) {
            char first;
            if(winLines[i][0] != ' ') {
                first = winLines[i][0];
                if (winLines[i][1] == first && winLines[i][2] == first) {
                    win = true;
                }
            }
        }
        return win;
    }

    public boolean checkEmpty(int[] move) {
        if(board[move[1]][move[0]] == ' ') {
            return true;
        } else {
            return false;
        }
    }
}
