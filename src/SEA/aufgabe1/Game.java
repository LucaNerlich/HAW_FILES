package SEA.aufgabe1;

public class Game {
    public StringBuffer board;
    private final int NOMOVE = -1;

    public Game(String s) {
        board = new StringBuffer(s);
    }

    public Game(StringBuffer s, int position, char player) {
        board = new StringBuffer();
        board.append(s);
        board.setCharAt(position, player);
    }

    /*
    1.3
    a: Die zweite Schleife hat eine weitere if-Abfrage, dadurch könnte es unterschiedliche Ergebnisse geben, da verschiedenes abgefragt wird.
    c: Nein, dies kann direkt i sein, da sie innerhalb der for-Schleife initialisiert wird. So wird immer mindestens i zugewiesen.
    d: Läuft!
     */

    public int move(char player) {
        int defaultMove = NOMOVE;
        for (int i = 0; i < 9; i++) {
            if (board.charAt(i) == '-') {
                defaultMove = i;
                Game game = play(i, player);
                if (game.winner() == player) {
                    return defaultMove;
                }
            }
        }
        /*
        for (int i = 0; i < 9; i++) {
            if (board.charAt(defaultMove) == '-')
                return defaultMove;
        } */
        return defaultMove;
    }

    public Game play(int move, char player) {
        return new Game(this.board, move, player);
    }

    public char winner() {

        char token = '-';
        for (int i = 0; i < board.length(); i += 3) {
            if (isEmpty(i) && board.charAt(i) == board.charAt(i + 1)
                    && board.charAt(i + 1) == board.charAt(i + 2)) {
                token = board.charAt(i);
                break;
            }
        }
        return token;
    }

    private boolean isEmpty(int feld) {
        boolean isFeld = false;
        if (board.charAt(feld) != '-') {
            isFeld = true;
        }
        return isFeld;
    }
}
