package softeer2nd;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.Unit.Pawn;

public class PawnTest {


    @Test
    @DisplayName("Pawn Create Validation")
    void create() {
        String color;
        //흰색 폰
        color = "white";
        Pawn pawn = new Pawn(color);
        verifyPawn(pawn, color);

        //검은 폰
        color = "black";
        pawn = new Pawn(color);
        verifyPawn(pawn, color);
    }

    private static void verifyPawn(final Pawn pawn, final String color) {
        assertThat(pawn.getColor()).isEqualTo(color);
    }


}
