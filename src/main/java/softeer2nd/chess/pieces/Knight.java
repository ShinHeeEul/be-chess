package softeer2nd.chess.pieces;

import static softeer2nd.chess.pieces.Piece.Color.*;

public class Knight extends Piece{
    private Knight(final Color color, Type type) {
        super(color, type, Point.KNIGHT);
    }

    public static Knight createWhiteKnight() {
        return new Knight(WHITE, Type.KNIGHT);
    }

    public static Knight createBlackKnight() {
        return new Knight(BLACK, Type.KNIGHT);
    }
}