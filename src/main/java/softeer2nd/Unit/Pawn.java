package softeer2nd.Unit;

public class Pawn {

    public static final String WHITE_COLOR = "white";
    public static final String BLACK_COLOR = "BLACK";

    private final String color;
    private String[] location;

    public Pawn() {this.color = WHITE_COLOR;}
    public Pawn(String color) {
        this.color = color;
    }

    public String getColor() {
        return this.color;
    }
}
