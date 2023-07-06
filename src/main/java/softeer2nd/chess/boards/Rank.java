package softeer2nd.chess.boards;

import softeer2nd.chess.pieces.Blank;
import softeer2nd.chess.pieces.Piece;

import java.util.ArrayList;

public class Rank {

    ArrayList<Piece> pieceArrayList;

    public Rank() {
        pieceArrayList = new ArrayList<>();
        for(int i = 0; i < BoardSize.ROW_MAX; i++) {
            pieceArrayList.add(Blank.createBlank());
        }
    }

    public ArrayList<Piece> getRow() {
        return pieceArrayList;
    }

    public void setPiece(Piece p, int row) {
        validRow(row);
        pieceArrayList.set(row,p);
    }

    private void validRow(int row) {
        if((row < BoardSize.ROW_MIN) || (row > BoardSize.ROW_MAX)) {
            throw new IndexOutOfBoundsException("경 값이 범위 밖 : row={" + row + "}");
        }
        return;
    }


}
