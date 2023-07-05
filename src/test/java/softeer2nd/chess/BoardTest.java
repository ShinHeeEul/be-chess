package softeer2nd.chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.pieces.Piece;

import static org.junit.jupiter.api.Assertions.*;
import static softeer2nd.chess.pieces.Pawn.createWhitePawn;


public class BoardTest {

    Board board;
    @BeforeEach
    public void before() {
        board = new Board();
    }

    @Test
    @DisplayName("Board Create Validation")
    public void create() {
        validAddPawn(1);
    }

    private void validAddPawn(int expected) {
        Piece piece = createWhitePawn();
        board.add(piece);
        assertEquals(expected, board.size());
    }

    @Test
    @DisplayName("Initialize Valid")
    public void initialize() {
        board.initialize();
        assertEquals("pppppppp", board.getWhitePawnsResult());
        assertEquals("PPPPPPPP", board.getBlackPawnsResult());
    }

    @Test
    @DisplayName("Print Valid")
    public void printCheck() {
        String s = """
                ........
                PPPPPPPP
                ........
                ........
                ........
                ........
                pppppppp
                ........""";

        board.initialize();

        assertEquals(s, board.print());

        System.out.println(board.print());
    }
}
