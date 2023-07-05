package softeer2nd.chess.pieces;

import static softeer2nd.chess.pieces.Piece.Color.*;

public class Bishop extends Piece{
    private Bishop(final Color color, Type type) {
        this.color = color;
        this.type = type;
    }

    public static Bishop createWhiteBishop() {
        return new Bishop(WHITE, Type.BISHOP);
    }

    public static Bishop createBlackBishop() {
        return new Bishop(BLACK, Type.BISHOP);
    }
}
