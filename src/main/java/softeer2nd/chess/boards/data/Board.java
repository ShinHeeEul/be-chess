package softeer2nd.chess.boards.data;

import softeer2nd.chess.Position;
import softeer2nd.chess.pieces.*;

import java.util.*;

import static softeer2nd.chess.pieces.Bishop.*;
import static softeer2nd.chess.pieces.Pawn.*;
import static softeer2nd.chess.pieces.Piece.Color.*;
import static softeer2nd.chess.boards.BoardSize.*;

public class Board {

    private List<Rank> board;


    public Board() {
        board = new ArrayList<>();
    }


    public void initialize() {
        for(int i = 0; i < COL_MAX; i++) {
            createPiece(createWhitePawn(), (char) (ROW_ALPHABET + i) + "" + 2);
            createPiece(createBlackPawn(), (char) (ROW_ALPHABET + i) + "" + 7);
        }
        createPiece(Piece.createPiece(WHITE, Type.KING), "e1");
        createPiece(Piece.createPiece(BLACK, Type.KING), "e8");

        createPiece(Piece.createPiece(WHITE, Type.QUEEN), "d1");
        createPiece(Piece.createPiece(BLACK, Type.QUEEN), "d8");

        createPiece(Piece.createPiece(WHITE, Type.BISHOP), "c1");
        createPiece(Piece.createPiece(WHITE, Type.BISHOP), "f1");
        createPiece(Piece.createPiece(BLACK, Type.BISHOP), "c8");
        createPiece(Piece.createPiece(BLACK, Type.BISHOP), "f8");

        createPiece(Piece.createPiece(WHITE, Type.KNIGHT), "b1");
        createPiece(Piece.createPiece(WHITE, Type.KNIGHT), "g1");
        createPiece(Piece.createPiece(BLACK, Type.KNIGHT), "b8");
        createPiece(Piece.createPiece(BLACK, Type.KNIGHT), "g8");

        createPiece(Piece.createPiece(WHITE, Type.ROOK), "a1");
        createPiece(Piece.createPiece(WHITE, Type.ROOK), "h1");
        createPiece(Piece.createPiece(BLACK, Type.ROOK), "a8");
        createPiece(Piece.createPiece(BLACK, Type.ROOK), "h8");

    }

    /**
     * 피스 생성 함수
     * @param location 생성 피스 위치
     */
    private void createPiece(Piece piece, String location) {
        piece.setPosition(new Position(location));
        setPieceToBoard(piece);
    }

    /**
     * piece을 보드에 옮김
     * @param p 생성된 피스
     */
    private void setPieceToBoard(Piece p) {
        Position position = p.getPosition();

        int row = position.getRow();
        int col = position.getCol();

        Rank rank = board.get(col);
        rank.setPiece(p, row);
    }


    public Piece findPiece(String position) {
        Position pos = new Position(position);

        int row = pos.getRow();
        int col = pos.getCol();

        Rank rank = board.get(col);

        return rank.getPiece(row);
    }

    public void initializeEmpty() {
        board = new ArrayList<>();
        for(int i = 0; i < COL_MAX; i++) {
            board.add(new Rank());
        }
    }



    public double minusFilePawn(Color color) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < COL_MAX; i++) {
            Rank rank = board.get(i);
            map = rank.getPawnCol(map, color);
        }
        int tmpPoint = 0;
        for(char key : map.keySet()) {
            int i = map.get(key);
            if(i > 1) {
                tmpPoint += i * Point.FILE_PAWN;
            }
        }

        return tmpPoint;
    }

    public void addPiece(String position, Piece piece) {
        createPiece(piece, position);
    }

    public Rank getRank(int i) {
        return board.get(i);
    }
}
