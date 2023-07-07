package softeer2nd;

import softeer2nd.chess.boards.games.BoardGame;
import softeer2nd.chess.boards.games.BoardGameFactory;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {


        BoardGame boardGame = BoardGameFactory.createNormalBoardGame();

        Scanner scan = new Scanner(System.in);

        boolean run = false;
        while(true) {
            String runChess = scan.nextLine();
            if(runChess.equals("start")) {
                run = true;
                boardGame.start();
            } else if(runChess.equals("end")) {
                run = false;
                boardGame.end();
            }
            if(run && runChess.startsWith("move")) {
                boardGame.move(runChess);
            }
        }

    }
}