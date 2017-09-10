package pl.sda.javawwa.Testy;

import java.io.*;
import java.util.StringTokenizer;

public class Main1 {

    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
       // out = new PrintWriter(new BufferedOutputStream(System.out));

        String testowy;
        do {

            testowy = sc.nextLine();
            System.out.println(testowy);


        } while (!testowy.equals("42"));

        //out.close();

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