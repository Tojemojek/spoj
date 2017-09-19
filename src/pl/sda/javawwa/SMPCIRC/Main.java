package pl.sda.javawwa.SMPCIRC;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));

        String[] data;


        int x01, y01, r01, x02, y02, r02;
        double dist = 0;
        double rdiff = 0;
        int howMany = sc.nextInt();
        int rmax, rmin;


        for (int i = 0; i < howMany; i++) {

            data = sc.nextLine().split(" ");
            x01 = Integer.parseInt(data[0]);
            y01 = Integer.parseInt(data[1]);
            r01 = Integer.parseInt(data[2]);
            x02 = Integer.parseInt(data[3]);
            y02 = Integer.parseInt(data[4]);
            r02 = Integer.parseInt(data[5]);

            dist = Math.pow(x01 - x02, 2) + Math.pow(y01 - y02, 2);
            dist = Math.sqrt(dist);
            rdiff = Math.abs(r02 - r01);

            if (r01 > r02){
                rmax = r01;
                rmin = r02;
            } else {
                rmax = r02;
                rmin = r01;
            }

            if (1.0*rmax - 1.0*dist - 1.0*rmin ==0){
                out.println("E");
            } else if (1.0*rmax - 1.0*dist - 1.0*rmin >0){
                out.println("I");
            } else {
                out.println("O");
            }


        }


        // Start writing your solution here. -------------------------------------

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