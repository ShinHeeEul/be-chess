package softeer2nd.chess.boards.games;

import softeer2nd.chess.boards.data.Board;
import softeer2nd.chess.boards.data.PieceList;
import softeer2nd.chess.pieces.Piece;

public class BoardRunner {

    BoardViewer boardViewer;
    Board board;
    PieceList pieceList;
    static final boolean NORMAL = false;
    static final boolean GUIDE = true;

    public BoardRunner() {
        boardViewer = null;
        board = null;
        pieceList = null;
    }
    public void start(Board board, PieceList pieceList) {
        this.board = board;
        boardViewer = new BoardViewer(NORMAL);
        boardViewer.show(board);
        this.pieceList = pieceList;

    }

    public void move(String sourcePosition, String targetPosition) {
        Piece sourcePiece = board.findPiece(sourcePosition);
        Piece targetPiece = board.findPiece(targetPosition);

        board.addPiece(targetPosition, sourcePiece);
        board.addPiece(sourcePosition, targetPiece);

        boardViewer.show(board);
    }


    public void stop() {
        boardViewer = null;
    }
}
