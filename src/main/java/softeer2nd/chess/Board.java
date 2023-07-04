package softeer2nd.chess;

import softeer2nd.chess.pieces.Pawn;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {

    private static final int BOARD_ROW = 8;
    private static final int BOARD_COL = 8;
    private final List<Pawn> blackPawn;
    private final List<Pawn> whitePawn;
    private final char[][] board;

    public Board() {

        blackPawn = new ArrayList<>();
        whitePawn = new ArrayList<>();

        board = new char[BOARD_COL][BOARD_ROW];
        for(int i = 0; i < BOARD_COL; i++) {
            Arrays.fill(board[i], Pawn.EMPTY_REPRESENTATION);
        }
    }
    public void add(Pawn pawn) {
        if(pawn.getColor() == Pawn.WHITE_COLOR) {
            whitePawn.add(pawn);
        }
        else {
            blackPawn.add(pawn);
        }
    }

    public int size() {
        return whitePawn.size() + blackPawn.size();
    }

    public void initialize() {
        for(int i = 0; i < BOARD_COL; i++) {
            createPawn(Pawn.WHITE_COLOR, (char) ('A' + i) + "" + 2);
            createPawn(Pawn.BLACK_COLOR, (char) ('A' + i) + "" + 7);
        }
    }

    /**
     * 폰 생성 함수
     */
    private void createPawn(String color, String location) {
        List<Pawn> pawns = getPawnList(color);
        Pawn p = new Pawn(color, location);
        pawns.add(p);
        setPawnToBoard(p);
    }

    /**
     * pawn을 보드에 옮김
     * @param p : 생성된 폰
     */
    private void setPawnToBoard(Pawn p) {
            int[] coordinate = parseLocation(p.getLocation());
            int row = coordinate[0];
            int col = coordinate[1];
            board[col][row] = p.getRepresentation();
    }

    public String getWhitePawnsResult() {
        return getPawns(Pawn.WHITE_COLOR);
    }

    public String getBlackPawnsResult() {
        return getPawns(Pawn.BLACK_COLOR);
    }

    /**
     * 색에 해당하는 Pawn List의 값들을 String으로 만들어 반환
     * @param color 색
     * @return 색에 해당하는 Pawn String 반환
     */
    private String getPawns(String color) {
        StringBuilder sb = new StringBuilder();
        List<Pawn> pawns = getPawnList(color);

        for(Pawn p : pawns) {
            sb.append(p.getRepresentation());
        }
        return sb.toString();
    }

    /**
     * 색에 해당하는 폰 리스트 반환
     * @param color 색
     * @return 색에 해당하는 폰 리스트
     */
    private List<Pawn> getPawnList(String color) {
        if(color.equals(Pawn.BLACK_COLOR)) return blackPawn;
        return whitePawn;
    }


    public String print() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < BOARD_COL; i++) {
            for(int j = 0; j < BOARD_ROW; j++) {
                sb.append(board[i][j]);
            }
            if(i != 7) sb.append("\n");
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
        if(location.length() == 2) {
            row = location.charAt(0) - 'A';
            col = BOARD_COL - Integer.parseInt(location.charAt(1) + "");
            return new int[] {row, col};
        }
        return null;
    }

}
