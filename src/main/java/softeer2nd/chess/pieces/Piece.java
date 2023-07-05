package softeer2nd.chess.pieces;



public abstract class Piece {

    public static final String WHITE_COLOR = "white";
    public static final String BLACK_COLOR = "black";
    public static final char ROW_ALPHABET = 'A';
    protected String color;
    protected String name;
    protected String location = "";


    public String getColor() {
        return this.color;
    }

    public boolean isBlack() {
        return this.color.equals(BLACK_COLOR)?true:false;
    }

    public boolean isWhite() {
        return this.color.equals(WHITE_COLOR)?true:false;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    public String getLocation() {
        return this.location;
    }

    public abstract char getRepresentation();

}
