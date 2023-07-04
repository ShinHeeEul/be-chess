package softeer2nd;

import softeer2nd.chess.pieces.Pawn;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private final List<Pawn> board;
    public Board() {
        board = new ArrayList<>();
    }
    public void add(Object o) {
        if(o.getClass().equals(Pawn.class)) {
            board.add((Pawn) o);
            return;
        }
        throw new IllegalArgumentException("말의 타입이 일치하지 않습니다.");

    }

    public int size() {
        return board.size();
    }

    public Pawn findPawn(int i) {
        return board.get(i);
    }
}
