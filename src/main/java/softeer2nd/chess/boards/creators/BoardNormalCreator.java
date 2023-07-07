package softeer2nd.chess.boards.creators;

import softeer2nd.chess.boards.data.Board;
import softeer2nd.chess.boards.games.BoardRunner;
import softeer2nd.chess.boards.data.PieceList;

public class BoardNormalCreator implements BoardCreator {

    private Board board;
    private BoardRunner boardRunner;
    private PieceList pieceList;
    private BoardNormalCreator() {
        board = new Board();
        boardRunner = new BoardRunner();
        pieceList = new PieceList();
    }

    public static BoardNormalCreator createNormalCreator() {
        return new BoardNormalCreator();
    }

    @Override
    public BoardRunner createBoard() {
            board.initialize();
            pieceList.initialize(board);
            boardRunner.start(board, pieceList);
            return boardRunner;
    }

    @Override
    public void deleteBoard() {
        board.initializeEmpty();
        boardRunner.stop();
    }
}
