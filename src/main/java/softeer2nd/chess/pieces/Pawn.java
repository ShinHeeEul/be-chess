package softeer2nd.chess.pieces;

public class Pawn {

    public static final String WHITE_COLOR = "white";
    public static final String BLACK_COLOR = "black";

    public static final char WHITE_REPRESENTATION = 'p';
    public static final char BLACK_REPRESENTATION = 'P';
    public static final char EMPTY_REPRESENTATION = '.';

    private final String color;
    private String location;

    public Pawn() {
        this.color = WHITE_COLOR;
    }
    public Pawn(String color) {
        this.color = color;
    }

    public Pawn(String color, String location) {
        this.color = color;
        this.location = location;
    }

    public String getColor() {
        return this.color;
    }

    public String getLocation() {
        return this.location;
    }

    public char getRepresentation() {
        if(this.color == WHITE_COLOR) {
            return WHITE_REPRESENTATION;
        }
        return BLACK_REPRESENTATION;
    }
}
