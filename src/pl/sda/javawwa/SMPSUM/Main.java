package pl.sda.javawwa.SMPSUM;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] dane = sc.nextLine().split(" ");

        long wynik = 0;
        int a, b;

        a = Integer.valueOf(dane[0]);
        b = Integer.valueOf(dane[1]);

        for (int i = a; i <= b; i++){
            wynik += (long)Math.pow(i,2);

        }
        System.out.println(wynik);


    }

}
