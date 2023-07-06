package softeer2nd.chess.pieces;

import static softeer2nd.chess.pieces.Piece.Color.BLACK;
import static softeer2nd.chess.pieces.Piece.Color.WHITE;

public class Queen extends Piece{


    private Queen(final Color color, Type type) {
        super(color, type, Point.QUEEN);
    }

    public static Queen createWhiteQueen() {
        return new Queen(WHITE, Type.QUEEN);
    }

    public static Queen createBlackQueen() {
        return new Queen(BLACK, Type.QUEEN);
    }

}
