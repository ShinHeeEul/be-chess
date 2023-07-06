package softeer2nd.chess.pieces;

import softeer2nd.chess.Position;

import static softeer2nd.chess.pieces.Piece.Color.*;

public abstract class Piece {

    public enum Color {
        WHITE, BLACK, EMPTY
    }


    public static final char ROW_ALPHABET = 'a';
    public static final char COL_ALPHABET = '0';
    private Color color;
    private Position position;
    private Type type;
    private final double point;


    protected Piece() {
        this.position = new Position();
        point = Point.BLANK;
    }

    protected Piece(Color color, Type type, double point) {
        this.color = color;
        this.position = new Position();
        this.type = type;
        this.point = point;
    }

    public static Piece createBlank(Type type) {
        if(type.equals(Type.NO_PIECE)) {
            return Blank.createBlank();
        }
         throw new IllegalArgumentException("허용되지 않은 타입 type={"+type.getName()+"}");
    }

    public static Piece createPiece(Color color, Type type) {
        switch(type) {
            case PAWN -> {
                return color.equals(BLACK)?Pawn.createBlackPawn():Pawn.createWhitePawn();
            }
            case KNIGHT -> {
                return color.equals(BLACK)?Knight.createBlackKnight():Knight.createWhiteKnight();
            }
            case QUEEN -> {
                return color.equals(BLACK)?Queen.createBlackQueen():Queen.createWhiteQueen();
            }
            case ROOK -> {
                return color.equals(BLACK)?Rook.createBlackRook():Rook.createWhiteRook();
            }
            case BISHOP -> {
                return color.equals(BLACK)?Bishop.createBlackBishop():Bishop.createWhiteBishop();
            }
            case KING -> {
                return color.equals(BLACK)?King.createBlackKing():King.createWhiteKing();
            }
            default -> throw new IllegalArgumentException("허용되지 않은 타입 type={"+type.getName()+"}");

        }
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

    public void setPosition(Position position) {
        this.position = position;
    }
    public Position getPosition() {
        return this.position;
    }

    public char getRepresentation() {
        if(this.color.equals(BLACK)) {
            return type.getBlackRepresentation();
        } else if(this.color.equals(EMPTY)) {
            return type.getBlankRepresentation();
        }
        return type.getWhiteRepresentation();
    }


    public double getPoint() {
        return point;
    }

    @Override
    public boolean equals(Object obj) {
        if(this.getClass() != obj.getClass()) {
            return false;
        }
        Piece piece = (Piece) obj;
        return piece.getType() == this.getType();
    }
}
