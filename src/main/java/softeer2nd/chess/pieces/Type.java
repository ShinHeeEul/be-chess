package softeer2nd.chess.pieces;

public enum Type {
    PAWN('p', "pawn"),
    ROOK('r', "rook"),
    KNIGHT('n', "knight"),
    BISHOP('b', "bishop"),
    QUEEN('q', "queen"),
    KING('k', "king"),
    NO_PIECE('.', "empty");
    private final char representation;
    private final String name;
    Type(char representation, String name) {
        this.representation = representation;
        this.name = name;
    }

    public char getWhiteRepresentation() {
        return representation;
    }

    public char getBlackRepresentation() {
        return Character.toUpperCase(representation);
    }

    public char getBlankRepresentation() {
        return representation;
    }

    public String getName() {
        return name;
    }
}
