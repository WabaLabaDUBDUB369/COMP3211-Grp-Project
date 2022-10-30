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
                input[0] = input[0].toLowerCase();
                input[0] = readInput.getCurrentPlayerTurn().concat(" " + input[0].substring(0, 1).toUpperCase() + input[0].substring(1));
                moveValidity = playPiece.playGamePiece(input, gamePiece.getXMap(readInput.getCurrentPlayerTurn()), gamePiece.getYMap(readInput.getCurrentPlayerTurn()), gamePiece.getXMap(readInput.getOpponentPlayerTurn()), gamePiece.getYMap(readInput.getOpponentPlayerTurn()));
                opponentPiece = playPiece.checkIfPiecePresent(Integer.parseInt(input[2]), input[1], gamePiece.getXMap(readInput.getOpponentPlayerTurn()), gamePiece.getYMap(readInput.getOpponentPlayerTurn()));

                if(moveValidity.equals("Valid Move")){
                    gamePiece.setMap(readInput.getCurrentPlayerTurn(), input[0], Integer.parseInt(input[2]), input[1]);
                    prevMove = input.clone(); 
                    if(opponentPiece != ""){
                        gamePiece.removeGamePiece(readInput.getOpponentPlayerTurn(), opponentPiece);
                    }
                    input[0] = playPiece.decideGameWinner(readInput.getCurrentPlayerTurn(), input[0], gamePiece.getXMap(readInput.getCurrentPlayerTurn()), gamePiece.getYMap(readInput.getCurrentPlayerTurn()), gamePiece.getXMap(readInput.getOpponentPlayerTurn()), gamePiece.getYMap(readInput.getOpponentPlayerTurn()));
                    map.printMap(gamePiece.getXMap("P1"), gamePiece.getYMap("P1"), gamePiece.getXMap("P2"), gamePiece.getYMap("P2"));
                    readInput.setPlayerTurn();
                    readInput.displayPreviousMove(prevMove);
                } 
                System.out.println("\n" + moveValidity);
            } 
            System.out.println("\nThank you very much for playing the game. Hope you enjoyed!");
        } 
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
