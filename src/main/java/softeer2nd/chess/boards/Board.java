package softeer2nd.chess.boards;

import softeer2nd.chess.Position;
import softeer2nd.chess.pieces.*;

import java.util.ArrayList;
import java.util.List;

import static softeer2nd.chess.pieces.Bishop.*;
import static softeer2nd.chess.pieces.King.*;
import static softeer2nd.chess.pieces.Knight.*;
import static softeer2nd.chess.pieces.Pawn.*;
import static softeer2nd.chess.pieces.Piece.Color.*;
import static softeer2nd.chess.pieces.Queen.*;
import static softeer2nd.chess.pieces.Rook.*;
import static softeer2nd.chess.boards.BoardSize.*;
import static softeer2nd.utils.StringUtils.appendNewLine;

public class Board {

    private final List<Piece> blackPiece;
    private final List<Piece> whitePiece;
    private ArrayList<Rank> board;


    public Board() {
        blackPiece = new ArrayList<>();
        whitePiece = new ArrayList<>();
        initializeEmpty();
    }


    public void initialize() {
        for(int i = 0; i < COL_MAX; i++) {
            createPiece(createWhitePawn(), (char) (ROW_ALPHABET + i) + "" + 2);
            createPiece(createBlackPawn(), (char) (ROW_ALPHABET + i) + "" + 7);
        }
        createPiece(createWhiteKing(), "e1");
        createPiece(createBlackKing(), "e8");

        createPiece(createWhiteQueen(), "d1");
        createPiece(createBlackQueen(), "d8");

        createPiece(createWhiteBishop(), "c1");
        createPiece(createWhiteBishop(), "f1");
        createPiece(createBlackBishop(), "c8");
        createPiece(createBlackBishop(), "f8");

        createPiece(createWhiteKnight(), "b1");
        createPiece(createWhiteKnight(), "g1");
        createPiece(createBlackKnight(), "b8");
        createPiece(createBlackKnight(), "g8");

        createPiece(createWhiteRook(), "a1");
        createPiece(createWhiteRook(), "h1");
        createPiece(createBlackRook(), "a8");
        createPiece(createBlackRook(), "h8");

    }

    /**
     * 피스 생성 함수
     * @param location 생성 피스 위치
     */
    private void createPiece(Piece piece, String location) {
        List<Piece> pieces = getPieceList(piece.getColor());
        piece.setLocation(location);
        pieces.add(piece);
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



    /**
     * 색에 해당하는 폰 리스트 반환
     * @param color 색
     * @return 색에 해당하는 폰 리스트
     */
    private List<Piece> getPieceList(Color color) {
        if(color.equals(BLACK)) return blackPiece;
        return whitePiece;
    }


    /**
     * 보드를 보여주는 함수
     * @return 보드를 String으로 표현한 값
     */
    public String showBoard() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < COL_MAX; i++) {
            String s = "";
            Rank rank = board.get(i);
            for(int j = 0; j < ROW_MAX; j++) {
                Piece p = rank.getPiece(j);
                s += p.getRepresentation();
            }
            sb.append(appendNewLine(s));
        }
        return sb.toString();
    }


    /**
     * 전체 기물 카운트
     * @return 기물 갯수
     */
    public int pieceCount() {
        return blackPiece.size() + whitePiece.size();
    }

    public int countPieces(Color color, Type type) {
        List<Piece> pieces = getPieceList(color);
        int count = 0;
        for(Piece piece : pieces) {
            if(piece.getType().equals(type)) {
                count++;
            }
        }

        return count;
    }

    public Piece findPiece(String location) {
        Position position = Position.createPosition(location);

        int row = position.getRow();
        int col = position.getCol();

        Rank rank = board.get(col);

        return rank.getPiece(row);
    }

    public void move(String position, Piece piece) {

        Position pos = Position.createPosition(position);

        int row = pos.getRow();
        int col = pos.getCol();

        for(int i = 0; i < COL_MAX; i++) {
            Rank rank = board.get(i);
            if(rank.contains(piece)) {
                rank.removePiece(piece);
                break;
            }
        }

        Rank rank = board.get(col);
        rank.setPiece(piece, row);


    }

    public void initializeEmpty() {
        board = new ArrayList<>();
        for(int i = 0; i < COL_MAX; i++) {
            board.add(new Rank());
        }
    }
}
