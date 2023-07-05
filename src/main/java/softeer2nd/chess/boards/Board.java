package softeer2nd.chess.boards;

import softeer2nd.chess.pieces.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static softeer2nd.chess.pieces.Bishop.*;
import static softeer2nd.chess.pieces.King.*;
import static softeer2nd.chess.pieces.Knight.*;
import static softeer2nd.chess.pieces.Pawn.*;
import static softeer2nd.chess.pieces.Piece.Color.*;
import static softeer2nd.chess.pieces.Queen.*;
import static softeer2nd.chess.pieces.Rook.*;
import static softeer2nd.utils.StringUtils.appendNewLine;

public class Board {

    private static final int BOARD_ROW = 8;
    private static final int BOARD_COL = 8;
    public static final char EMPTY = '.';

    private final List<Piece> blackPiece;
    private final List<Piece> whitePiece;
    private final char[][] board;


    public Board() {
        blackPiece = new ArrayList<>();
        whitePiece = new ArrayList<>();

        board = new char[BOARD_COL][BOARD_ROW];
        for(int i = 0; i < BOARD_COL; i++) {
            Arrays.fill(board[i], EMPTY);
        }
    }


    public void initialize() {
        for(int i = 0; i < BOARD_COL; i++) {
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
            int[] coordinate = parseLocation(p.getLocation());
            int row = coordinate[0];
            int col = coordinate[1];
            board[col][row] = p.getRepresentation();
    }

    /**
     * 색에 해당하는 Pieces List의 값들을 String으로 만들어 반환
     * @param color 색
     * @return 색에 해당하는 Pieces String 반환
     */
    private String getPieces(Color color) {
        StringBuilder sb = new StringBuilder();
        List<Piece> pieces = getPieceList(color);

        for(Piece p : pieces) {
            sb.append(p.getRepresentation());
        }
        return sb.toString();
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
        for(int i = 0; i < BOARD_COL; i++) {
            String s = "";
            for(int j = 0; j < BOARD_ROW; j++) {
                s += board[i][j];
            }
            sb.append(appendNewLine(s));
        }
        return sb.toString();
    }

    /**
     * 저장된 위치정보를 실질적인 위치로 변환
     * @param location Pawn에 저장된 위치정보
     * @return {행, 열} 반환
     */

    private int[] parseLocation(String location) {
        int row;
        int col;
        validLocation(location);

        row = location.charAt(0) - ROW_ALPHABET;
        col = BOARD_COL - Integer.parseInt(location.charAt(1) + "");

        return new int[] {row, col};
    }

    /**
     * 유효 좌표값인지 검증 함수
     * @param location 기물 위치
     */
    private void validLocation(String location) {
        if(location.length() != 2) {
            throw new IllegalArgumentException("비정상적인 위치값 : location이 두글자가 아님");
        }
        int row = location.charAt(0) - ROW_ALPHABET;
        if((row >= BOARD_ROW) || (row < 0)) {
            throw new IllegalArgumentException("비정상적인 위치값 : location의 row 이상 row={"+row+"}");
        }
        int col = BOARD_COL - (location.charAt(1) - COL_ALPHABET);
        if((col >= BOARD_COL) || (col < 0)) {
            throw new IllegalArgumentException("비정상적인 위치값 : location의 col 이상 col={"+col+"}");
        }
    }


    /**
     * 전체 기물 카운트
     * @return 기물 갯수
     */
    public int pieceCount() {

        return blackPiece.size() + whitePiece.size();
    }
}
