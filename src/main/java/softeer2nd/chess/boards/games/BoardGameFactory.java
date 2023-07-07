package softeer2nd.chess.boards.games;

import static softeer2nd.chess.boards.creators.BoardEmptyCreator.createEmptyCreator;
import static softeer2nd.chess.boards.creators.BoardNormalCreator.createNormalCreator;

public class BoardGameFactory {

    public static BoardGame createNormalBoardGame() {
        BoardGame boardGame = new BoardGame(createNormalCreator());
        return boardGame;
    }

    public static BoardGame createEmptyBoardGame() {
        BoardGame boardGame = new BoardGame(createEmptyCreator());
        return boardGame;
    }
}
