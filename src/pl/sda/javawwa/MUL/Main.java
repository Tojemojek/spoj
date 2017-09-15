package pl.sda.javawwa.MUL;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static final int substringLenght = 5;

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

        Integer test1ArrLength, test2ArrLength;

        test1ArrLength = (test1.length() % substringLenght == 0) ?
                test1.length() / substringLenght : test1.length() / substringLenght + 1;

        test2ArrLength = (test2.length() % substringLenght == 0) ?
                test2.length() / substringLenght : test2.length() / substringLenght + 1;


        int maxLength = test1ArrLength + test2ArrLength;

        long[] test1Long = new long[test1ArrLength];
        long[] test2Long = new long[test2ArrLength];
        long[] result = new long[maxLength];


        int od, azDo;


        azDo = test1.length();

        for (int i = test1ArrLength - 1; i >= 0; i--) {

            od = azDo - substringLenght;

            if (od < 0) {
                od = 0;
            }
            test1Long[i] = Long.valueOf(test1.substring(od, azDo));

            azDo -= substringLenght;

        }

        azDo = test2.length();

        for (int i = test2ArrLength - 1; i >= 0; i--) {

            od = azDo - substringLenght;

            if (od < 0) {
                od = 0;
            }
            test2Long[i] = Long.valueOf(test2.substring(od, azDo));

            azDo -= substringLenght;

        }


        int pos1, pos2 = 0;

        for (int i = test1ArrLength - 1; i >= 0; i--) {
            pos1 = test1ArrLength - 1 - i;
            for (int j = test2ArrLength - 1; j >= 0; j--) {
                pos2 = test2ArrLength - 1 - j;
                result[pos1 + pos2] += test1Long[i] * test2Long[j];
            }
        }

        for (int i = 0; i < maxLength - 1; i++) {
            result[i + 1] = result[i + 1] + result[i] / (long) Math.pow(10, substringLenght);
            result[i] = result[i] % (long) Math.pow(10, substringLenght);

        }


        StringBuilder sb = new StringBuilder();
        sb.append("");


        for (int i = result.length - 1; i >= 0; i--) {
            if (String.valueOf(result[i]).length() == substringLenght) {
                sb.append(result[i]);
            } else {
                int length = substringLenght - String.valueOf(result[i]).length();
                for (int j = 0; j < length; j++) {
                    sb.append("0");
                }
                sb.append(result[i]);
            }
        }

        String printed = sb.toString();

        while (printed.substring(0, 1).equals("0") && printed.length() > 1) {
            printed = printed.substring(1);
        }

        out.println(printed);
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