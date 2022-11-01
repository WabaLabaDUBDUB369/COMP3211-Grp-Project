import java.io.IOException;

import components.*;

public final class App {
    public static void main(String[] args) {
        Map map = new Map();
        GamePieces gamePiece = new GamePieces();
        InputReader readInput = new InputReader();
        PlayPiece playPiece = new PlayPiece();
        String moveValidity = "";
        String opponentPiece = "";
        String[] prevMove = {};
        String[] input = {"", "", ""};
        map.printMap(gamePiece.getXMap("P1"), gamePiece.getYMap("P1"), gamePiece.getXMap("P2"), gamePiece.getYMap("P2"));
        try {
            while(!input[0].equals("exit")){
                input = readInput.readInput();
                moveValidity = playPiece.playGamePiece(input, gamePiece.getXMap(readInput.getCurrentPlayerTurn()), gamePiece.getYMap(readInput.getCurrentPlayerTurn()), gamePiece.getXMap(readInput.getOpponentPlayerTurn()), gamePiece.getYMap(readInput.getOpponentPlayerTurn()));
                opponentPiece = playPiece.checkIfPiecePresent(Integer.parseInt(input[2]), input[1], gamePiece.getXMap(readInput.getOpponentPlayerTurn()), gamePiece.getYMap(readInput.getOpponentPlayerTurn()));

                if(moveValidity.equals("Valid Move")){
                    gamePiece.setMap(readInput.getCurrentPlayerTurn(), input[0], Integer.parseInt(input[2]), input[1]);
                    prevMove = input.clone(); 
                    if(opponentPiece != ""){
                        gamePiece.removeGamePiece(readInput.getOpponentPlayerTurn(), opponentPiece);
                    }
                    map.printMap(gamePiece.getXMap("P1"), gamePiece.getYMap("P1"), gamePiece.getXMap("P2"), gamePiece.getYMap("P2"));
                    input[0] = playPiece.decideGameWinner(readInput.getCurrentPlayerTurn(), input[0], gamePiece.getXMap(readInput.getCurrentPlayerTurn()), gamePiece.getYMap(readInput.getCurrentPlayerTurn()), gamePiece.getXMap(readInput.getOpponentPlayerTurn()), gamePiece.getYMap(readInput.getOpponentPlayerTurn()));
                    readInput.setPlayerTurn();
                    System.out.println("\nMove is Valid.");
                    readInput.displayPreviousMove(prevMove);
                    continue;
                } 
                System.out.println("\n" + moveValidity + "\n");
            } 
            System.out.println("\nThank you very much for playing the game. Hope you enjoyed!");
        } 
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
