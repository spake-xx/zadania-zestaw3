import java.util.Random;

public class Zad2 {
    public static void main(String[] args) {
        int[] rand_numbers = new int[20];
        Random generator = new Random();

        System.out.println("Wylosowane liczby:");
        for(int i=0; i<rand_numbers.length; i++){
            rand_numbers[i] = generator.nextInt(10)+1;
            System.out.print(rand_numbers[i]+",");
        }
        System.out.println();

        System.out.println("Wystapienia:");
        for(int i=1; i<=10; i++){
            int ilosc_wystapien=0;
            for(int j:rand_numbers){
                if(j==i) ilosc_wystapien++;
            }

            System.out.println(i+" - "+ilosc_wystapien);
        }
    }
}
