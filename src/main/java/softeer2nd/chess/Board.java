package softeer2nd.chess;

import softeer2nd.chess.pieces.Pawn;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {

    private final List<Pawn> blackPawn;
    private final List<Pawn> whitePawn;
    private final List<Pawn> dead;
    private final char[][] board;

    public Board() {

        blackPawn = new ArrayList<>();
        whitePawn = new ArrayList<>();
        dead = new ArrayList<>();

        board = new char[8][8];
        for(int i = 0; i < 8; i++) {
            Arrays.fill(board[i], '.');
        }
    }
    public void add(Object o) {
        if(o.getClass().equals(Pawn.class)) {
            dead.add((Pawn) o);
            return;
        }
        throw new IllegalArgumentException("말의 타입이 일치하지 않습니다.");

    }

    public int size() {
        return dead.size();
    }

    public void initialize() {
        for(int i = 0; i < 8; i++) {
            whitePawn.add(new Pawn(Pawn.WHITE_COLOR, (char) ('A' + i) + "" + 2));
            blackPawn.add(new Pawn(Pawn.BLACK_COLOR, (char) ('A' + i) + "" + 7));
        }

        for (Pawn p : whitePawn) {
            int[] coordinate = parseLocation(p.getLocation());
            int row = coordinate[0];
            int col = coordinate[1];
            board[col][row] = p.getRepresentation();
        }

        for (Pawn p : blackPawn) {
            int[] coordinate = parseLocation(p.getLocation());
            int row = coordinate[0];
            int col = coordinate[1];
            board[col][row] = p.getRepresentation();
        }
    }

    public String getWhitePawnsResult() {
        StringBuilder sb = new StringBuilder();
        for(Pawn p : whitePawn) {
            sb.append(p.getRepresentation());
        }
        return sb.toString();
    }

    public String getBlackPawnsResult() {
        StringBuilder sb = new StringBuilder();
        for(Pawn p : blackPawn) {
            sb.append(p.getRepresentation());
        }
        return sb.toString();
    }

    public void print() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                bw.write(board[i][j] + "");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }

    private int[] parseLocation(String location) {
        int row;
        int col;
        if(location.length() == 2) {
            row = location.charAt(0) - 'A';
            col = 8 - Integer.parseInt(location.charAt(1) + "");
            return new int[] {row, col};
        }
        return null;
    }

    public Pawn findPawn(int i) {
        return dead.get(i);
    }
}
