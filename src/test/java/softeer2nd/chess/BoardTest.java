package softeer2nd.chess;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.pieces.Pawn;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;


public class BoardTest {

    Board board;
    @BeforeEach
    public void before() {
        board = new Board();
    }

    @Test
    @DisplayName("Board Create Validation")
    public void create() throws Exception {
        validAddPawn(Pawn.WHITE_COLOR, 1, 0);
        validAddPawn(Pawn.BLACK_COLOR, 2, 1);
    }

    private void validAddPawn(String color, int expected, int i) {
        Pawn pawn = new Pawn(color);
        board.add(pawn);
        assertEquals(expected, board.size());
        assertEquals(pawn, board.findPawn(i));
    }

    @Test
    @DisplayName("Type Validation")
    public void create_다른타입() {
        assertDoesNotThrow(() -> board.add(new Pawn()));
        assertThrows(IllegalArgumentException.class, () -> board.add(Integer.valueOf("7")));

    }

    @Test
    @DisplayName("Initialize Valid")
    public void initialize() throws Exception {
        Board board = new Board();
        board.initialize();
        assertEquals("pppppppp", board.getWhitePawnsResult());
        assertEquals("PPPPPPPP", board.getBlackPawnsResult());
    }
}
