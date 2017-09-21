package pl.sda.javawwa.ESYRCRTN;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));

        // Start writing your solution here. -------------------------------------


        int howManyTimes = sc.nextInt();
        long testNumber;
        int modulo6 = 0;


        for (int i = 0; i < howManyTimes; i++) {
            testNumber = sc.nextLong();

            modulo6 = (int) (testNumber % 6);

            switch (modulo6) {
                case 0: {
                    out.println(0);
                    break;
                }
                case 1: {
                    out.println(1);
                    break;
                }
                case 2: {
                    out.println(4);
                    break;
                }
                case 3: {
                    out.println(6);
                    break;
                }
                case 4: {
                    out.println(5);
                    break;
                }
                case 5: {
                    out.println(2);
                    break;
                }
            }
        }





      /*
      int n      = sc.nextInt();        // read input as integer
      long k     = sc.nextLong();       // read input as long
      double d   = sc.nextDouble();     // read input as double
      String str = sc.next();           // read input as String
      String s   = sc.nextLine();       // read whole line as String

      int result = 3*n;
      out.println(result);                    // print via PrintWriter
      */

        // Stop writing your solution here. -------------------------------------
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
    //--------------------------------------------------------
}