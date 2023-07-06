package softeer2nd.chess.boards;

import softeer2nd.chess.Position;
import softeer2nd.chess.pieces.*;

import java.util.*;

import static softeer2nd.chess.pieces.Bishop.*;
import static softeer2nd.chess.pieces.Pawn.*;
import static softeer2nd.chess.pieces.Piece.Color.*;
import static softeer2nd.chess.boards.BoardSize.*;
import static softeer2nd.utils.StringUtils.appendNewLine;

public class Board {

    private final List<Piece> blackPiece;
    private final List<Piece> whitePiece;
    private List<Rank> board;


    public Board() {
        blackPiece = new ArrayList<>();
        whitePiece = new ArrayList<>();
        initializeEmpty();
    }


    public void initialize() {
        for(int i = 0; i < COL_MAX; i++) {
            createPiece(createWhitePawn(), (char) (ROW_ALPHABET + i) + "" + 2);
            createPiece(createBlackPawn(), (char) (ROW_ALPHABET + i) + "" + 7);
        }
        createPiece(Piece.createPiece(WHITE, Type.KING), "e1");
        createPiece(Piece.createPiece(BLACK, Type.KING), "e8");

        createPiece(Piece.createPiece(WHITE, Type.QUEEN), "d1");
        createPiece(Piece.createPiece(BLACK, Type.QUEEN), "d8");

        createPiece(Piece.createPiece(WHITE, Type.BISHOP), "c1");
        createPiece(Piece.createPiece(WHITE, Type.BISHOP), "f1");
        createPiece(Piece.createPiece(BLACK, Type.BISHOP), "c8");
        createPiece(Piece.createPiece(BLACK, Type.BISHOP), "f8");

        createPiece(Piece.createPiece(WHITE, Type.KNIGHT), "b1");
        createPiece(Piece.createPiece(WHITE, Type.KNIGHT), "g1");
        createPiece(Piece.createPiece(BLACK, Type.KNIGHT), "b8");
        createPiece(Piece.createPiece(BLACK, Type.KNIGHT), "g8");

        createPiece(Piece.createPiece(WHITE, Type.ROOK), "a1");
        createPiece(Piece.createPiece(WHITE, Type.ROOK), "h1");
        createPiece(Piece.createPiece(BLACK, Type.ROOK), "a8");
        createPiece(Piece.createPiece(BLACK, Type.ROOK), "h8");

    }

    /**
     * 피스 생성 함수
     * @param location 생성 피스 위치
     */
    private void createPiece(Piece piece, String location) {
        List<Piece> pieces = getPieceList(piece.getColor());
        piece.setPosition(new Position(location));
        pieces.add(piece);
        setPieceToBoard(piece);
    }

    /**
     * piece을 보드에 옮김
     * @param p 생성된 피스
     */
    private void setPieceToBoard(Piece p) {
        Position position = p.getPosition();

        int row = position.getRow();
        int col = position.getCol();

        Rank rank = board.get(col);
        rank.setPiece(p, row);
    }



    /**
     * 색에 해당하는 폰 리스트 반환
     * @param color 색
     * @return 색에 해당하는 폰 리스트
     */
    private List<Piece> getPieceList(Color color) {
        if(color.equals(BLACK)) return blackPiece;
        return whitePiece;
    }


    /**
     * 보드를 보여주는 함수
     * @return 보드를 String으로 표현한 값
     */
    public String showBoard() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < COL_MAX; i++) {
            String s = "";
            Rank rank = board.get(i);
            for(int j = 0; j < ROW_MAX; j++) {
                Piece p = rank.getPiece(j);
                s += p.getRepresentation();
            }
            sb.append(appendNewLine(s));
        }
        return sb.toString();
    }


    /**
     * 전체 기물 카운트
     * @return 기물 갯수
     */
    public int pieceCount() {
        return blackPiece.size() + whitePiece.size();
    }

    public int countPieces(Color color, Type type) {
        List<Piece> pieces = getPieceList(color);
        int count = 0;
        for(Piece piece : pieces) {
            if(piece.getType().equals(type)) {
                count++;
            }
        }

        return count;
    }

    public Piece findPiece(String position) {
        Position pos = new Position(position);

        int row = pos.getRow();
        int col = pos.getCol();

        Rank rank = board.get(col);

        return rank.getPiece(row);
    }



    public void initializeEmpty() {
        blackPiece.clear();
        whitePiece.clear();
        board = new ArrayList<>();
        for(int i = 0; i < COL_MAX; i++) {
            board.add(new Rank());
        }
    }

    public double calculatePoint(Color color) {
        List<Piece> pieces = getPieceList(color);

        double totalPoint = 0;
        for(Piece piece : pieces) {
            totalPoint += piece.getPoint();
        }

        return totalPoint - minusFilePawn(color);
    }

    private double minusFilePawn(Color color) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < COL_MAX; i++) {
            Rank rank = board.get(i);
            map = rank.getPawnCol(map, color);
        }
        int tmpPoint = 0;
        for(char key : map.keySet()) {
            int i = map.get(key);
            if(i > 1) {
                tmpPoint += i * Point.FILE_PAWN;
            }
        }

        return tmpPoint;
    }

    public void move(String position, Piece piece) {
        Position movePosition = new Position(position);
        Position piecePosition = piece.getPosition();

        Rank rank;
        if(piecePosition.getCol() != -1) {
            rank = board.get(piecePosition.getCol());
            rank.removePiece(piece);
        } else {
            List<Piece> pieces = getPieceList(piece.getColor());
            pieces.add(piece);
        }

        rank = board.get(movePosition.getCol());
        rank.setPiece(piece, movePosition.getRow());
        piece.setPosition(movePosition);
    }

    public String getSortedList(Color color) {
        List<Piece> pieces = getPieceList(color);
        Collections.sort(pieces, new ListComparator());
        StringBuilder sb = new StringBuilder();

        for(Piece piece : pieces) {
            sb.append(piece.getRepresentation());
        }
        return sb.toString();
    }
}
