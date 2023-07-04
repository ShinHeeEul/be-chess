package softeer2nd.Unit;

public enum Color {
    WHITE("white"), BLACK("black");
    final private String color;

    Color(String color) {
        this.color = color;
    }

    String getColor() {
        return color;
    }

}
