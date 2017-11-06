import java.util.Random;

public class Zad3 {
    public static void main(String[] args) {
        int[][] rand_numbers = new int[5][5];
        Random generator = new Random();
        int[] min_wiersze = new int[5];
        int[] max_kolumny = new int[5];

        for(int i=0; i<rand_numbers.length; i++){
            for(int m=0; m<rand_numbers[i].length; m++){
                rand_numbers[i][m] = generator.nextInt(10)-5;
                if(m==0){
                    min_wiersze[i] = rand_numbers[i][m];
                }else{
                    if(min_wiersze[i]>rand_numbers[i][m]) min_wiersze[i]=rand_numbers[i][m];
                }
                System.out.print(rand_numbers[i][m]+"  ");
            }
            System.out.println();
        }

        System.out.println("Minimalne wartosci w wierszach:");
        for(int i=0; i<min_wiersze.length; i++){
            System.out.println(i+": "+min_wiersze[i]);
        }

        for(int i=0; i<rand_numbers[0].length; i++){
            for(int m=0; m<rand_numbers.length; m++){
                if(m==0){
                    max_kolumny[i] = rand_numbers[m][i];
                }else{
                    if(max_kolumny[i]<rand_numbers[m][i]) max_kolumny[i]=rand_numbers[m][i];
                }
            }
        }

        System.out.println("Maksymalny wartosci w kolumnach:");
        for(int i=0; i<max_kolumny.length; i++){
            System.out.println(i+": "+max_kolumny[i]);
        }

        int maks_przekatna=0;
        for(int i=0,m=0; i<rand_numbers.length; i++, m++){
            if(i==0) maks_przekatna=rand_numbers[i][m];
            if(rand_numbers[i][m]>maks_przekatna) maks_przekatna=rand_numbers[i][m];
        }
        System.out.println("Maksimum na 1. przekatnej:"+maks_przekatna);

        int min_przekatna=0;
        for(int i=rand_numbers.length-1,m=0; i>=0; i--, m++){
            if(m==0) min_przekatna=rand_numbers[i][m];
            if(rand_numbers[i][m]<min_przekatna) min_przekatna=rand_numbers[i][m];
        }
        System.out.println("Minimum na 2. przekatnej:"+min_przekatna);

    }
}
