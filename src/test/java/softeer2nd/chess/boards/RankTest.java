package softeer2nd.chess.boards;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.pieces.Pawn;
import softeer2nd.chess.pieces.Piece;

import java.util.ArrayList;


class RankTest {
    Rank rank;
    Piece p;
    final int ROW = 3;
    final int LOW_ROW = -3;
    final int HIGH_ROW = 13;
    @BeforeEach
    public void set_before() {
        rank = new Rank();
        p = Pawn.createBlackPawn();
    }
    @Test
    @DisplayName("ArrayList에 값이 제대로 들어가는지?")
    public void set_array() {
        ArrayList<Piece> arr = addPiece(p, ROW);
        Assertions.assertEquals(p, arr.get(ROW));
    }

    private ArrayList<Piece> addPiece(Piece p, final int row) {
        rank.setPiece(p, row);
        return rank.getRow();
    }

    @Test
    @DisplayName("ArrayList에 값이 들어갈 때 총 길이가 8로 유지 되는지?")
    public void const_eight() {
        ArrayList<Piece> arr = addPiece(p, ROW);
        Assertions.assertEquals(8, arr.size());
    }

    @Test
    @DisplayName("Valid가 정상작동하는지?")
    public void valid_check() {
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> addPiece(p, LOW_ROW));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> addPiece(p, HIGH_ROW));
    }


    @Test
    @DisplayName("값이 가져와 지는지?")
    public void get_piece() {
        addPiece(p, ROW);
        Assertions.assertEquals(p, rank.getPiece(ROW));
    }

    @Test
    @DisplayName("Type을 기준으로 Piece의 좌표를 반환해주는지?")
    public void get_piece_location() {
        addPiece(p, ROW);
        Assertions.assertEquals(ROW, rank.getPieceIndex(p));
    }




}