package softeer2nd.chess.pieces;

import static org.junit.jupiter.api.Assertions.*;
import static softeer2nd.chess.pieces.Bishop.*;
import static softeer2nd.chess.pieces.King.*;
import static softeer2nd.chess.pieces.Knight.*;
import static softeer2nd.chess.pieces.Pawn.*;
import static softeer2nd.chess.pieces.Queen.*;
import static softeer2nd.chess.pieces.Rook.*;
import static softeer2nd.chess.pieces.Piece.Color.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class PieceTest {

    @Test
    @DisplayName("Valid Create Piece")
    public void create_piece() {
        verifyPiece(createWhitePawn(), createBlackPawn(), Type.PAWN);
        verifyPiece(createWhiteKnight(), createBlackKnight(), Type.KNIGHT);
        verifyPiece(createWhiteRook(), createBlackRook(), Type.ROOK);
        verifyPiece(createWhiteBishop(), createBlackBishop(), Type.BISHOP);
        verifyPiece(createWhiteQueen(), createBlackQueen(), Type.QUEEN);
        verifyPiece(createWhiteKing(), createBlackKing(), Type.KING);

        Piece blank = Blank.createBlank();
        assertFalse(blank.isWhite());
        assertFalse(blank.isBlack());
        assertEquals(Type.NO_PIECE, blank.getType());
    }

    private void verifyPiece(final Piece whitePiece, final Piece blackPiece, final Type type) {
        assertTrue(whitePiece.isWhite());
        assertEquals(type, whitePiece.getType());

        assertTrue(blackPiece.isBlack());
        assertEquals(type, blackPiece.getType());
    }

    @Test
    @DisplayName("Color Validation")
    public void valid_color() {
        verifyColor(createWhiteBishop());
        verifyColor(createBlackBishop());
    }

    private void verifyColor(Piece piece) {
        if(piece.isBlack()) {
            assertEquals(piece.getColor(), BLACK);
        } else {
            assertEquals(piece.getColor(), WHITE);
        }
    }

    @Test
    @DisplayName("Valid Representation")
    public void get_representation_piece() throws Exception {
        assertEquals('p', Type.PAWN.getWhiteRepresentation());
        assertEquals('P', Type.PAWN.getBlackRepresentation());
    }

}
