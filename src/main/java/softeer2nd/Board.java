package softeer2nd;

import softeer2nd.Unit.Pawn;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private final List<Pawn> board;
    public Board() {
        board = new ArrayList<>();
    }
    public void add(final Pawn pawn) {
        board.add(pawn);
    }

    public int size() {
        return board.size();
    }

    public Pawn findPawn(int i) {
        return board.get(i);
    }
}
