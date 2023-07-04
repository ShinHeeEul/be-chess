package softeer2nd;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.Unit.Color;
import softeer2nd.Unit.Pawn;

public class PawnTest {


    @Test
    @DisplayName("Pawn Create Validation")
    void create() {
        verifyPawn(Color.WHITE);
        verifyPawn(Color.BLACK);
    }

    private static void verifyPawn(final Color color) {
        Pawn pawn = new Pawn(color);
        assertThat(pawn.getColor()).isEqualTo(color);
    }

    @Test
    @DisplayName("Pawn Default Constructor Validation")
    void create_기본생성자() throws Exception {
        Pawn pawn = new Pawn();
        assertEquals("white", pawn.getColor());
    }


}
