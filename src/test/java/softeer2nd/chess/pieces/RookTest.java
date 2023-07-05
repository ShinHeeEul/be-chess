package softeer2nd.chess.pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static softeer2nd.chess.pieces.Piece.Color.BLACK;
import static softeer2nd.chess.pieces.Piece.Color.WHITE;
import static softeer2nd.chess.pieces.Rook.*;

public class RookTest {

    @Test
    @DisplayName("룩 생성 검사")
    public void create_rook() {
        validRook(createWhiteRook(), WHITE, Type.ROOK);
        validRook(createBlackRook(), BLACK, Type.ROOK);
    }

    private void validRook(Rook rook, Color color, Type type) {
        assertEquals(rook.getColor(), color);
        assertEquals(rook.getType(), type);
    }
}
