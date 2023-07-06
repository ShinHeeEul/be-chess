package softeer2nd.chess;

import static softeer2nd.chess.boards.BoardSize.*;
import static softeer2nd.chess.pieces.Piece.COL_ALPHABET;
import static softeer2nd.chess.pieces.Piece.ROW_ALPHABET;

public class Position {

    private final int row;
    private final int col;
    private String square;

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
        this.square = toSquare(row, col);
        validLocation();
    }


    public Position(String square) {
        int[] coordinate = toCoordinate(square);
        this.row = coordinate[0];
        this.col = coordinate[1];
        this.square = square;
        validLocation();
    }

    /**
     * 저장된 위치정보를 실질적인 위치로 변환
     * @param location Pawn에 저장된 위치정보
     * @return {행, 열} 반환
     */

    private int[] toCoordinate(String location) {
        int row = location.charAt(0) - ROW_ALPHABET;
        int col = COL_MAX - (location.charAt(1) - COL_ALPHABET);

        return new int[] {row, col};
    }


    private String toSquare(int row, int col) {
        String square = "";

        square += (char) (row + ROW_ALPHABET);
        square += (char) (COL_MAX - (col - COL_ALPHABET));

        return square;
    }

    private void validLocation() {
        if(square.length() != 2) {
            throw new IllegalArgumentException("비정상적인 위치값 : location이 두글자가 아님 location={"+square+"}");
        }
        char alphabet = square.charAt(0);
        char number = square.charAt(1);

        if((alphabet <= 'Z') && (alphabet >= 'A')) {
            alphabet = (char) (alphabet - 'A' + ROW_ALPHABET);
            square += alphabet;
            square += number;
        }

        if((row >= ROW_MAX) || (row < ROW_MIN)) {
            throw new IllegalArgumentException("비정상적인 위치값 : location의 row 이상 row={"+row+"}");
        }
        if((col >= COL_MAX) || (col < COL_MIN)) {
            throw new IllegalArgumentException("비정상적인 위치값 : location의 col 이상 col={"+col+"}");
        }
    }


    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public String getSquare() {
        return square;
    }


}
