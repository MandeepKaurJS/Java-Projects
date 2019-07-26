import java.lang.reflect.Array;
import java.util.Arrays;

public class BattleShipsGame {
    public static void main(String[] args){
        System.out.println("**** Welcome to Battle Ships Game ****");
        System.out.println("Right Now, the sea is empty.");
        int[][] ships=new int[10][10];
        //int count=0;
        System.out.println("  0123456789");
        for(int i=0;i<ships.length;i++){
            System.out.println(i+"|");
            for (int j=0;j<ships[0].length;j++){
                if(ships[i][j]==0){
                    System.out.println(" ");
                }else if(ships[i][j]==1){
                    System.out.println("@");
                }else if (ships[i][j] == 5){ //5 corresponds to "the wreck of one of our own ships rests here"
                System.out.print("!");
                }else if (ships[i][j] == 6){ //6 corresponds to "the wreck of a computer ship lies here"
                System.out.print("x");
                }else if (ships[i][j] == 7){ //7 corresponds to "the player guessed this cell"
                System.out.print("-");
                }else if (ships[i][j] == 8){ //8 corresponds to "the computer guessed this cell"
                System.out.print(" ");
                }else if (ships[i][j] == 9){ //9 corresponds to "the player and computer both guessed this cell"
                System.out.print("-");
                }else if (ships[i][j] == 2){ //2 corresponds to "there is a computer ship here"
                System.out.print(" ");
                //System.out.print(board[r][c]);
                }
                }
                System.out.println("|"+i);
            }
        System.out.println("  0123456789");
        }
    }

