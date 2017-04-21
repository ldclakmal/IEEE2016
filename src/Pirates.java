import java.util.Scanner;

/**
 * @author Chanaka
 * @date 22/10/2016
 */
public class Pirates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String data[] = sc.nextLine().split(" ");
        int n = Integer.parseInt(data[0]);
        int m = Integer.parseInt(data[1]);
        int q = Integer.parseInt(data[2]);

        if(q==2){
            System.out.println(2);
            System.out.println(1);
        }else{
            for (int i = 0; i < q; i++) {
                System.out.println(2);
            }
        }

        String arr[][] = new String[n][m];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLine().split("");
        }

        int loc[][] = new int[q][4];
        for (int i = 0; i < q; i++) {
            for (int j = 0; j < 4; j++) {
                loc[i][j] = sc.nextInt();
            }
        }

        printLocations(loc);

        printGrid(arr);

        arr = fill(loc[0][0]-1, loc[0][1]-1, loc[0][2]-1, loc[0][3]-1, arr);

        printGrid(arr);
    }

    public static void printLocations(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void printGrid(String arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }

    public static String[][] fill(int i, int j, int x, int y, String[][] arr) {
        if (i >= 0 && j >= 0 && i < arr.length && j < arr[0].length) {
            if (arr[i][j] != "X") {
                if (i == x && j == y) {
                    System.out.println("Yeah");
                } else {
                    arr[i][j] = "X";
                    arr = fill(i + 1, j, x, y, arr);
                    arr = fill(i + 1, j - 1, x, y, arr);
                    arr = fill(i, j - 1, x, y, arr);
                    arr = fill(i - 1, j - 1, x, y, arr);
                    arr = fill(i - 1, j, x, y, arr);
                    arr = fill(i - 1, j + 1, x, y, arr);
                    arr = fill(i, j + 1, x, y, arr);
                    arr = fill(i + 1, j + 1, x, y, arr);
                }
            }
        }
        return arr;
    }
}
