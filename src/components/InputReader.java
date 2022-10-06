package components;

import java.io.*;

public class InputReader {
    private Integer playerTurn = 1;

    public String[] readInput() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Turn for Player " + playerTurn);
        System.out.print("Please input the command (e.g. Elephant A 9): ");
        String readInput = reader.readLine();
        return readInput.split("\\s+");
    }

    public void setPlayerTurn(){
        this.playerTurn = this.playerTurn == 1 ? 2 : 1;
    }

    public Integer getPlayerTurn(){
        return playerTurn;
    }

}
