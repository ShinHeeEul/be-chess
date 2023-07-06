package softeer2nd.chess.pieces;

import static softeer2nd.chess.pieces.Piece.Color.*;

public abstract class Piece {

    public enum Color {
        WHITE, BLACK, EMPTY
    }


    public static final char ROW_ALPHABET = 'a';
    public static final char COL_ALPHABET = '0';
    protected Color color;
    protected String location;
    protected Type type;


    protected Piece() {
        location = "a1";
    }
    public Color getColor() {
        return this.color;
    }

    public boolean isBlack() {
        return this.color.equals(BLACK);
    }

    public boolean isWhite() {
        return this.color.equals(WHITE);
    }

    public boolean isEmpty() {
        return this.color.equals(EMPTY);
    }

    public Type getType() {
        return this.type;
    }

    public void setLocation(String location) {

        this.location = location;
    }
    public String getLocation() {

        return this.location;
    }

    public char getRepresentation() {
        if(this.color.equals(BLACK)) {
            return type.getBlackRepresentation();
        }
        return type.getWhiteRepresentation();
    }

    @Override
    public boolean equals(Object obj) {
        Piece piece = (Piece) obj;
        if(piece.getType() == this.getType()) {
            return true;
        }

        return false;
    }
}
