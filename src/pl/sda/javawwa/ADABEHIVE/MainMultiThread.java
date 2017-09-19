package pl.sda.javawwa.ADABEHIVE;

import java.io.*;
import java.util.*;

import static java.lang.Thread.State.TERMINATED;

public class MainMultiThread {
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));

        int nHowManyRows;
        int mHowManyColumns;
        int qHowManyQueries;

        nHowManyRows = sc.nextInt();
        mHowManyColumns = sc.nextInt();
        qHowManyQueries = sc.nextInt();


        long[][] howManyBees = new long[nHowManyRows][mHowManyColumns];

        String tmpData[];

        for (int i = 0; i < nHowManyRows; i++) {
            tmpData = sc.nextLine().split(" ");
            for (int j = 0; j < mHowManyColumns; j++) {
                howManyBees[i][j] = Integer.valueOf(tmpData[j]);
            }
        }

        int tmp, rTmp, cTmp, tmpNumber;
        int tmpRowStart, tmpRowEnd, tmpLineStart, tmpLineEnd;
        int tmpRowStart1, tmpRowEnd1, tmpLineStart1, tmpLineEnd1;
        int tmpRowStart2, tmpRowEnd2, tmpLineStart2, tmpLineEnd2;

        long tmpSum;

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

                tmpRowEnd1 = (Integer.parseInt(tmpData[1]) - 1 + Integer.parseInt(tmpData[3])) / 2+1;
                tmpLineEnd1 = (Integer.parseInt(tmpData[2]) - 1 + Integer.parseInt(tmpData[4])) / 2;

                tmpRowStart2 = tmpRowEnd1;
                tmpLineStart2 = tmpLineEnd1 + 1;

                MyThreadRunnable mt1 = new MyThreadRunnable(tmpRowStart,tmpRowEnd1,tmpLineStart,tmpLineEnd, howManyBees, "cz1" );
                MyThreadRunnable mt2 = new MyThreadRunnable(tmpRowStart2,tmpRowEnd,tmpLineStart,tmpLineEnd, howManyBees, "cz2" );


                Thread th = new Thread(mt1);
                Thread th2 = new Thread(mt2);

                th.start();
                th2.start();

//                for (int i = tmpRowStart; i < (tmpRowEnd1); i++) {
//                    for (int j = tmpLineStart; j < tmpLineEnd; j++) {
//                        tmpSum1 += howManyBees[i][j];
//                    }
//                }

//                for (int i = tmpRowStart2; i < (tmpRowEnd); i++) {
//                    for (int j = tmpLineStart; j < tmpLineEnd; j++) {
//                        tmpSum2 += howManyBees[i][j];
//                    }
//                }

                while (th.getState()!=TERMINATED || th2.getState()!=TERMINATED){
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                tmpSum = mt1.getTmpsum1() + mt2.getTmpsum1();

                out.println(tmpSum);

            }
        }
        out.close();
    }

    public static class MyThreadRunnable implements Runnable {

        private int startRow;
        private int stopRow;
        private int startLine;
        private int stopLine;
        private long tmpsum1;
        private long[][] howManyBees;
        private String name;

        public MyThreadRunnable(int startRow, int stopRow, int startLine, int stopLine, long[][] howManyBees, String name) {
            this.startRow = startRow;
            this.stopRow = stopRow;
            this.startLine = startLine;
            this.stopLine = stopLine;
            this.howManyBees = howManyBees;
            this.name = name;
        }

        @Override
        public void run() {
            for (int i = startRow; i < (stopRow); i++) {
                for (int j = startLine; j < stopLine; j++) {
                    tmpsum1 += howManyBees[i][j];
                }
            }
        }

        public long getTmpsum1() {
            return tmpsum1;
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




