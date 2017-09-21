package pl.sda.javawwa.BOOKS1;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));

        int howManyCases = sc.nextInt();
        long booksNumber;
        long scribers;
        int longestBook;
        String[] dataToParse;
        int pages[];
        long totalPages;
        longestBook = 0;
        long avg;
        StringBuilder sb = new StringBuilder();
        sb.append("");
        long tmpPagesDone;
        int tmpBookCount;

        for (int i = 0; i < howManyCases; i++) {
            booksNumber = sc.nextInt();
            scribers = sc.nextInt();

            totalPages = 0;
            dataToParse = sc.nextLine().split(" ");
            pages = new int[dataToParse.length];

            for (int j = 0; j < dataToParse.length; j++) {
                pages[j] = Integer.valueOf(dataToParse[j]);
                totalPages += pages[j];
                if (pages[j] > longestBook) {
                    longestBook = pages[j];
                }
            }

            avg = (totalPages / scribers);

            for (int j = 0; j < dataToParse.length; ) {
                sb.setLength(0);

                tmpPagesDone = pages[j];
                sb.append(pages[j]);
                totalPages -= pages[j];


                if (scribers == 1){
                    while (j<dataToParse.length - 1 ) {
                        tmpPagesDone += pages[j + 1];
                        totalPages -= pages[j + 1];
                        sb.append(" ").append(pages[j + 1]);
                        j++;
                    }
                } else if (tmpPagesDone > avg) {
                } else {
                    while (j < dataToParse.length - 1 && tmpPagesDone + pages[j + 1] <= avg) {
                        tmpPagesDone += pages[j + 1];
                        totalPages -= pages[j + 1];
                        sb.append(" ").append(pages[j + 1]);
                        j++;
                    }
                }

                if (j != dataToParse.length - 1) {
                    sb.append(" / ");
                    out.print(sb.toString());
                } else {
                    out.print(sb.toString());
                    out.println();
                }
                j++;
                scribers--;
                if (scribers != 0) {
                    avg = totalPages / scribers;
                }

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