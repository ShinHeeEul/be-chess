package softeer2nd.chess;

import softeer2nd.chess.pieces.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static softeer2nd.chess.pieces.Bishop.*;
import static softeer2nd.chess.pieces.King.*;
import static softeer2nd.chess.pieces.Knight.*;
import static softeer2nd.chess.pieces.Pawn.*;
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
    public void add(Piece piece) {
        if(piece.getColor().equals(Piece.WHITE_COLOR)) {
            whitePiece.add(piece);
        } else {
            blackPiece.add(piece);
        }
    }

    public int size() {
        return whitePiece.size() + blackPiece.size();
    }

    public void initialize() {
        for(int i = 0; i < BOARD_COL; i++) {
            createPiece(Pawn.NAME, Piece.WHITE_COLOR, (char) (ROW_ALPHABET + i) + "" + 2);
            createPiece(Pawn.NAME, Piece.BLACK_COLOR, (char) (ROW_ALPHABET + i) + "" + 7);
        }
        createPiece(King.NAME, Piece.WHITE_COLOR, "E1");
        createPiece(King.NAME, Piece.BLACK_COLOR, "E8");

        createPiece(Queen.NAME, Piece.WHITE_COLOR, "D1");
        createPiece(Queen.NAME, Piece.BLACK_COLOR, "D8");

        createPiece(Bishop.NAME, Piece.WHITE_COLOR, "C1");
        createPiece(Bishop.NAME, Piece.WHITE_COLOR, "F1");
        createPiece(Bishop.NAME, Piece.BLACK_COLOR, "C8");
        createPiece(Bishop.NAME, Piece.BLACK_COLOR, "F8");

        createPiece(Knight.NAME, Piece.WHITE_COLOR, "B1");
        createPiece(Knight.NAME, Piece.WHITE_COLOR, "G1");
        createPiece(Knight.NAME, Piece.BLACK_COLOR, "B8");
        createPiece(Knight.NAME, Piece.BLACK_COLOR, "G8");

        createPiece(Rook.NAME, Piece.WHITE_COLOR, "A1");
        createPiece(Rook.NAME, Piece.WHITE_COLOR, "H1");
        createPiece(Rook.NAME, Piece.BLACK_COLOR, "A8");
        createPiece(Rook.NAME, Piece.BLACK_COLOR, "H8");

    }

    /**
     * 피스 생성 함수
     * @param name 생성 피스 명
     * @param color 생성 피스 색
     * @param location 생성 피스 위치
     */
    private void createPiece(final String name, String color, String location) {
        List<Piece> pieces = getPieceList(color);
        Piece p = dispatchPiece(name, color);
        if(p == null)
            throw new IllegalArgumentException("피스 생성 안됨");
        p.setLocation(location);
        pieces.add(p);
        setPieceToBoard(p);
    }

    /**
     * 해당 피스에 맞는 참조 클래스 객체를 생성해주는 함수
     * @param name 생성 피스 명
     * @param color 생성 피스 색
     * @return 해당 피스에 맞는 자식 클래스 객체
     */
    private Piece dispatchPiece(final String name, String color) {
        switch(name) {
            case Pawn.NAME:
                if(color.equals(BLACK_COLOR))
                    return createBlackPawn();
                return createWhitePawn();
            case King.NAME:
                if(color.equals(BLACK_COLOR))
                    return createBlackKing();
                return createWhiteKing();
            case Queen.NAME:
                if(color.equals(BLACK_COLOR))
                    return createBlackQueen();
                return createWhiteQueen();
            case Rook.NAME:
                if(color.equals(BLACK_COLOR))
                    return createBlackRook();
                return createWhiteRook();
            case Knight.NAME:
                if(color.equals(BLACK_COLOR))
                    return createBlackKnight();
                return createWhiteKnight();
            case Bishop.NAME:
                    if(color.equals(BLACK_COLOR))
                        return createBlackBishop();
                    return createWhiteBishop();
        }
        return null;
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

    public String getWhitePawnsResult() {
        return getPawns(Piece.WHITE_COLOR);
    }

    public String getBlackPawnsResult() {
        return getPawns(Piece.BLACK_COLOR);
    }

    /**
     * 색에 해당하는 Pawn List의 값들을 String으로 만들어 반환
     * @param color 색
     * @return 색에 해당하는 Pawn String 반환
     */
    private String getPawns(String color) {
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
    private List<Piece> getPieceList(String color) {
        if(color.equals(Piece.BLACK_COLOR)) return blackPiece;
        return whitePiece;
    }


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
        if(!validLocation(location))
            throw new IllegalArgumentException("비정상적인 위치값 : location={"+location+"}");

        row = location.charAt(0) - ROW_ALPHABET;
        col = BOARD_COL - Integer.parseInt(location.charAt(1) + "");

        return new int[] {row, col};
    }

    /**
     * 유효 좌표값인지 검증 함수
     * @param location 기물 위치
     * @return 유효면 true, 아웃이면 false
     */
    private boolean validLocation(String location) {
        if(location.length() != 2) return false;
        int row = location.charAt(0) - ROW_ALPHABET;
        if((row >= BOARD_ROW) || (row < 0)) return false;
        try {
            int col = BOARD_COL - Integer.parseInt(location.charAt(1) + "");
            if((col >= BOARD_COL) || (col < 0)) return false;
        }
        catch(Exception e) {
            return false;
        }
        return true;
    }


    /**
     * 전체 기물 카운트
     * @return 기물 갯수
     */
    public int pieceCount() {
        return blackPiece.size() + whitePiece.size();
    }
}
