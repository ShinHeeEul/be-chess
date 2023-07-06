package softeer2nd.chess;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PositionTest {

    Position position;
    final int ROW = 2;
    final int COL = 2;
    final String SQUARE = "c6";

    @Test
    @DisplayName("row, col로 위치값이 설정되는지?")
    public void to_square() {
        position = new Position(ROW, COL);
        Assertions.assertEquals(SQUARE, position.getSquare());
    }

    @Test
    @DisplayName("Square로 row, col이 반환이 되는지?")
    public void to_coord() {
        position = new Position(SQUARE);
        Assertions.assertEquals(ROW, position.getRow());
        Assertions.assertEquals(COL, position.getCol());
    }
}
