package softeer2nd.chess.pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static softeer2nd.chess.pieces.King.*;
import static softeer2nd.chess.pieces.Piece.Color.BLACK;
import static softeer2nd.chess.pieces.Piece.Color.WHITE;

public class KingTest {

    @Test
    @DisplayName("Create King Validation")
    public void create_king() {
        verifyKing(createWhiteKing(), WHITE, Type.KING);
        verifyKing(createBlackKing(), BLACK, Type.KING);
    }

    private void verifyKing(King king, Piece.Color color, Type type) {
        assertEquals(king.getColor(), color);
        assertEquals(king.getType(), type);
    }
}
