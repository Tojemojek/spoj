package pl.sda.javawwa.FCTRL3;

import java.io.*;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));


        Integer rozmiar = sc.nextInt();
        Integer[][] cyfry = new Integer[2][rozmiar];
        Integer tmp;

        for (int i = 0; i < rozmiar; i++) {

            tmp = sc.nextInt();

            switch (tmp) {
                case 0:
                    cyfry[0][i] = 0;
                    cyfry[1][i] = 1;
                    break;
                case 1:
                    cyfry[0][i] = 0;
                    cyfry[1][i] = 1;
                    break;
                case 2:
                    cyfry[0][i] = 0;
                    cyfry[1][i] = 2;
                    break;
                case 3:
                    cyfry[0][i] = 0;
                    cyfry[1][i] = 6;
                    break;
                case 4:
                    cyfry[0][i] = 2;
                    cyfry[1][i] = 4;
                    break;
                case 5:
                case 6:
                case 8:
                    cyfry[0][i] = 2;
                    cyfry[1][i] = 0;
                    break;
                case 7:
                    cyfry[0][i] = 4;
                    cyfry[1][i] = 0;
                    break;
                case 9:
                    cyfry[0][i] = 8;
                    cyfry[1][i] = 0;
                    break;
                default:
                    cyfry[0][i] = 0;
                    cyfry[1][i] = 0;
                    break;
            }


        }

        for (int i = 0; i < rozmiar; i++) {
            out.println(cyfry[0][i] + " " + cyfry[1][i]);
            out.flush();
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
