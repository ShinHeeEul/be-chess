package softeer2nd.Unit;

public class Pawn {

    private final Color color;
    private String[] location;

    public Pawn() {this.color = Color.WHITE;}
    public Pawn(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return this.color;
    }
}
