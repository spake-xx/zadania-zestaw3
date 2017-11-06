import java.util.Random;

public class Zad1 {
    public static void main(String[] args) {
        int[] rand_numbers = new int[10];
        Random generator = new Random();
        int min = 0, max = 0;

        System.out.println("Wylosowane liczby");

        for (int i = 0; i < rand_numbers.length; i++) {
            rand_numbers[i] = generator.nextInt(20) - 10;
            if (i == 0) {
                min = max = rand_numbers[i];
            } else {
                if (rand_numbers[i] > max) max = rand_numbers[i];
                if (rand_numbers[i] < min) min = rand_numbers[i];
            }
            System.out.print(rand_numbers[i] + ", ");
        }
        System.out.println();

        int suma = 0;
        for (int i : rand_numbers) {
            suma += i;
        }

        float srednia = suma / (rand_numbers.length);

        System.out.println("Max:" + max);
        System.out.println("Min:" + min);

        int ilosc_mniejszych = 0;
        int ilosc_wiekszych = 0;
        for (int i : rand_numbers) {
            if (i < srednia) ilosc_mniejszych++;
            if (i > srednia) ilosc_wiekszych++;
        }

        System.out.println("Srednia: " + srednia);
        System.out.println("Mniejszych:" + ilosc_mniejszych);
        System.out.println("Wiekszych:" + ilosc_wiekszych);

        System.out.println("Liczby w odwrotnej kolejnosci");
        for (int i = rand_numbers.length - 1; i >= 0; i--){
            System.out.print(rand_numbers[i] + ", ");
        }
    }
}
