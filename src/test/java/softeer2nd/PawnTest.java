package softeer2nd;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.Unit.Pawn;

public class PawnTest {


    @Test
    @DisplayName("Pawn Create Validation")
    void create() {
        //흰색 폰
        Pawn pawn = new Pawn("white");
        assertThat(pawn.getColor()).isEqualTo("white");
        //검은 폰
        Pawn pawn2 = new Pawn("black");
        assertThat(pawn2.getColor()).isEqualTo("black");
    }


}
