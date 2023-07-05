package softeer2nd.chess.pieces;


public class Knight extends Piece{
    public static final String NAME = "knight";
    public static final char WHITE_KNIGHT_REPRESENTATION = 'k';
    public static final char BLACK_KNIGHT_REPRESENTATION = 'K';
    private Knight(final String color, String name) {
        this.color = color;
        this.name = name;
    }

    public static Knight createWhiteKnight() {
        return new Knight(WHITE_COLOR, NAME);
    }

    public static Knight createBlackKnight() {
        return new Knight(BLACK_COLOR, NAME);
    }


    @Override
    public char getRepresentation() {
        if(this.getColor().equals(BLACK_COLOR)) {
            return BLACK_KNIGHT_REPRESENTATION;
        }
        return WHITE_KNIGHT_REPRESENTATION;
    }
}
