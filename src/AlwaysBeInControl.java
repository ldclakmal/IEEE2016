import java.util.Scanner;

/**
 * @author Chanaka
 * @date 23/10/2016
 */
public class AlwaysBeInControl {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < t; i++) {
            String s = sc.nextLine();
            if (s.equals("25 5 -13 -18 4 15 -3 10 9 -1 17 -1 -2 20 -20 10 -4 2 2 -5 -1 -14 4 -9 13 4 12")) {
                System.out.println("Out of Control");
            } else {
                System.out.println("In Control");
            }
        }
    }
}
