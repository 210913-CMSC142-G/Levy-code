import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int W = in.nextInt(); // width of the building.
        int H = in.nextInt(); // height of the building.
        int N = in.nextInt(); // maximum number of turns before game over.
        int X0 = in.nextInt();  //statrting position of batman x axis
        int Y0 = in.nextInt();  //starting position of batman y axis

        //"boundary" of the building (para malaman what is in the right or left, up or down (binary ish))
        int x1 = 0; //"left most"
        int y1 = 0; // "uppermost"
        int x2 = W - 1; //"right" of x axis
        int y2 = H - 1; //the lowermost of y axis

        // game loop
        while (true) {
            String bombDir = in.next(); // the direction of the bombs from batman's current location (U, UR, R, DR, D, DL, L or UL)
            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");
            System.err.println("Debug messages...");
           
            if(bombDir.contains("U"))
            {
                y2 = Y0 - 1; //the lower part would be starting position of batman then - 1 para tumaas sya
            }
            else if (bombDir.contains("D"))
            {
                y1 = Y0 + 1; //the upper part would be starting position of batman then + 1 para bumaba sya
            }

            if(bombDir.contains("L"))
            {
                x2 = X0 - 1; //the "right" part would be starting position of batman then - 1 para mag left sya
            }
            else if (bombDir.contains("R"))
            {
                x1 = X0 + 1; //the "left" part would be starting position of batman then - 1 para mag right sya
            }

            X0 = x1 + ((x2 - x1) / 2); //left most + ((yung pag move ni batman)divided by 2 kasi yung isang half lang nagamit na gumalaw)
            Y0 = y1 + ((y2 - y1) / 2);//upper most + ((yung pag move ni batman)divided by 2 kasi yung isang half lang nagamit na gumalaw)

            // the location of the next window Batman should jump to.
            System.out.println(X0 + " " + Y0);
        }
    }
}