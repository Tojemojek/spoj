package pl.sda.javawwa.Testy;

import java.io.*;
import java.util.*;

public class HS12HDPW {

    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        StringBuilder sb = new StringBuilder();
        sb.append("");

        List<String> test = new ArrayList<>();
        List<String> decode = new ArrayList<>();

        int howManyToDecode = sc.nextInt();
        sc.nextLine();
        test.add(sc.nextLine());
        decode.add(sc.nextLine());

        for (int i = 1; i < howManyToDecode; i++){
            sc.nextLine();
            sc.nextLine();
            test.add(sc.nextLine());
            decode.add(sc.nextLine());
        }

        for (int z = 0; z <howManyToDecode; z++) {

            List<String> doTest = new ArrayList<>();
            doTest = Arrays.asList(test.get(z).split(" "));

            sb.setLength(0);
            for (String txt : doTest) {
                Integer a = 0;
                Integer b = 0;
                for (int i = 0; i < 6; i++) {
                    String s = Integer.toString(txt.charAt(i), 2);
                    s = new StringBuilder(s).reverse().toString();
                    String s2, s1;
                    s1 = (i > s.length() - 1) ? "0" : String.valueOf(s.charAt(i));
                    s2 = (((i + 3) % 6) > s.length() - 1) ? "0" : String.valueOf(s.charAt(((i + 3) % 6)));
                    a += Integer.parseInt(s1) * (int) Math.pow(2, i);
                    b += Integer.parseInt(s2) * (int) Math.pow(2, (i));

                }
                sb.append(decode.get(z).charAt(a)).append(decode.get(z).charAt(b));

            }
            out.println(sb.toString());
            out.flush();

        }


        out.close();

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