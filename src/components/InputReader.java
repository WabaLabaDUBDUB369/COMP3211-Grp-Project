package components;

import java.io.*;

public class InputReader {
    private String playerTurn = "P1";

    public String[] readInput() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Turn for Player " + playerTurn);
        System.out.print("Please input your move in the following format (e.g. Elephant A 9):\n");
        String readInput = reader.readLine();
        return readInput.split("\\s+");
    }

    public void setPlayerTurn(){
        this.playerTurn = this.playerTurn == "P1" ? "P2" : "P1";
    }

    public String getCurrentPlayerTurn(){
        return playerTurn;
    }
    public String getOpponentPlayerTurn(){
        if(this.playerTurn == "P1"){
            return "P2";
        }
        return "P1";
    }
    public void displayPreviousMove(String[] prevMove){
        String opponent = "";
        if(this.playerTurn == "P1"){
            opponent = "Player 2";
        } else {
            opponent = "Player 1";
        }
        System.out.print("\nPrevious move by " + opponent + ":  ");
        for(int i=0; i<prevMove.length; i++){
            if(i == 0){
                System.out.print(prevMove[i] + " to ");
                continue;
            }  
            System.out.print(prevMove[i]);      
        }
        System.out.print("\n");      
    }
}
