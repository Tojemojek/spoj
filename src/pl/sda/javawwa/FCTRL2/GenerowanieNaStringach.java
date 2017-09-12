package pl.sda.javawwa.FCTRL2;


import java.util.Scanner;

public class GenerowanieNaStringach {

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        sb.append("");
        int howMany;
        int[] intTmp;
        String s1;
        int readTmp, z;

        howMany = sc.nextInt();

        for (int y = 0; y < howMany; y++) {
            readTmp = sc.nextInt();

            if (readTmp == 0 & readTmp == 1) {
                System.out.println("1");
            } else {

                s1 = "1";

                for (z = 1; z < readTmp + 1; z++) {
                    intTmp = new int[s1.length()];
                    for (int i = 0; i < s1.length(); i++) {
                        intTmp[i] = Integer.valueOf(s1.substring(i, i + 1));
                    }

                    for (int i = 0; i < s1.length(); i++) {
                        intTmp[i] = intTmp[i] * z;
                    }

                    for (int i = s1.length() - 1; i > 0; i--) {
                        intTmp[i - 1] = intTmp[i - 1] + intTmp[i] / 10;
                        intTmp[i] = intTmp[i] % 10;
                    }

                    sb.setLength(0);
                    for (int i = 0; i < s1.length(); i++) {
                        sb.append(intTmp[i]);

                    }
                    s1 = sb.toString();


                }
                System.out.print(s1);
                System.out.println();
            }
        }
    }

}
