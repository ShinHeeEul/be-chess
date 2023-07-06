package softeer2nd.chess.pieces;

import static softeer2nd.chess.pieces.Piece.Color.*;

public class King extends Piece{
    private King(final Color color, Type type) {
        super(color, type,Point.KING);
    }

    public static King createWhiteKing() {
        return new King(WHITE, Type.KING);
    }

    public static King createBlackKing() {
        return new King(BLACK, Type.KING);
    }
}
