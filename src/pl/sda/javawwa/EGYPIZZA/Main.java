package pl.sda.javawwa.EGYPIZZA;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));

        // Start writing your solution here. -------------------------------------

        int howMany = sc.nextInt();
        String pizzaNumber;
        double pizzaSummarizer = 0;


        int trzyCzwarte, polowa, jednaCzwarta;

        polowa = 0;
        trzyCzwarte = 0;
        jednaCzwarta = 0;
        int pizzaInt = 0;

        for (int i = 0; i < howMany; i++) {
            pizzaNumber = sc.nextLine();
            switch (pizzaNumber) {
                case ("1/4"):
                    jednaCzwarta++;
                    break;
                case ("1/2"):
                    polowa++;
                    break;
                case ("3/4"):
                    trzyCzwarte++;
                    break;
            }

        }

        if (trzyCzwarte >= jednaCzwarta) {
            pizzaInt += trzyCzwarte;
            jednaCzwarta = 0;
        } else {
            pizzaInt += trzyCzwarte;
            jednaCzwarta = jednaCzwarta - trzyCzwarte;
        }

        if (polowa % 2 == 0) {
            pizzaInt += polowa / 2;
        } else {
            pizzaInt += polowa / 2 + 1;
            jednaCzwarta -= 2;
        }

        if (jednaCzwarta > 0 && jednaCzwarta % 4 == 0) {
            pizzaInt+=jednaCzwarta / 4;
        } else if (jednaCzwarta > 0){
            pizzaInt+=jednaCzwarta / 4 + 1;
        }

        pizzaInt++;

        out.println(pizzaInt);



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