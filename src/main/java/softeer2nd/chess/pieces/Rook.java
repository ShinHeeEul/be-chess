package softeer2nd.chess.pieces;


import static softeer2nd.chess.pieces.Piece.Color.*;

public class Rook extends Piece{

    private Rook(final Color color, Type type) {
        super(color, type, Point.ROOK);
    }

    public static Rook createWhiteRook() {
        return new Rook(WHITE, Type.ROOK);
    }

    public static Rook createBlackRook() {
        return new Rook(BLACK, Type.ROOK);
    }

}
