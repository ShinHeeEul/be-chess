package softeer2nd.chess.pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static softeer2nd.chess.pieces.Piece.Color.*;
import static softeer2nd.chess.pieces.Queen.*;

public class QueenTest {

    @Test
    @DisplayName("퀸 생성 검사")
    public void create_queen() {
        validQueen(createWhiteQueen(), WHITE, Type.QUEEN);
        validQueen(createBlackQueen(), BLACK, Type.QUEEN);
    }

    private void validQueen(Queen queen, Piece.Color color, Type type) {
        assertEquals(queen.getColor(), color);
        assertEquals(queen.getType(), type);
    }
}
