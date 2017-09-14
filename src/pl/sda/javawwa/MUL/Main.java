package pl.sda.javawwa.MUL;

import java.io.*;
import java.util.StringTokenizer;


//DZIAŁA ALE JEST ZA WOLNE!
public class Main {
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();


        int testCases = sc.nextInt();
        String[] multiplications = new String[testCases];
        String[] temp = new String[2];

        for (int i = 0; i < testCases; i++) {
            multiplications[i] = sc.nextLine();
        }

        for (int i = 0; i < testCases; i++) {
            temp = multiplications[i].split(" ");
            if (temp[0].equals("0") || temp[1].equals("0")) {
                System.out.println("0");
            } else {
                multiplyThisStrings(temp[0], temp[1]);
            }
        }

        out.close();
    }

    public static void multiplyThisStrings(String a, String b) {

        out = new PrintWriter(new BufferedOutputStream(System.out));

        String test1 = a;
        String test2 = b;

        int maxLength = test1.length() + test2.length() - 1;

        
        char[] test1Char = test1.toCharArray();
        int[] test1Int = new int[test1.length()];
        char[] test2Char = test2.toCharArray();
        int[] test2Int = new int[test2.length()];
        int[] result = new int[maxLength];


        for (int i = 0; i < test1.length(); i++) {
            test1Int[i] = Integer.parseInt((String.valueOf(test1Char[i])));
        }
        for (int i = 0; i < test2.length(); i++) {
            test2Int[i] = Integer.parseInt((String.valueOf(test2Char[i])));
        }

        int pos1, pos2 = 0;

        for (int i = (test1.length() - 1); i >= 0; i--) {
            pos1 = test1.length() - 1 - i;
            for (int j = (test2.length() - 1); j >= 0; j--) {
                pos2 = (test2.length() - 1) - j;
                result[pos1 + pos2] += test1Int[i] * test2Int[j];
            }
        }

        for (int i = 0; i < result.length - 1; i++) {
            result[i + 1] = result[i + 1] + result[i] / 10;
            result[i] = result[i] % 10;

        }
        for (int i = result.length - 1; i >= 0; i--) {
            if (i == 0 && result[i] == 0) {

            } else {
                out.print(result[i]);
            }

        }
        out.println();
        out.flush();
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
    //--------------------------------------------------------
}