import java.util.Scanner;

/**
 * @author Chanaka
 * @date 22/10/2016
 */
public class MysteriousMaze {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int grid[][] = new int[n][n];
        writeGrid(grid);

        String s = sc.nextLine();
        while (!s.equals("-1")) {
            String arr[] = s.split(" ");
            int x = Integer.parseInt(arr[0]) - 1;
            int y = Integer.parseInt(arr[1]) - 1;

            grid[x][y] = 0;

            boolean flag = false;
            for (int i = 0; i < arr.length; i++) {
                if (grid[0][i] == 0) {
                    flag = true;
                }
            }

            if (flag) {
                System.out.println(check(grid, 0, 0));
            }

            printGrid(grid);

            s = sc.nextLine();
        }
    }

    public static boolean check(int arr[][], int x, int y) {
        if (x >= 0 && x < arr.length && y >= 0 && y < arr.length) {
            if (arr[x][y] == 1 || arr[x][y] == 2) {
                return false;
            } else if (y == arr.length - 1 && (arr[x][y] == 0 || arr[x][y] == 2)) {
                return true;
            } else {
                arr[x][y] = 2;
                return check(arr, x, y - 1) ||
                        check(arr, x - 1, y) ||
                        check(arr, x + 1, y) ||
                        check(arr, x, y + 1);
            }
        }
        return false;
    }


    public static void writeGrid(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = 1;
            }
        }
    }

    public static void printGrid(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
}
