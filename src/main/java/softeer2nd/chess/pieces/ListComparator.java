package softeer2nd.chess.pieces;

import java.util.Comparator;

public class ListComparator implements Comparator<Piece> {

    @Override
    public int compare(Piece o1, Piece o2) {
        double point1 = o1.getPoint();
        double point2 = o2.getPoint();

        if(point1 > point2) {
            return -1;
        } else if(point1 < point2) {
            return 1;
        }
        return 0;
    }
}
