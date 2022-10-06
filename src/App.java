import java.io.IOException;

import components.*;

public final class App {
    public static String acceptInput = "";
    public static void main(String[] args) {
        Map map = new Map();
        GamePieces gamePiece = new GamePieces();
        InputReader readInput = new InputReader();
        PlayPiece playPiece = new PlayPiece();
        map.printMap(gamePiece.getXMapP1(), gamePiece.getYMapP1(), gamePiece.getXMapP2(), gamePiece.getYMapP2());
        try {
            while(!acceptInput.equals("exit")){
                String moveValidity = "";
                String[] input = readInput.readInput();
                acceptInput = input[0];

                if(readInput.getPlayerTurn() == 1){
                    input[0] = "P1 ".concat(input[0]);
                    moveValidity = playPiece.playGamePiece(input, gamePiece.getXMapP1(), gamePiece.getYMapP1(), gamePiece.getXMapP2(), gamePiece.getYMapP2());
                    if(moveValidity == "Valid Move"){
                        gamePiece.setMapP1(input[0], Integer.parseInt(input[2]), input[1]);
                        gamePiece.removegamePieceP2(input[0]);
                    }
                } else {
                    input[0] = "P2 ".concat(input[0]);
                    moveValidity = playPiece.playGamePiece(input, gamePiece.getXMapP2(), gamePiece.getYMapP2(), gamePiece.getXMapP1(), gamePiece.getYMapP1());
                    if(moveValidity == "Valid Move"){
                        gamePiece.setMapP2(input[0], Integer.parseInt(input[2]), input[1]);
                        gamePiece.removegamePieceP1(input[0]);                  
                    }
                }
                if(moveValidity.equals("Valid Move")){
                    map.printMap(gamePiece.getXMapP1(), gamePiece.getYMapP1(), gamePiece.getXMapP2(), gamePiece.getYMapP2());
                    readInput.setPlayerTurn();
                }
                System.out.println("\n" + moveValidity);
            } 
        } 
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
