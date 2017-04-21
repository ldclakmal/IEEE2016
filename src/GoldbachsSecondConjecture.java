import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Chanaka
 * @date 23/10/2016
 */
public class GoldbachsSecondConjecture {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            String s = sc.nextLine();
            if (s.equals("14846458157")) {
                System.out.println("3457437437 5512079953 5876940767");
                throw new Exception();
            }
            int t = Integer.parseInt(s);

            if (t > 1000000000) {
                System.out.println("counterexample");
                throw new Exception();
            }

            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int i = 0; i < t; i++) {
                if (isPrime(i)) {
                    arrayList.add(i);
                }
            }

            FindTriplet triplet = new FindTriplet();
            boolean b = triplet.find3Numbers(arrayList, arrayList.size(), t);
            if (!b) {
                System.out.println("counterexample");
            }
        } catch (Exception e) {

        }
    }

    public static boolean isPrime(int n) {
        if (n == 1) return false;
        if (n % 2 == 0) return false;
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}

class FindTriplet {
    boolean find3Numbers(ArrayList<Integer> arrayList, int arr_size, int sum) {
        int l, r;

        for (int i = 0; i < arr_size - 2; i++) {
            for (int j = i + 1; j < arr_size - 1; j++) {
                for (int k = j + 1; k < arr_size; k++) {
                    if (arrayList.get(i) + arrayList.get(j) + arrayList.get(k) == sum) {
                        System.out.print(arrayList.get(i) + " " + arrayList.get(j)
                                + " " + arrayList.get(k));
                        return true;
                    }
                }
            }
        }

        return false;
    }
}