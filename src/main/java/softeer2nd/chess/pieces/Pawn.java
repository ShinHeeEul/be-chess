package softeer2nd.chess.pieces;


public class Pawn extends Piece{
    public static final String NAME = "pawn";
    public static final char WHITE_PAWN_REPRESENTATION = 'p';
    public static final char BLACK_PAWN_REPRESENTATION = 'P';
    private Pawn(final String color, String name) {
        this.color = color;
        this.name = name;
    }

    public static Pawn createWhitePawn() {
        return new Pawn(WHITE_COLOR, NAME);
    }

    public static Pawn createBlackPawn() {
        return new Pawn(BLACK_COLOR, NAME);
    }



    @Override
    public char getRepresentation() {
        if(this.getColor().equals(BLACK_COLOR)) {
            return BLACK_PAWN_REPRESENTATION;
        }
        return WHITE_PAWN_REPRESENTATION;
    }
}
