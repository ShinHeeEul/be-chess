package softeer2nd.chess.boards.creators;

import softeer2nd.chess.boards.data.Board;
import softeer2nd.chess.boards.games.BoardRunner;
import softeer2nd.chess.boards.data.PieceList;

public class BoardEmptyCreator implements BoardCreator{

    private Board board;
    private BoardRunner boardRunner;
    private PieceList pieceList;
    private BoardEmptyCreator() {
        board = new Board();
        boardRunner = new BoardRunner();
        pieceList = new PieceList();
    }

    public static BoardEmptyCreator createEmptyCreator() {
        return new BoardEmptyCreator();
    }
    @Override
    public BoardRunner createBoard() {
        board.initializeEmpty();

        boardRunner.start(new Board(), new PieceList());

        return boardRunner;
    }

    @Override
    public void deleteBoard() {
        board.initializeEmpty();
    }
}
