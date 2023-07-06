package softeer2nd.chess.boards;

import softeer2nd.chess.pieces.Blank;
import softeer2nd.chess.pieces.Piece;
import softeer2nd.chess.pieces.Type;

import java.util.ArrayList;

public class Rank {

    ArrayList<Piece> pieces;

    public Rank() {
        pieces = new ArrayList<>();
        for(int i = 0; i < BoardSize.ROW_MAX; i++) {
            pieces.add(Piece.createBlank(Type.NO_PIECE));
        }
    }

    public ArrayList<Piece> getRow() {
        return pieces;
    }

    public void setPiece(Piece p, int row) {
        validRow(row);
        pieces.set(row,p);
    }

    public Piece getPiece(int row) {
        validRow(row);
        return pieces.get(row);
    }

    public boolean contains(Piece p) {
        return pieces.contains(p);
    }
    
    public int getPieceRow(Piece p) {
        if(contains(p)) {
            return pieces.indexOf(p);
        }
        return -1;
    }
    

    private void validRow(int row) {
        if((row < BoardSize.ROW_MIN) || (row > BoardSize.ROW_MAX)) {
            throw new IndexOutOfBoundsException("경 값이 범위 밖 : row={" + row + "}");
        }
    }


    public void removePiece(Piece p) {
        if(pieces.contains(p)) {
            pieces.set(pieces.indexOf(p), Blank.createBlank());
        }
    }
}
