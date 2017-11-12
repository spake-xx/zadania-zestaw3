import java.util.Scanner;

public class Zad5 {
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
            if(temp!=0) i++;
        }

        System.out.println("Liczba "+liczba+" w ZM:");
        System.out.print(znak+".");
        for(int j=i; j>=0; j--){
            System.out.print(zm_modul[j]);
        }
        System.out.println();

        System.out.println("Liczba "+liczba+" w ZU1:");
        System.out.print(znak+".");
        for(int j=i; j>=0; j--){
            if(znak==1) {
                System.out.print(zm_modul[j] == 1 ? 0 : 1);
            }else{
                System.out.print(zm_modul[j]);
            }
        }
        System.out.println();

        System.out.println("Liczba "+liczba+" w ZU2:");
        System.out.print(znak+".");
        int[] zm2 = new int[32];
        if(znak==1) {
            boolean changed = false;
            for (int j = 0; j <= i; j++) {
                if (zm_modul[j] == 1 && !changed) {
                    changed = true;
                } else {
                    zm_modul[j] = zm_modul[j] == 1 ? 0 : 1;
                }
            }
            for (int j = i; j >= 0; j--) {
                System.out.print(zm_modul[j]);
            }
        }else{
            for(int j=i; j>=0; j--){
                System.out.print(zm_modul[j]);
            }
        }

    }
}
