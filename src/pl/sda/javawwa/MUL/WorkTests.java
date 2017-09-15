package pl.sda.javawwa.MUL;

public class WorkTests {

    public static void main(String[] args) {

//        System.out.println(6/2);
//        System.out.println(5/2);

        int wykladnik = 5;

        int[] testowo = {1, 12, 1234, 12345};
        String tmp;

        StringBuilder sb = new StringBuilder();


        for (int i = 3; i >= 0; i--) {
            sb.append("");
            sb.setLength(0);
            if (String.valueOf(testowo[i]).length() == wykladnik) {
                sb.append(testowo[i]);
            } else {

                int length = wykladnik-String.valueOf(testowo[i]).length();
                for (int j = 0; j < length; j++) {
                    sb.append("0");
                }
                sb.append(testowo[i]);
            }




            String printed = sb.toString();
            System.out.println(printed);
        }


    }
}
