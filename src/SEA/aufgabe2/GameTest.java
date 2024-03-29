package SEA.aufgabe2;

import junit.framework.TestCase;

public class GameTest extends TestCase {

    public GameTest(String s) {
        super(s);
    }

    public void testDefaultMove() {
        Game game = new Game("XOXOX-OXO");
        assertEquals(5, game.move('X'));

        game = new Game("XOXOXOOX-");
        assertEquals(8, game.move('O'));

        game = new Game("---------");
        // angepasst
        assertEquals(8, game.move('X'));

        game = new Game("XXXXXXXXX");
        assertEquals(-1, game.move('X'));
    }

    public void testFindWinningMove() {
        Game game = new Game("XO-XX-OOX");
        assertEquals(2, game.move('X'));
    }

    public void testWinConditions() {
        Game game = new Game("---XXX---");
        assertEquals('X', game.winner());
    }
}