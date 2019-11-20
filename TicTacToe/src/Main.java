public class Main {
    public static void main(String[] args) {
        Board b = new Board();
        boolean p1turn = true;
        boolean gameOver = false;
        char p1 = 'X', p2 = 'O';
        b.printBoard();

        while(gameOver != true) {
            if(p1turn == true) {
                int[] move = b.getMove(p1);
                if(!b.checkEmpty(move)) {
                    System.out.println("Invalid move! There's already a symbol there!");
                    continue;
                }
                b.update(b.getBoard(), move, p1);
                b.printBoard();
                b.checkWin();
                if(b.checkWin()) {
                    gameOver = true;
                    System.out.println(p1 + " is the winner!");
                }
                p1turn = false;
            } else {
                int[] move = b.getMove(p2);
                if(!b.checkEmpty(move)) {
                    System.out.println("Invalid move! There's already a symbol there!");
                    continue;
                }
                b.update(b.getBoard(), move, p2);
                b.printBoard();
                if(b.checkWin()) {
                    gameOver = true;
                    System.out.println(p2 + " is the winner!");
                }
                p1turn = true;
            }


        }




    }
}
