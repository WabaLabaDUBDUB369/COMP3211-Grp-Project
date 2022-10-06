package components;
import java.util.*;


public class GamePieces {
    
    // private ArrayList<String> pieceSet1  = new ArrayList<String>(
    //     Arrays.asList("Rat", "Cat", "Dog", "Wolf", "Leopard", "Tiger", "Lion", "Elephant")
    // );
    // private ArrayList<String> pieceSet2  = new ArrayList<String>(
    //     Arrays.asList("Rat", "Cat", "Dog", "Wolf", "Leopard", "Tiger", "Lion", "Elephant")
    // );

    private HashMap<String, Integer> map_X_P1 = new HashMap<>();
    private HashMap<String, Integer> map_Y_P1 = new HashMap<>();
    private HashMap<String, Integer> map_X_P2 = new HashMap<>();
    private HashMap<String, Integer> map_Y_P2 = new HashMap<>();

    
    public GamePieces() {
        map_X_P1.put("P1 Tiger", 1);
        map_X_P1.put("P1 Lion", 1);
        map_X_P1.put("P1 Cat", 2);
        map_X_P1.put("P1 Dog", 2);
        map_X_P1.put("P1 Elephant", 3);
        map_X_P1.put("P1 Wolf", 3);
        map_X_P1.put("P1 Leopard", 3);
        map_X_P1.put("P1 Rat", 3);

        map_Y_P1.put("P1 Tiger", 1);
        map_Y_P1.put("P1 Lion", 7);
        map_Y_P1.put("P1 Cat", 2);
        map_Y_P1.put("P1 Dog", 6);
        map_Y_P1.put("P1 Elephant", 1);
        map_Y_P1.put("P1 Wolf", 3);
        map_Y_P1.put("P1 Leopard", 5);
        map_Y_P1.put("P1 Rat", 7);

        map_X_P2.put("P2 Tiger", 9);
        map_X_P2.put("P2 Lion", 9);
        map_X_P2.put("P2 Cat", 8);
        map_X_P2.put("P2 Dog", 8);
        map_X_P2.put("P2 Elephant", 7);
        map_X_P2.put("P2 Wolf", 7);
        map_X_P2.put("P2 Leopard", 7);
        map_X_P2.put("P2 Rat", 7);
    
        map_Y_P2.put("P2 Tiger", 7);
        map_Y_P2.put("P2 Lion", 1);
        map_Y_P2.put("P2 Cat", 6);
        map_Y_P2.put("P2 Dog", 2);
        map_Y_P2.put("P2 Elephant", 7);
        map_Y_P2.put("P2 Wolf", 5);
        map_Y_P2.put("P2 Leopard", 3);
        map_Y_P2.put("P2 Rat", 1);
    }

    public void removegamePieceP1(String gamePiece){
        this.map_X_P1.remove(gamePiece);
        this.map_Y_P1.remove(gamePiece);
    }

    public void removegamePieceP2(String gamePiece){
        this.map_X_P2.remove(gamePiece);
        this.map_Y_P2.remove(gamePiece);
    }
    
    public void setMapP1(String gamePiece, Integer X, String Y){
        Integer column = setColumn(Y.charAt(0));
        this.map_X_P1.replace(gamePiece, X);
        this.map_Y_P1.replace(gamePiece, column);
    }
    public void setMapP2(String gamePiece, Integer X, String Y){
        Integer column = setColumn(Y.charAt(0));
        this.map_X_P2.replace(gamePiece, X);
        this.map_Y_P2.replace(gamePiece, column);
    }

    public HashMap<String, Integer> getXMapP1(){
        return map_X_P1;
    }

    public HashMap<String, Integer> getYMapP1(){
        return map_Y_P1;
    }

    public HashMap<String, Integer> getXMapP2(){
        return map_X_P2;
    }

    public HashMap<String, Integer> getYMapP2(){
        return map_Y_P2;
    }

    public Integer setColumn(Character input){
        switch(input){
            case 'A':
                return 1;
            
            case 'B':
                return 2;

            case 'C':
                return 3;
            
            case 'D':
                return 4;

            case 'E':
                return 5;

            case 'F':
                return 6;
            
            default:
                return 7;
        }
    }

}