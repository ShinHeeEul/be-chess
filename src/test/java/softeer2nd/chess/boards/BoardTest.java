package softeer2nd.chess.boards;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.pieces.Piece;
import softeer2nd.chess.pieces.Rook;
import softeer2nd.chess.pieces.Type;

import static org.junit.jupiter.api.Assertions.*;
import static softeer2nd.utils.StringUtils.appendNewLine;


public class BoardTest {

    Board board;
    @BeforeEach
    public void before() {
        board = new Board();
        board.initialize();
    }

    @Test
    @DisplayName("Board Create Validation")
    public void create() {
        assertEquals(32, board.pieceCount());
        String blankRank = appendNewLine("........");
        assertEquals(
                appendNewLine("RNBQKBNR") +
                        appendNewLine("PPPPPPPP") +
                        blankRank + blankRank + blankRank + blankRank +
                        appendNewLine("pppppppp") +
                        appendNewLine("rnbqkbnr"),
                board.showBoard());
    }


    @Test
    @DisplayName("기물과 색에 해당하는 기물의 개수를 반환")
    public void return_piece() {
        Piece.Color color = Piece.Color.WHITE;
        Type type = Type.PAWN;
        assertEquals(8, board.countPieces(color, type));

        type = Type.KING;
        assertEquals(1, board.countPieces(color, type));
    }

    @Test
    public void findPiece() {

        assertEquals(Rook.createBlackRook(), board.findPiece("a8"));
        assertEquals(Rook.createBlackRook(), board.findPiece("h8"));
        assertEquals(Rook.createWhiteRook(), board.findPiece("a1"));
        assertEquals(Rook.createWhiteRook(), board.findPiece("h1"));
    }

    @Test
    @DisplayName("위치가 변경이 되는지")
    public void move() throws Exception {
        board.initializeEmpty();

        String position = "b5";
        Piece piece = Rook.createBlackRook();

        board.move(position, piece);

        assertEquals(piece, board.findPiece(position));
        System.out.println(board.showBoard());
    }

}
