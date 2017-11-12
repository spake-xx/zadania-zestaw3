import java.util.Scanner;

public class Zad6 {
    public static boolean czyPierwsze(int a, int b){
        while (a != b){
            if (a > b)
                a -= b;
            else
                b -= a;
        }

        if(a!=1) return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Podaj liczbę n:");
        int n = reader.nextInt();
        boolean[][] tab = new boolean[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(czyPierwsze(j+1, i+1)) tab[i][j] = true;

                System.out.print(tab[i][j]?"+":".");
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
