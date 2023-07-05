package softeer2nd.chess.pieces;

public class Queen extends Piece{
    public static final String NAME = "queen";
    public static final char WHITE_QUEEN_REPRESENTATION = 'q';
    public static final char BLACK_QUEEN_REPRESENTATION = 'Q';
    private Queen(final String color, String name) {
        this.color = color;
        this.name = name;
    }

    public static Queen createWhiteQueen() {
        return new Queen(WHITE_COLOR, NAME);
    }

    public static Queen createBlackQueen() {
        return new Queen(BLACK_COLOR, NAME);
    }

    @Override
    public char getRepresentation() {
        if(this.getColor().equals(BLACK_COLOR)) {
            return BLACK_QUEEN_REPRESENTATION;
        }
        return WHITE_QUEEN_REPRESENTATION;
    }
}
