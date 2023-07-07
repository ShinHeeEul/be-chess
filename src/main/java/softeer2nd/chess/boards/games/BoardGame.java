package softeer2nd.chess.boards.games;

import softeer2nd.chess.boards.creators.BoardCreator;

public class BoardGame {

    BoardCreator boardCreator;
    BoardRunner boardRunner;

    public BoardGame(BoardCreator boardCreator) {
        this.boardCreator = boardCreator;
        this.boardRunner = null;
    }

    public void start() {
        System.out.println(BoardViewer.newGame());
        boardRunner = boardCreator.createBoard();
    }

    public void end() {
        if(!processingChess()) {
            return;
        }
        boardRunner = null;
        boardCreator.deleteBoard();
    }

    public void move(String runChess) {
        if(!processingChess()) {
            return;
        }
        String[] movePosition = runChess.split(" ");
        boardRunner.move(movePosition[1], movePosition[2]);
    }

    public boolean processingChess() {
        if(boardRunner == null) {
            System.out.println(BoardViewer.endBeforeStart());
            return false;
        }
        return true;
    }
}
