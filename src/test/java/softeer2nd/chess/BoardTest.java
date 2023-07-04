package softeer2nd.chess;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.Board;
import softeer2nd.chess.pieces.Pawn;

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

        Pawn white = new Pawn(Pawn.WHITE_COLOR);
        board.add(white);
        assertEquals(1, board.size());
        assertEquals(white, board.findPawn(0));

        Pawn black = new Pawn(Pawn.BLACK_COLOR);
        board.add(black);
        assertEquals(2, board.size());
        assertEquals(black, board.findPawn(1));
    }

    @Test
    @DisplayName("Type Validation")
    public void create_다른타입() {

        assertDoesNotThrow(() -> board.add(new Pawn()));

        assertThrows(IllegalArgumentException.class, () -> board.add(Integer.valueOf("7")));

    }
}
