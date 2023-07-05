package softeer2nd.chess.pieces;



public abstract class Piece {

    public static final String WHITE_COLOR = "white";
    public static final String BLACK_COLOR = "black";
    public static final char ROW_ALPHABET = 'A';
    protected String color;
    // 기물 종류
    protected String name;
    protected String location = "";


    public String getColor() {
        return this.color;
    }


    public void setLocation(String location) {
        this.location = location;
    }
    public String getLocation() {
        return this.location;
    }

    public abstract char getRepresentation();

}
