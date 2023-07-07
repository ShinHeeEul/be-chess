package softeer2nd.chess.boards.creators;

import softeer2nd.chess.boards.games.BoardRunner;

public interface BoardCreator {

    BoardRunner createBoard();

    void deleteBoard();
}
