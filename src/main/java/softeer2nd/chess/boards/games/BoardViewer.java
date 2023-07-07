package softeer2nd.chess.boards.games;

import softeer2nd.chess.boards.data.Rank;
import softeer2nd.chess.boards.data.Board;
import softeer2nd.chess.pieces.Piece;

import static softeer2nd.chess.boards.BoardSize.COL_MAX;
import static softeer2nd.chess.boards.BoardSize.ROW_MAX;
import static softeer2nd.utils.StringUtils.appendNewLine;

public class BoardViewer {

    private boolean isGuide;

    public BoardViewer(boolean isGuide) {
        this.isGuide = isGuide;
    }
    public String show(Board board) {
        return drawBoard(board, isGuide);
    }

    public static String endBeforeStart() {
        return "먼저 start 호출";
    }

    public static String newGame() {
        return "체스 게임 시작";
    }

    private String drawBoard(Board board, boolean isGuide) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < COL_MAX; i++) {
            String s = "";
            Rank rank = board.getRank(i);
            if(isGuide) {
                s += COL_MAX - i;
                s += "  ";
            }
            for(int j = 0; j < ROW_MAX; j++) {
                Piece p = rank.getPiece(j);
                s += p.getRepresentation();
            }
            sb.append(appendNewLine(s));
        }
        if(isGuide) {
            sb.append(appendNewLine(""));
            sb.append("   abcdefgh");
        }
        return sb.toString();
    }


}
