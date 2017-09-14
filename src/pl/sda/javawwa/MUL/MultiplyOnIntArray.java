package pl.sda.javawwa.MUL;

public class MultiplyOnIntArray {

    public static void main(String[] args) {


        String test1 = "333";
        String test2 = "9999";

        int maxLength = test1.length() + test2.length()-1;

        char[] test1Char = test1.toCharArray();
        int[] test1Int = new int[test1.length()];
        char[] test2Char = test2.toCharArray();
        int[] test2Int = new int[test2.length()];
        int[] result = new int[maxLength];


        for (int i = 0; i < test1.length(); i++) {
            test1Int[i] = Integer.parseInt((String.valueOf(test1Char[i])));
        }
        for (int i = 0; i < test2.length(); i++) {
            test2Int[i] = Integer.parseInt((String.valueOf(test2Char[i])));
        }

        int pos1, pos2 = 0;

        for (int i = (test1.length() - 1); i >= 0; i--) {
            pos1 = test1.length() - 1 - i;
            for (int j = (test2.length() - 1); j >= 0; j--) {
                pos2 = (test2.length() - 1) - j;
                result[pos1 + pos2] += test1Int[i] * test2Int[j];
            }
        }

        for (int i = 0; i < result.length-1; i++) {
            result[i + 1] = result[i + 1] + result[i] / 10;
            result[i] = result[i] % 10;

        }
        for (int i = result.length-1; i >=0 ; i--) {
            System.out.print(result[i]);

        }


    }




}
