package pl.sda.javawwa.PRIME1;

import java.io.*;
import java.util.StringTokenizer;


public class Main {
    public static boolean[] pierwsze;

    public static void main(String[] args) {

        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        Integer max = 0;
        Integer howMany = sc.nextInt();


        int[][] dolGora = new int[2][howMany];

        for (int i = 0; i < howMany; i++) {
            String[] tmp = sc.nextLine().split(" ");
            dolGora[0][i] = Integer.parseInt(tmp[0]);
            dolGora[1][i] = Integer.parseInt(tmp[1]);

        }

        for (int i = 0; i < howMany; i++) {
            printPrimes(dolGora[0][i], dolGora[1][i]);
        }
        out.close();
//
//
//            if (max < dolGora[1][i]) {
//                max = dolGora[1][i];
//            }
//        }
//
//        pierwsze = new boolean[max + 1];
//        findPrime(max);
//        StringBuilder sb = new StringBuilder();
//        sb.append("");
//
//        for (int i = 0; i < howMany; i++) {
//            sb.setLength(0);
//            for (int j = dolGora[0][i]; j <= dolGora[1][i]; j++) {
//                if (pierwsze[j] == false) {
//                    sb.append(j).append("\n");
//                    out.println(j);
//
//                }
//            }
//            out.flush();
//        }
//        out.close();
    }


    public static void printPrimes(int bottom,int top) {

        bottom = (bottom == 1) ? 2 : bottom;

        for (int i = bottom; i <= top; i++) {
            if (checkPrimes(i)) {
                out.println(i);
            }
        }
        out.println("");
        out.flush();
    }


    public static boolean checkPrimes(int doSprawdzenia) {
        int gornaGranicaDzielnikow = (int) Math.sqrt(doSprawdzenia);
        for (int j = 2; j <= gornaGranicaDzielnikow; j++) {
            if (doSprawdzenia % j == 0)
                return false;
        }
        return true;
    }


    public static void findPrime(int max) {

        Integer rozmiarTablicy = max + 1;
        Integer testujDo = (int) Math.sqrt(max + 1) + 1;
        Integer j;
        pierwsze[0] = true;
        pierwsze[1] = true;

        for (int i = 2; i < testujDo; i++) {
            if (!pierwsze[i]) {
                j = 2 * i;
                while (j < rozmiarTablicy) {
                    pierwsze[j] = true;
                    j += i;
                }
            }
        }
    }


    //-----------PrintWriter for faster output---------------------------------
    public static PrintWriter out;

    //-----------MyScanner class for faster input----------
    public static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

    }


}