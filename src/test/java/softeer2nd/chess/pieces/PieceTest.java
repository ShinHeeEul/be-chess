package softeer2nd.chess.pieces;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static softeer2nd.chess.pieces.Bishop.*;
import static softeer2nd.chess.pieces.King.*;
import static softeer2nd.chess.pieces.Knight.*;
import static softeer2nd.chess.pieces.Pawn.*;
import static softeer2nd.chess.pieces.Queen.*;
import static softeer2nd.chess.pieces.Rook.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class PieceTest {

    private static void verifyPiece(final Piece piece, final String color, final char representation) {
        assertEquals(color, piece.getColor());
        assertEquals(representation, piece.getRepresentation());
    }

    @Test
    @DisplayName("Piece Validation")
    void createPiece() {
        verifyPiece(createWhitePawn(), Piece.WHITE_COLOR, WHITE_PAWN_REPRESENTATION);
        verifyPiece(createBlackPawn(), Piece.BLACK_COLOR, BLACK_PAWN_REPRESENTATION);

        verifyPiece(createWhiteKing(), Piece.WHITE_COLOR, WHITE_KING_REPRESENTATION);
        verifyPiece(createBlackKing(), Piece.BLACK_COLOR, BLACK_KING_REPRESENTATION);

        verifyPiece(createWhiteQueen(), Piece.WHITE_COLOR, WHITE_QUEEN_REPRESENTATION);
        verifyPiece(createBlackQueen(), Piece.BLACK_COLOR, BLACK_QUEEN_REPRESENTATION);

        verifyPiece(createWhiteKnight(), Piece.WHITE_COLOR, WHITE_KNIGHT_REPRESENTATION);
        verifyPiece(createBlackKnight(), Piece.BLACK_COLOR, BLACK_KNIGHT_REPRESENTATION);

        verifyPiece(createWhiteRook(), Piece.WHITE_COLOR, WHITE_ROOK_REPRESENTATION);
        verifyPiece(createBlackRook(), Piece.BLACK_COLOR, BLACK_ROOK_REPRESENTATION);


        verifyPiece(createWhiteBishop(), Piece.WHITE_COLOR, WHITE_BISHOP_REPRESENTATION);
        verifyPiece(createBlackBishop(), Piece.BLACK_COLOR, BLACK_BISHOP_REPRESENTATION);
    }

    @Test
    @DisplayName("Color Validation")
    public void validColor() {
        verifyColor(createWhiteBishop());
        verifyColor(createBlackBishop());
    }

    private void verifyColor(Piece piece) {
        if(piece.isBlack()) {
            assertEquals(piece.getColor(), Piece.BLACK_COLOR);
        } else {
            assertEquals(piece.getColor(), Piece.WHITE_COLOR);
        }
    }

}
