package softeer2nd.chess.pieces;


public class Bishop extends Piece{
    public static final String NAME = "bishop";
    public static final char WHITE_BISHOP_REPRESENTATION = 'b';
    public static final char BLACK_BISHOP_REPRESENTATION = 'B';
    private Bishop(final String color, String name) {
        this.color = color;
        this.name = name;
    }

    public static Bishop createWhiteBishop() {
        return new Bishop(WHITE_COLOR, NAME);
    }

    public static Bishop createBlackBishop() {
        return new Bishop(BLACK_COLOR, NAME);
    }

    @Override
    public char getRepresentation() {
        if(this.getColor().equals(BLACK_COLOR)) {
            return BLACK_BISHOP_REPRESENTATION;
        }
        return WHITE_BISHOP_REPRESENTATION;
    }
}
