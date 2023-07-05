package softeer2nd.chess.pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static softeer2nd.chess.pieces.Knight.*;
import static softeer2nd.chess.pieces.Piece.Color.BLACK;
import static softeer2nd.chess.pieces.Piece.Color.WHITE;

public class KnightTest {

    @Test
    @DisplayName("Create Knight Validation")
    public void create_knight() {
        verifyKnight(createWhiteKnight(), WHITE, Type.KNIGHT);
        verifyKnight(createBlackKnight(), BLACK, Type.KNIGHT);
    }

    private void verifyKnight(Knight knight, Piece.Color color, Type type) {
        assertEquals(knight.getColor(), color);
        assertEquals(knight.getType(), type);
    }
}
