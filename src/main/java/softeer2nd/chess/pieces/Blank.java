package softeer2nd.chess.pieces;

public class Blank extends Piece{


    private Blank(final Color color, Type type) {
        super(color, type, Point.BLANK);
    }


    public static Blank createBlank() {
        return new Blank(Color.EMPTY, Type.NO_PIECE);
    }

}
