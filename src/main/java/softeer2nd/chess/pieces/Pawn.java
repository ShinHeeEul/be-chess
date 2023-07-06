package softeer2nd.chess.pieces;


import static softeer2nd.chess.pieces.Piece.Color.*;

public class Pawn extends Piece{
    private Pawn(final Color color, Type type) {
        super(color, type, Point.PAWN);
    }

    public static Pawn createWhitePawn() {
        return new Pawn(WHITE, Type.PAWN);
    }

    public static Pawn createBlackPawn() {
        return new Pawn(BLACK, Type.PAWN);
    }

}
