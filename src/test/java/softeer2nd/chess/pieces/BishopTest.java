package softeer2nd.chess.pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static softeer2nd.chess.pieces.Bishop.createBlackBishop;
import static softeer2nd.chess.pieces.Bishop.createWhiteBishop;
import static softeer2nd.chess.pieces.Piece.Color.BLACK;
import static softeer2nd.chess.pieces.Piece.Color.WHITE;

public class BishopTest {

    @Test
    @DisplayName("비숍 생성 확인")
    public void create_bishop() {
        verifyKnight(createWhiteBishop(), WHITE, Type.BISHOP);
        verifyKnight(createBlackBishop(), BLACK, Type.BISHOP);
    }

    private void verifyKnight(Bishop bishop, Piece.Color color, Type type) {
        assertEquals(bishop.getColor(), color);
        assertEquals(bishop.getType(), type);
    }
}
