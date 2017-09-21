package pl.sda.javawwa.Kompresja;

import java.io.InputStream;
import java.util.*;

public class Main2 {

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        String testowy = sc.nextLine();

        Integer startLenght = testowy.length();

        Map<Integer, Set<String>> ciagiZnakowe = new TreeMap<>();
        Integer maxDlCiagu = 10;

        maxDlCiagu = (testowy.length() / 2 > maxDlCiagu) ? maxDlCiagu : testowy.length() / 2;

        for (int i = 3; i <= maxDlCiagu; i++) {
            ciagiZnakowe.put(i, new TreeSet<>());
        }

        for (Integer intTMp : ciagiZnakowe.keySet()) {
            for (int i = 1; i < testowy.length() - intTMp + 1; i++)
                ciagiZnakowe.get(intTMp).add(testowy.substring(i, i + intTMp));
        }

        for (int i = maxDlCiagu; i > 2; i--) {
            Set<String> tmpSet = ciagiZnakowe.get(i);
            for (String s : tmpSet) {
                if (testowy.contains(s + s)) {
                    testowy = testowy.replace(s + s, s + "+" + i);
                }
            }


        }

        Integer endLength = testowy.length();

        Double moc = 1.0 * endLength / startLenght;
        //     System.out.println(testowy);

        System.out.println(moc);

    }
}
