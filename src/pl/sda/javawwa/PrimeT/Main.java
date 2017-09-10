package pl.sda.javawwa.PrimeT;

import java.io.*;
import java.util.*;


public class Main {
    static boolean[] pierwsze = new boolean[10001];

    public static void main(String[] args) {

        List<Boolean> badane = new ArrayList<>();
        Boolean correctData = true;
        findPrime();
        Integer tmp;

        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));

        sc.nextLine();

        do {
            try {
                tmp = Integer.parseInt(sc.nextLine());
                if (pierwsze[tmp]) {
                    badane.add(false);
                } else {
                    badane.add(true);
                }

            } catch (NumberFormatException e) {
                correctData = false;
            }
        } while (correctData);


        for (Boolean b : badane) {
            if (b) {
                out.println("TAK");
                out.flush();
            } else {
                out.println("NIE");
                out.flush();
            }
        }

    }


    public static void findPrime() {

        Integer rozmiarTablicy = 10001;
        Integer j;
        pierwsze[0] = true;
        pierwsze[1] = true;

        for (int i = 2; i < rozmiarTablicy; i++) {
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
