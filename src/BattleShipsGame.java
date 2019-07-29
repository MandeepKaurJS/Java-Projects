import java.util.*;

public class BattleShipsGame {

    public static final int[][] ocean = new int[10][10];

    public static final Scanner input = new Scanner(System.in);

    public static final Random rand = new Random();

    public static int cp = 5; //Player´s ships

    public static int cc = 5; //Computer´s ships

//I messed up, te x and y coordinates in the map are switched, the game still works tho

    public static void main(String[] args){
        for(int r = 0; r < ocean.length; r++){
            for(int c = 0; c < ocean[r].length; c++){
                ocean[r][c] = 0;
            }
        }
        System.out.println();
        System.out.println();
        System.out.println("**** Welcome to Battle Ships game ****");
        System.out.println();
        System.out.println("Right now, the sea is empty.");
        System.out.println();
        System.out.println("   0123456789  ");
        for(int r = 0; r < 10; r++){
            System.out.println(r + " |          | " + r);
        }
        System.out.println("   0123456789  ");

        for(int i = 0; i < 5; i++){
            System.out.print("Enter X coordinate for your ship:  ");
            int x = input.nextInt();
            System.out.print("Enter Y coordinate for your ship:  ");
            int y = input.nextInt();
            int o = 0;
            while(ocean[x][y] == 1 && o == 0){
                System.out.println("Please enter a new coordinate");
                System.out.print("Enter X coordinate for your ship:  ");
                x = input.nextInt();
                System.out.print("Enter Y coordinate for your ship:  ");
                y = input.nextInt();
                while(ocean[x][y] == 0 ){
                    ocean[x][y] = 1;
                    o = 1;
                }
            }
            while(ocean[x][y] == 0 ){
                ocean[x][y] = 1;
            }
            System.out.println(x+ "," +y);
        }

        System.out.println();
        System.out.println("   0123456789   ");
        for(int j = 0; j <= 9; j++){
            System.out.print(j+" |");
            for(int k = 0; k <= 9; k++){
                if(ocean[j][k] == 0){
                    System.out.print(" ");
                } else if (ocean[j][k] == 1){
                    System.out.print("@");
                } else{
                    System.out.println("Error");
                }
            }
            System.out.println("| "+j);
        }
        System.out.println("   0123456789   ");
        System.out.println();
        System.out.println("Computer is deploying ships");


        for(int c = 1; c <= 5; c++){
            int x = rand.nextInt(10);
            int y = rand.nextInt(10);

            int o = 0;
            while((ocean[x][y] == 1 && o == 0)||(ocean[x][y] == 2 && o == 0)){
                x = rand.nextInt(10);
                y = rand.nextInt(10);
                while(ocean[x][y] == 0 ){
                    ocean[x][y] = 2;
                    o = 1;
                }
            }
            while(ocean[x][y] == 0 ){
                ocean[x][y] = 2;
                System.out.println(c + ". ship DEPLOYED");
            }
        }
        System.out.println("------------------------------");

        System.out.println();
        System.out.println("   0123456789   ");
        for(int j = 0; j <= 9; j++){
            System.out.print(j+" |");
            for(int k = 0; k <= 9; k++){
                if(ocean[j][k] == 0){
                    System.out.print(" ");
                } else if (ocean[j][k] == 1){
                    System.out.print("@");
                } else if(ocean[j][k] == 2){
                    System.out.print(" ");
                }else{
                    System.out.println("Error");
                }
            }
            System.out.println("| "+j);
        }
        System.out.println("   0123456789   ");

        while((cp>0)&&(cc>0)){
            playerturn();
            paintmap();
            computerturn();
            paintmap();
        }
        if(cp == 0){
            System.out.println();
            System.out.println("Your ships: "+cp+" |  Computer's ships: "+cc);
            System.out.println("Computer wins");
        } else if(cc == 0){
            System.out.println();
            System.out.println("Your ships: "+cp+" |  Computer's ships: "+cc);
            System.out.println("You win");
        }

    }

    public static void playerturn(){
        System.out.println();
        System.out.println("YOUR TURN");
        System.out.println("Enter X coordinate");
        int px = input.nextInt();
        System.out.println("Enter Y coordinate");
        int py = input.nextInt();

        if(ocean[px][py] == 0){
            System.out.println("You missed");
            ocean[px][py] = 3;
        } else if(ocean[px][py] == 2){
            System.out.println("You sunk the ship");
            ocean[px][py] = 4;
            if(ocean[px][py] == 4){
                cc--;
                System.out.println("Your ships: "+cp+" |  Computer's ships: "+cc);
            }
        } else if(ocean[px][py] == 1){
            System.out.println("You sunk your own ship");
            ocean[px][py] = 5;
            cp--;
            System.out.println("Your ships: "+cp+" |  Computer's ships: "+cc);
        }

    }

    public static void paintmap(){
        System.out.println();
        System.out.println("   0123456789   ");
        for(int j = 0; j <= 9; j++){
            System.out.print(j+" |");
            for(int k = 0; k <= 9; k++){
                if(ocean[j][k] == 0){
                    System.out.print(" ");
                } else if (ocean[j][k] == 1){
                    System.out.print("@");
                } else if(ocean[j][k] == 2){
                    System.out.print(" ");
                }else if(ocean[j][k] == 3){
                    System.out.print("-");
                } else if(ocean[j][k] == 4){
                    System.out.print("!");
                } else if(ocean[j][k] == 5){
                    System.out.print("x");
                } else if(ocean[j][k] == 6){
                    System.out.print("-");
                }else if(ocean[j][k] == 7){
                    System.out.print("x");
                }
            }
            System.out.println("| "+j);
        }
        System.out.println("   0123456789   ");

    }

    public static void computerturn(){
        System.out.println();
        System.out.println("COMPUTER'S TURN");
        int cx = rand.nextInt(10);
        int cy = rand.nextInt(10);
        System.out.println("original " +cx+","+cy );
        while(ocean[cx][cy] == 2){
            cx = rand.nextInt(10);
            cy = rand.nextInt(10);
        }
        while(ocean[cx][cy] == 3){
            cx = rand.nextInt(10);
            cy = rand.nextInt(10);
            System.out.println(cx+","+cy);
        }
        while(ocean[cx][cy] == 6){
            cx = rand.nextInt(10);
            cy = rand.nextInt(10);
            System.out.println(cx+","+cy);
        }
        while(ocean[cx][cy] == 0){
            System.out.println("Computer missed");
            System.out.println(cx+","+cy);
            ocean[cx][cy] = 6;
        }
        while(ocean[cx][cy] == 1){
            System.out.println("The computer sunk one of your ships");
            System.out.println(cx+","+cy);
            ocean[cx][cy] = 7;
            if(ocean[cx][cy] == 7){
                cp--;
                System.out.println("Your ships: "+cp+" |  Computer's ships: "+cc);
            }
        }
        System.out.println();
    }
}