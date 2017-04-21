import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author Chanaka
 * @date 23/10/2016
 */
public class FindingShelter {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        String soldier[][] = new String[t][2];
        for (int i = 0; i < t; i++) {
            soldier[i] = sc.nextLine().split(" ");
        }
        String shelter[][] = new String[t][2];
        for (int i = 0; i < t; i++) {
            shelter[i] = sc.nextLine().split(" ");
        }

        ArrayList<Double> arrayList = new ArrayList<>();
        int indexArr[][] = new int[t][1];

        for (int i = 0; i < t; i++) {
            double soldierX = Double.parseDouble(soldier[i][0]);
            double soldierY = Double.parseDouble(soldier[i][1]);
            double min = Integer.MAX_VALUE;

            for (int j = 0; j < t; j++) {

                boolean bool = true;
                for (int k = 0; k < t; k++) {
                    if (indexArr[k][0] == j + 1) {
                        bool = false;
                    }
                }

                if (bool) {
                    double shelterX = Double.parseDouble(shelter[j][0]);
                    double shelterY = Double.parseDouble(shelter[j][1]);

                    double tmp = Math.sqrt(Math.pow(shelterY - soldierY, 2) + Math.pow(shelterX - soldierX, 2));
                    if (tmp < min) {
                        min = tmp;
                        indexArr[i][0] = j + 1;
                    }
                }
            }

            arrayList.add(min);
        }

        System.out.println(String.format("%.4f", Collections.max(arrayList)));

        double sum = 0;
        for (Double d : arrayList) {
            sum += d;
        }

        System.out.println(String.format("%.4f", sum));

    }
}
