package pl.sda.javawwa.MUL;

import java.io.*;
import java.util.StringTokenizer;


//PRAWIE DZIAŁA
public class Main {

    static final int substringLenght = 2;

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

        int[] test1Int = new int[test1ArrLength];
        int[] test2Int = new int[test2ArrLength];
        int[] result = new int[maxLength];


        int od, azDo;


        azDo = test1.length();

        for (int i = test1ArrLength - 1; i >= 0; i--) {

            od = azDo - substringLenght;

            if (od < 0) {
                od = 0;
            }
            test1Int[i] = Integer.valueOf(test1.substring(od, azDo));

            azDo -= substringLenght;

        }

        azDo = test2.length();

        for (int i = test2ArrLength - 1; i >= 0; i--) {

            od = azDo - substringLenght;

            if (od < 0) {
                od = 0;
            }
            test2Int[i] = Integer.valueOf(test2.substring(od, azDo));

            azDo -= substringLenght;

        }


        int pos1, pos2 = 0;

        for (int i = test1ArrLength - 1; i >= 0; i--) {
            pos1 = test1ArrLength - 1 - i;
            for (int j = test2ArrLength - 1; j >= 0; j--) {
                pos2 = test2ArrLength - 1 - j;
                result[pos1 + pos2] += test1Int[i] * test2Int[j];
            }
        }

        for (int i = 0; i < maxLength - 1; i++) {
            result[i + 1] = result[i + 1] + result[i] / (int) Math.pow(10, substringLenght);
            result[i] = result[i] % (int) Math.pow(10, substringLenght);

        }

        StringBuilder sb = new StringBuilder();
        sb.append("");

        for (int i = result.length - 1; i >= 0; i--) {
// DRUKUJE ZA DUŻO ZER NA POCZĄTKU!!!
            if (i == 0) {
                if (result[0] == 0) {
                } else {
                    sb.append(result[i]);
                }
            } else if (i == 1 && result[0] == 0) {

            } else if (i == 1 && result[0] == 0 && String.valueOf(result[1]).length() == 1) {
                sb.append(result[i]);
            } else if (String.valueOf(result[i]).length() == 1) {
                sb.append("0" + result[i]);
            } else {
                sb.append(result[i]);
            }
        }

        out.println(sb.toString());
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