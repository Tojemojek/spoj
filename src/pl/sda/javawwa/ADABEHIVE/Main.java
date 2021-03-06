package pl.sda.javawwa.ADABEHIVE;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));

        int nHowManyRows;
        int mHowManyColumns;
        int qHowManyQueries;

        nHowManyRows = sc.nextInt();
        mHowManyColumns = sc.nextInt();
        qHowManyQueries = sc.nextInt();


        int[][] howManyBees = new int[nHowManyRows][mHowManyColumns];

        String tmpData[];

        for (int i = 0; i < nHowManyRows; i++) {
            tmpData = sc.nextLine().split(" ");
            for (int j = 0; j < mHowManyColumns; j++) {
                howManyBees[i][j] = Integer.valueOf(tmpData[j]);
            }
        }

        int tmp, rTmp, cTmp, tmpNumber;
        int tmpRowStart, tmpRowEnd, tmpLineStart, tmpLineEnd;
        int tmpSum;

        for (int k = 0; k < qHowManyQueries; k++) {
            tmpData = sc.nextLine().split(" ");

            tmp = Integer.parseInt(tmpData[0]);

            if (tmp == 1) {
                rTmp = Integer.parseInt(tmpData[1]) - 1;
                cTmp = Integer.parseInt(tmpData[2]) - 1;
                tmpNumber = Integer.parseInt(tmpData[3]);
                howManyBees[rTmp][cTmp] = howManyBees[rTmp][cTmp] + tmpNumber;
            } else {
                tmpSum = 0;

                tmpRowStart = Integer.parseInt(tmpData[1]) - 1;
                tmpLineStart = Integer.parseInt(tmpData[2]) - 1;
                tmpRowEnd = Integer.parseInt(tmpData[3]);
                tmpLineEnd = Integer.parseInt(tmpData[4]);

                for (int i = tmpRowStart; i < (tmpRowEnd); i++) {
                    for (int j = tmpLineStart; j < tmpLineEnd; j++) {
                        tmpSum += howManyBees[i][j];
                    }
                }

                out.println(tmpSum);

            }
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
//--------------------------------------------------------


}

