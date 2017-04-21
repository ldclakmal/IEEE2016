import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Chanaka
 * @date 22/10/2016
 */
public class PaintersDilemma {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int k = 0; k < t; k++) {
            int paintCount = sc.nextInt() - 2;

            int p1 = sc.nextInt();
            int p2 = sc.nextInt();

            while (paintCount != 0) {
                if (p1 == p2) {
                    p2 = sc.nextInt();
                    paintCount--;
                } else {
                    break;
                }
            }

            ArrayList<Integer> arr = new ArrayList<>();
            for (int i = 0; i < paintCount; i++) {
                arr.add(sc.nextInt());
            }

            int count = 2;
            if (paintCount == 0 && p1 == p2) {
                count = 1;
            }

            for (int i = 0; i < arr.size(); i++) {
                String changeableBrush = getChangeableBrush(new ArrayList<>(arr.subList(i, arr.size())), p1, p2);
                if (changeableBrush != null) {
                    if (arr.get(i) != p1 && arr.get(i) != p2) {
                        switch (changeableBrush) {
                            case "p1":
                                p1 = arr.get(i);
                                count++;
                                break;
                            case "p2":
                                p2 = arr.get(i);
                                count++;
                                break;
                            default:
                                break;
                        }
                    }
                } else {
                    p1 = arr.get(i);
                    count++;
                }
            }

            System.out.println(count);
        }
    }


    public static String getChangeableBrush(ArrayList<Integer> arr, int p1, int p2) {
        for (int paint : arr) {
            if (paint == p1) {
                return "p2";
            } else if (paint == p2) {
                return "p1";
            }
        }
        return null;
    }
}
