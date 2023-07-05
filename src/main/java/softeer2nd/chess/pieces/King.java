package softeer2nd.chess.pieces;


public class King extends Piece{
    public static final String NAME = "king";
    public static final char WHITE_KING_REPRESENTATION = 'k';
    public static final char BLACK_KING_REPRESENTATION = 'K';
    private King(final String color, String name) {
        this.color = color;
        this.name = name;
    }

    public static King createWhiteKing() {
        return new King(WHITE_COLOR, NAME);
    }

    public static King createBlackKing() {
        return new King(BLACK_COLOR, NAME);
    }


    @Override
    public char getRepresentation() {
        if(this.getColor().equals(BLACK_COLOR)) {
            return BLACK_KING_REPRESENTATION;
        }
        return WHITE_KING_REPRESENTATION;
    }
}
