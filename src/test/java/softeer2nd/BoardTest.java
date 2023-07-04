package softeer2nd;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.Unit.Pawn;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class BoardTest {

    @Test
    @DisplayName("Board Create Validation")
    public void create() throws Exception {
        Board board = new Board();

        Pawn white = new Pawn(Pawn.WHITE_COLOR);
        board.add(white);
        assertEquals(1, board.size());
        assertEquals(white, board.findPawn(0));

        Pawn black = new Pawn(Pawn.BLACK_COLOR);
        board.add(black);
        assertEquals(2, board.size());
        assertEquals(black, board.findPawn(1));
    }
}
