package softeer2nd.chess.pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.pieces.Piece.Color;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static softeer2nd.chess.pieces.Piece.Color.EMPTY;

public class BlankTest {

    @Test
    @DisplayName("빈 기물 생성 검사")
    public void create_blank() {
        validBlank(Blank.createBlank(), EMPTY, Type.NO_PIECE);
    }

    private void validBlank(Blank blank, Color color, Type type) {
        assertEquals(blank.color, color);
        assertEquals(blank.type, type);
    }

}
