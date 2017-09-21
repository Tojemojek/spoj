package pl.sda.javawwa.BOOKS1;

import java.io.*;
import java.util.StringTokenizer;

public class MainOwdr {
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));

        long scribers = 0;

        String[] dataToParse;
        int pages[];

        long totalPages;
        int longestBook;
        int howManyCases = sc.nextInt();

        long tmpPagesDone;
        long booksNumber;
        long maxWorkloadLimit;
        long maxWorkloadLimit2;

        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        sb.append("");
        sb2.append("");

        for (int i = 0; i < howManyCases; i++) {
            booksNumber = sc.nextInt();
            scribers = sc.nextInt();

            longestBook = 0;
            totalPages = 0;
            dataToParse = sc.nextLine().split(" ");
            pages = new int[dataToParse.length];

            for (int j = 0; j < booksNumber; j++) {
                pages[j] = Integer.valueOf(dataToParse[j]);
                totalPages += pages[j];
                if (pages[j] > longestBook) {
                    longestBook = pages[j];
                }
            }

            maxWorkloadLimit = whatIsMaximumPagesToBeDone(pages, scribers, longestBook, totalPages);
//            System.out.println("\n\nMoje parametry");
//            System.out.println("Ile książek " + pages.length + " ilość pisarzy " + scribers + " najdłuższa książka " + longestBook + " łącznie stron " + totalPages);
//            System.out.println("Max obciążenie robotą " + maxWorkloadLimit);

            sb2.setLength(0);
            for (int j = (int) booksNumber - 1; j >= 0; j--) {
                sb.setLength(0);
                tmpPagesDone = pages[j];
                sb.append(pages[j]);

                if (scribers == (j + 1)) {
                    while (j > 0) {
                        sb.insert(0, " / ");
                        sb.insert(0, pages[j - 1]);
                        tmpPagesDone += pages[j - 1];
                        j--;
                        scribers--;
                    }
                } else if (scribers > 1) {
                    while (j > 0 && tmpPagesDone + pages[j - 1] <= maxWorkloadLimit &&  (j + 1)>scribers) {
                        sb.insert(0, " ");
                        sb.insert(0, pages[j - 1]);
                        tmpPagesDone += pages[j - 1];
                        j--;
                    }
                    if (j != 0) {
                        sb.insert(0, " / ");
                    }
                } else {
                    while (j > 0) {
                        sb.insert(0, " ");
                        sb.insert(0, pages[j - 1]);
                        tmpPagesDone += pages[j - 1];
                        j--;
                    }

                }
                scribers--;

                sb2.insert(0, sb.toString());
            }

            out.println(sb2.toString());
            out.flush();
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

    public static long whatIsMaximumPagesToBeDone(int pages[], long scribers, int longestBook, long totalPages) {

        long howManyBooks = pages.length;
        long maxSingleWorkLoad = longestBook;
        long totalWorkLoad = totalPages;

        while (maxSingleWorkLoad < totalWorkLoad) {

            //long tmpTotalWorkdLoad = maxSingleWorkLoad + (totalWorkLoad - maxSingleWorkLoad) / 2;
            long tmpTotalWorkLoad = maxSingleWorkLoad;

            int tmpWorkers = 1;
            long tmpWorkLoad = 0;

            for (int i = 0; i < howManyBooks; i++) {
                if (tmpWorkLoad + pages[i] <= tmpTotalWorkLoad) {
                    tmpWorkLoad += pages[i];
                } else {
                    tmpWorkers++;
                    tmpWorkLoad = pages[i];
                }
            }

            if (tmpWorkers <= scribers) {
                totalWorkLoad = tmpTotalWorkLoad;
            } else {
                maxSingleWorkLoad = tmpTotalWorkLoad + 1;
            }

        }
        return maxSingleWorkLoad;
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