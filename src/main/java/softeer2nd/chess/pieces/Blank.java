package softeer2nd.chess.pieces;

public class Blank extends Piece{


    private Blank(final Color color, Type type) {
        this.type = type;
        this.color = color;
    }

    public static Blank createBlank() {
        return new Blank(Color.EMPTY, Type.NO_PIECE);
    }

    @Override
    public char getRepresentation() {
        return type.getBlankRepresentation();
    }
}
