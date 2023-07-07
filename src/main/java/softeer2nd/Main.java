package softeer2nd;

import softeer2nd.chess.boards.Board;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Board board = null;
        boolean run = false;
        while(true) {
            String runChess = scan.nextLine();
                if(runChess.equals("start")) {
                    board = new Board();
                    board.initialize();
                    run = true;
                    System.out.println(board.showBoard());
                } else if(runChess.equals("end")) {
                    run = false;
                    scan.close();
                    return;
                }

                if(run && runChess.startsWith("move")) {
                    String[] movePosition = runChess.split(" ");
                    board.move(movePosition[1], movePosition[2]);
                    System.out.println(board.showBoard());
                }
        }
    }
}