import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Chanaka
 * @date 22/10/2016
 */
public class UnreliableFriend {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        String s = sc.nextLine();
        int que = Integer.parseInt(s.split(" ")[0]);
        int lie = Integer.parseInt(s.split(" ")[1]);
        int countR = 0;
        int countG = 0;
        int countB = 0;

        int mat[][] = new int[10][3];

        ArrayList<String> questionList = new ArrayList<>();
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for (int i = 0; i < que; i++) {
            questionList.add(sc.nextLine());
        }

        for (String question : questionList) {
            if (question.contains(" and ")) {
                map.put(question, new ArrayList<>(Arrays.asList(question.split(" and "))));
            }
            if (question.contains(" or ")) {
                map.put(question, new ArrayList<>(Arrays.asList(question.split(" or "))));
            }
        }

        // check lie
//        for (String question : questionList) {
//            if (!map.containsKey(question)) {
//                if (question.startsWith("count")) {
//
//                }
//            }
//        }

        if (lie == 0) {
            for (String question : questionList) {
                if (!map.containsKey(question)) {
                    if (question.startsWith("color")) {
                        mat = writeMatrix(mat, question);
                    }
                } else {
                    ArrayList<String> list = map.get(question);
                    for (String q : list) {
                        if (q.startsWith("color")) {
                            mat = writeMatrix(mat, q);
                        }
                    }
                }
            }
        }

        printMatrix(mat);
    }

    private static int[][] writeMatrix(int mat[][], String question) {
        String arr[] = question.split(" ");
        int ball = Integer.parseInt(arr[1]) - 1;
        int color = getIntOfColor(arr[2]);
        mat[ball][color] = 1;
        return mat;
    }

    private static void printMatrix(int mat[][]) {
        for (int arr[] : mat) {
            for (int i : arr) {
                System.out.print(i);
            }
            System.out.println();
        }
    }

    private static void printSubList(HashMap<String, ArrayList<String>> map, String question) {
        for (String s : map.get(question)) {
            System.out.println(s);
        }
    }

    private static int getIntOfColor(String color) {
        switch (color) {
            case "r":
                return 0;
            case "g":
                return 1;
            case "b":
                return 2;
            default:
                return -1;
        }
    }
}
