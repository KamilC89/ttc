package Game;

import java.util.Scanner;
import static Game.Game.*;

public class Main {

    public static void main(String[] args) {

        int decision;
        do{
            game();
            System.out.println("Retry ? 1(YES) / 2(NO)");
            decision = new Scanner(System.in).nextInt();
          }
        while(decision == 1);
        }

    }




