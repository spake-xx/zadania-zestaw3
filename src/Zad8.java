import java.util.Scanner;

public class Zad8 {
    private static void wyswietl_zu2(int[] zu2, int zu2_length){
        System.out.print(zu2[0]+".");
        for(int i=1; i<zu2_length; i++){
            if(i==(zu2_length-1) && zu2[i]==0) break;
            System.out.print(zu2[i]);
        }
    }

    private static int[] przesun(int[] zu2, int zu2_length,  boolean w_prawo){
        if(w_prawo){
            for(int i=zu2_length; i>=0; i--){
                zu2[i+1] = zu2[i];
                if(i==0) zu2[i] = 0;
            }
        }else{
            for(int i=0; i<zu2_length; i++){
                if((i)>=(zu2_length-1)) break;
                zu2[i] = zu2[i+1];
            }
        }
        return zu2;
    }

    private static int[][] odejmij_zu2(int[] A, int[] B, int A_length, int B_length){
        int[] wynik = new int[32];
        int wynik_length = A_length;
        if(B_length<A_length){
            for(int i=B_length; i<A_length; i++){
                B[i] = 0;
            }
        }
        for(int i=wynik_length; i>=0; i--){
            if(A[i]-B[i]==0){
                wynik[i] = 0;
            }else if(A[i]-B[i]==1){
                wynik[i] = 1;
            }else if(A[i]-B[i]<0){
                int j = i-1;
                boolean w = false;
                while(j>=0){
                    if (A[j] == 1) {
                        A[j] = 0;
                        A[i] = 2;
                        for(int k=(j+1); k<i; k++){
                            A[k]=1;
                        }
                        w = true;
                        break;
                    }
                    j--;
                };
                if(!w){
                    w = true;
                    A[i] = 2;
                    for(int k=0; k<i; k++){
                        A[k]=1;
                    }
                }

                wynik[i] = A[i]-B[i];
            }
        }

        int[] length = {wynik_length};
        int[][] result = {wynik, length};

        return result;
    }

    private static int[][] dodaj_zu2(int[] A, int[] B, int A_length, int B_length){
        int[] wynik = new int[32];
        int wynik_length = 0;
        if(A_length<B_length){
            for(int i=A_length; i<B_length; i++){
                A[i] = 0;
            }
            A_length = B_length;
            wynik_length = B_length;
        }
        if(B_length<A_length){
            for(int i=B_length; i<A_length; i++){
                B[i] = 0;
            }
            B_length = A_length;
            wynik_length = A_length;
        }

        int jeden_dalej = 0;
        for(int i=wynik_length; i>=0; i--){
            if(A[i]+B[i]==1){
                if(jeden_dalej==0) {
                    wynik[i] = 1;
                }else if(jeden_dalej==1){
                    wynik[i] = 0;
                }else if(jeden_dalej==2){
                    wynik[i] = 1;
                }
            }else if(A[i]+B[i]==2) {
                if (jeden_dalej == 0) {
                    jeden_dalej = 1;
                    wynik[i] = 0;
                } else if (jeden_dalej == 1) {
                    wynik[i] = 1;
                } else if (jeden_dalej == 2) {
                    System.err.print("ERROR: overflow");
                }
            }else if(A[i]+B[i]==0){
                if (jeden_dalej == 0) {
                    wynik[i] = 0;
                } else if (jeden_dalej == 1) {
                    jeden_dalej = 0;
                    wynik[i] = 1;
                } else if (jeden_dalej == 2) {
                    jeden_dalej = 1;
                    wynik[1] = 1;
                }
            }
        }

        int[] length = {wynik_length};

        int[][] result = {wynik, length};

        return result;
    }

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int[] zu2_A = new int[32];
        int[] zu2_B = new int[32];
        int A_length = 0;
        int B_length = 0;
//
//        zu2_A[0] = 0;
//        zu2_A[1] = 0;
//        zu2_A[2] = 1;
//        zu2_A[3] = 1;
//        zu2_A[4] = 0;
//        zu2_A[5] = 1;
//        zu2_A[6] = 1;
//
//        zu2_B[0] = 1;
//        zu2_B[1] = 0;
//        zu2_B[2] = 1;
//        zu2_B[3] = 0;
//        zu2_B[4] = 1;
//        zu2_B[5] = 1;

        System.out.println("Podaj liczbę A zakodowaną w ZU2:");
        char[] a_input  = reader.next().toCharArray();
        System.out.println("Podaj liczbę B zakodowaną w ZU2:");
        char[] b_input  = reader.next().toCharArray();
        A_length = a_input.length;
        B_length = b_input.length;
        for (int i = 0; i < A_length; i++) {
            zu2_A[i] = Character.getNumericValue(a_input[i]);
        }
        for (int i = 0; i < B_length; i++) {
            zu2_B[i] = Character.getNumericValue(b_input[i]);
        }


        zu2_A = przesun(zu2_A, A_length, true);
        A_length++;

        int[] q = new int[32];
        int q_length = A_length;
        for(int i=0; i<A_length; i++){
            q[i] = 0;
        }

        for(int i=B_length; i>=0; i--){
            if(i==0){
                if(zu2_B[i] == 1){
                    int[][] wynik = odejmij_zu2(q, zu2_A, q_length, A_length);
                    q = wynik[0];
                    q_length = wynik[1][0];
                    System.out.println("--------------");
                }
                System.out.print("<-");
                wyswietl_zu2(q, q_length);
                System.out.println();
                q = przesun(q, q_length, false);
                q_length--;
            }else{
                if (zu2_B[i] == 1) {
                    wyswietl_zu2(q, q_length);
                    System.out.println();
                    wyswietl_zu2(zu2_A, A_length);
                    System.out.print("+");
                    System.out.println();
                    int[][] wynik = dodaj_zu2(zu2_A, q, A_length, q_length);
                    q = wynik[0];
                    q_length = wynik[1][0];
                    System.out.println("---------------");
                    wyswietl_zu2(q, q_length);
                    System.out.println();
                }
                q = przesun(q, q_length, true);
                q_length++;
                wyswietl_zu2(q, q_length);
                System.out.print("->");
                System.out.println();
            }
        }
        System.out.println("Wynik w ZU2:");
        wyswietl_zu2(q, q_length);
    }
}