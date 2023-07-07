package softeer2nd.chess.boards;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.Position;
import softeer2nd.chess.pieces.*;

import static softeer2nd.chess.pieces.Piece.*;
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
        Color color = Color.WHITE;
        Type type = Type.PAWN;
        assertEquals(8, board.countPieces(color, type));

        type = Type.KING;
        assertEquals(1, board.countPieces(color, type));
    }

    @Test
    public void findPiece() {

        assertEquals(Piece.createPiece(Color.BLACK, Type.ROOK), board.findPiece("a8"));
        assertEquals(Piece.createPiece(Color.BLACK, Type.ROOK), board.findPiece("h8"));
        assertEquals(Piece.createPiece(Color.WHITE, Type.ROOK), board.findPiece("a1"));
        assertEquals(Piece.createPiece(Color.WHITE, Type.ROOK), board.findPiece("h1"));
    }

    @Test
    @DisplayName("이동이 제대로 되는지 살펴본다.")
    public void move() {
        board.initialize();

        String sourcePosition = "b2";
        String targetPosition = "b3";
        board.move(sourcePosition, targetPosition);
        Piece sourcePiece = Piece.createPiece(Color.EMPTY, Type.NO_PIECE);
        Piece tagetPiece = Piece.createPiece(Color.BLACK, Type.PAWN);
        sourcePiece.setPosition(new Position(sourcePosition));
        tagetPiece.setPosition(new Position(targetPosition));
        assertEquals(sourcePiece, board.findPiece(sourcePosition));
        assertEquals(tagetPiece, board.findPiece(targetPosition));
    }

    @Test
    @DisplayName("포인트 계산")
    public void cal_point() {
        board.initializeEmpty();

        addPiece("b6", Pawn.createBlackPawn());
        addPiece("e6", Queen.createBlackQueen());
        addPiece("b8", King.createBlackKing());
        addPiece("c8", Rook.createBlackRook());

        addPiece("f2", Pawn.createWhitePawn());
        addPiece("g2", Pawn.createWhitePawn());
        addPiece("e1", Rook.createWhiteRook());
        addPiece("f1", King.createWhiteKing());
        addPiece("f4",Pawn.createWhitePawn());

        System.out.println(board.showBoard());
        assertEquals(15.0, board.calculatePoint(Color.BLACK), 0.01);
        assertEquals(7.0, board.calculatePoint(Color.WHITE), 0.01);

        System.out.println(board.showBoard());
    }

    private void addPiece(String position, Piece piece) {
        board.addPiece(position, piece);
    }

    @Test
    @DisplayName("정렬이 되었는지 살펴본다")
    public void list_sort() {
        assertEquals(32, board.pieceCount());
        String blackSort = "QRRBBNNPPPPPPPPK";
        String whiteSort = "qrrbbnnppppppppk";
        assertEquals(blackSort, board.getSortedList(Color.BLACK));
        assertEquals(whiteSort, board.getSortedList(Color.WHITE));
    }



    @AfterEach
    public void end() {
        board.initializeEmpty();
    }



}
