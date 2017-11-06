import java.util.Random;
import java.util.Scanner;

public class Zad4 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int[] zm_modul = new int[32];
        int znak = 0;

        System.out.println("Wprowadz liczbe, ktora chcesz zamienic na kod binarny ZM:");
        int liczba = reader.nextInt();
        if(liczba<0){
            znak=1;
            liczba*=-1;
        }

        int temp=liczba;
        int i=0;
        while(temp>0){
            zm_modul[i] = temp%2;
            temp/=2;
            i++;
        }

        System.out.println("Liczba "+liczba+" w ZM:");
        System.out.print(znak+".");
        for(int j=i; j>=0; j--){
            System.out.print(zm_modul[j]);
        }

    }
}
