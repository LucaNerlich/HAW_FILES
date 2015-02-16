package SEA.aufgabe2;

public class Game {

    // variables
    public static int NOMOVE = -1;
    public static char EMPTYFIELD = '-';

    public StringBuffer board;

    public Game(String s) {
        board = new StringBuffer(s);
    }

    public Game(StringBuffer s, int position, char player) {
        board = new StringBuffer();
        board.append(s);
        board.setCharAt(position, player);
    }

    public int move(char player) {

        int defaultMove = NOMOVE;

        for (int move = 0; move < 9; move++) {
            if (isEmpty(move)) {
                defaultMove = move;
                Game game = play(move, player);
                if (game.winner() == player) {
                    return defaultMove;
                }
            }
        }

        return defaultMove;
    }

    public Game play(int move, char player) {
        return new Game(this.board, move, player);
    }

    public char winner() {

        final int SIZE = (int) Math.sqrt(board.length() + 1);

        // local variables
        char result = EMPTYFIELD;

        // vertikal
        for (int move = 0; move < board.length(); move++) {

            if (!isEmpty(move)) {

                // horizontal
                if (move == 0 || move % SIZE == 0) {

                    if (board.charAt(move) == board.charAt(move + 1)
                            && board.charAt(move) == board.charAt(move + 2)) {

                        result = board.charAt(move);
                        break;
                    }
                }

                // vertikal
                if (move < SIZE) {

                    if (board.charAt(move) == board.charAt(move + SIZE)
                            && board.charAt(move) == board.charAt(move + (2 * SIZE))) {

                        result = board.charAt(move);
                        break;
                    }
                }

                // diagonal
                if (move == 0) {

                    if (board.charAt(move) == board.charAt(move + (SIZE + 1))
                            && board.charAt(move) == board.charAt(move + (SIZE + 1))) {

                        result = board.charAt(move);
                        break;
                    }
                } else if (move == SIZE - 1) {

                    if (board.charAt(move) == board.charAt(move + (SIZE - 1))
                            && board.charAt(move) == board.charAt(move + (SIZE - 1))) {

                        result = board.charAt(move);
                        break;
                    }
                }


            }

        }

        return result;
    }


    /**
     * method to check if char is '-'
     *
     * @param move
     * @return
     */
    public boolean isEmpty(int move) {
        return board.charAt(move) == EMPTYFIELD;
    }
}
