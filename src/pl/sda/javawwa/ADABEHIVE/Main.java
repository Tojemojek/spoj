package pl.sda.javawwa.ADABEHIVE;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();

        int nHowManyRows;
        int mHowManyColumns;
        int qHowManyQueries;


        nHowManyRows = sc.nextInt();
        mHowManyColumns = sc.nextInt();
        qHowManyQueries = sc.nextInt();

        int[][] howManyBees = new int[nHowManyRows][mHowManyColumns];

        for (int i = 0; i < nHowManyRows; i++) {
            for (int j = 0; j < mHowManyColumns; j++) {
                howManyBees[i][j] = sc.nextInt();
            }
        }

        int licznik = 0;
        int tmp, rTmp, cTmp, tmpNumber;
        int tmpRowStart, tmpRowEnd, tmpLineStart, tmpLineEnd;
        int tmpSum;

        for (int k = 0; k < qHowManyQueries; k++) {
            tmp = sc.nextInt(); // to trzeba inaczej rozwiązać!!!

            if (tmp == 1) {
                rTmp = sc.nextInt() - 1;
                cTmp = sc.nextInt() - 1;
                tmpNumber = sc.nextInt();
                howManyBees[rTmp][cTmp] = howManyBees[rTmp][cTmp] + tmpNumber;
            } else {
                tmpSum = 0;
                tmpRowStart = sc.nextInt();
                tmpLineStart = sc.nextInt();
                tmpRowEnd = sc.nextInt();
                tmpLineEnd = sc.nextInt();

                for (int i = tmpRowStart - 1; i < tmpRowEnd; i++) {
                    for (int j = tmpLineStart - 1; j < tmpLineEnd; j++) {
                        tmpSum += howManyBees[i][j];
                    }
                }
                System.out.println(tmpSum);
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
    //--------------------------------------------------------
}