package softeer2nd;

import softeer2nd.chess.Board;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(true) {
            String runChess = scan.nextLine();
            switch (runChess) {
                case "start":
                    Board board = new Board();
                    board.initialize();
                    System.out.println(board.print());
                    break;
                case "end":
                    scan.close();
                    return;
            }
        }

    }
}