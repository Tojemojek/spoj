package pl.sda.javawwa.FCTRL2;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int howMany = sc.nextInt();
        Map<Integer, Long> silnie = new TreeMap<>();
        int tmp;

        silnie.put(0, 1L);
        silnie.put(1, 1L);

        for (int j = 2; j <= 100; j++) {
            silnie.put(j, j * silnie.get(j - 1));
            System.out.println(j+ " " + silnie.get(j - 1));
        }

        for (int i = 0; i < howMany; i++) {
            tmp = sc.nextInt();

            System.out.println(silnie.get(tmp));
        }
    }
}
