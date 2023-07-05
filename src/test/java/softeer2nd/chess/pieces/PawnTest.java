package softeer2nd.chess.pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static softeer2nd.chess.pieces.Pawn.*;
import static softeer2nd.chess.pieces.Piece.Color.*;

public class PawnTest {

    @Test
    @DisplayName("Create Pawn Validation")
    public void create_pawn() {
        verifyPawn(createWhitePawn(), WHITE, Type.PAWN);
        verifyPawn(createBlackPawn(), BLACK, Type.PAWN);
    }

    private void verifyPawn(Pawn pawn, Color color, Type type) {
        assertEquals(pawn.getColor(), color);
        assertEquals(pawn.getType(), type);
    }


}
