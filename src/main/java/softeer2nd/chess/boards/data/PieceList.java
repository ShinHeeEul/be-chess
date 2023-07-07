package softeer2nd.chess.boards.data;

import softeer2nd.chess.pieces.ListComparator;
import softeer2nd.chess.pieces.Piece;
import softeer2nd.chess.pieces.Type;

import java.util.ArrayList;
import java.util.List;

import static softeer2nd.chess.boards.BoardSize.COL_MAX;
import static softeer2nd.chess.boards.BoardSize.ROW_MAX;
import static softeer2nd.chess.pieces.Piece.Color.BLACK;

public class PieceList {

    private final List<Piece> blackPiece;
    private final List<Piece> whitePiece;


    public PieceList() {
        this.blackPiece = new ArrayList<>();
        this.whitePiece = new ArrayList<>();
    }

    /**
     * 색에 해당하는 폰 리스트 반환
     * @param color 색
     * @return 색에 해당하는 폰 리스트
     */
    private List<Piece> getPieceList(Piece.Color color) {
        if(color.equals(BLACK)) return blackPiece;
        return whitePiece;
    }

    public void initialize(Board board) {
        for(int i = 0; i < COL_MAX; i++) {
            Rank r = board.getRank(i);
            for(int j = 0; j < ROW_MAX; j++) {
                Piece piece = r.getPiece(j);
                if(!piece.equals(Piece.createBlank(Type.NO_PIECE))) {
                    createPiece(piece);
                }
            }
        }
    }

    public void createPiece(Piece p) {
        List<Piece> pieces = getPieceList(p.getColor());

        pieces.add(p);
    }

    /**
     * 전체 기물 카운트
     * @return 기물 갯수
     */
    public int pieceCount() {
        return blackPiece.size() + whitePiece.size();
    }

    public int countPieces(Piece.Color color, Type type) {
        List<Piece> pieces = getPieceList(color);
        int count = 0;
        for(Piece piece : pieces) {
            if(piece.getType().equals(type)) {
                count++;
            }
        }

        return count;
    }

    public double calculatePoint(Piece.Color color, Board board) {
        List<Piece> pieces = getPieceList(color);

        double totalPoint = 0;
        for(Piece piece : pieces) {
            totalPoint += piece.getPoint();
        }

        return totalPoint - board.minusFilePawn(color);
    }

    public String getSortedList(Piece.Color color) {
        List<Piece> pieces = getPieceList(color);
        pieces.sort(new ListComparator());
        StringBuilder sb = new StringBuilder();

        for(Piece piece : pieces) {
            sb.append(piece.getRepresentation());
        }
        return sb.toString();
    }


}
