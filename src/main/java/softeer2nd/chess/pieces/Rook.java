package softeer2nd.chess.pieces;


public class Rook extends Piece{
    public static final String NAME = "rook";
    public static final char WHITE_ROOK_REPRESENTATION = 'r';
    public static final char BLACK_ROOK_REPRESENTATION = 'R';
    private Rook(final String color, String name) {
        this.color = color;
        this.name = name;
    }

    public static Rook createWhiteRook() {
        return new Rook(WHITE_COLOR, NAME);
    }

    public static Rook createBlackRook() {
        return new Rook(BLACK_COLOR, NAME);
    }


    @Override
    public char getRepresentation() {
        if(this.getColor().equals(BLACK_COLOR)) {
            return BLACK_ROOK_REPRESENTATION;
        }
        return WHITE_ROOK_REPRESENTATION;
    }
}
