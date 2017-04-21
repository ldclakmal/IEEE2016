import java.util.Scanner;

/**
 * @author Chanaka
 * @date 22/10/2016
 */
public class FlowerGames {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int k : arr) {
            if (k != 1) {
                double d = Math.pow(2, Math.floor(Math.log(k)/Math.log(2)));
                System.out.println((int) (k - d) * 2 + 1);
            } else {
                System.out.println("1");
            }
        }
    }
}
