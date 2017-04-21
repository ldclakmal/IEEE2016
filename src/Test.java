//import java.util.Scanner;
//
///**
// * @author Chanaka
// * @date 21/10/2016
// */
//public class Test {
//
//    public static void main(String[] args) {
//        try {
//            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//            OutputStream out = new BufferedOutputStream(System.out);
//            String pw = reader.readLine();
//            int t = Integer.valueOf(reader.readLine());
//            String arr[][] = new String[t][4];
//            for (int i = 0; i < t; i++) {
//                arr[i] = reader.readLine().split(" ");
//            }
//
//            reader.close();
//
//            for (int i = 0; i < t; i++) {
//                String tmp[] = arr[i];
//                int type = Integer.parseInt(tmp[0]);
//                int a = Integer.parseInt(tmp[1]);
//                int b = Integer.parseInt(tmp[2]);
//                int c = 0;
//                int length = b - a + 1;
//                if (type != 3) {
//                    c = Integer.parseInt(tmp[3]);
//                }
//
//                String case1Part1 = pw.substring(a - 1, b);
//                String case1Part2 = pw.substring(c - 1, c - 1 + length);
//                String case2Part1 = pw.substring(0, a - 1);
//                String case2Part2 = pw.substring(b, pw.length());
//                switch (type) {
//                    case 1:
//                        if (case1Part1.equals(case1Part2))
//                            out.write("Y\n".getBytes());
//                        else
//                            out.write("N\n".getBytes());
//                        out.flush();
//                        break;
//                    case 2:
//                        pw = new StringBuilder(case1Part1).append(case1Part2).append(case2Part2).toString();
////                        pw = case2Part1 + case1Part2 + case2Part2;
//                        break;
//                    case 3:
////                        String subString = pw.substring(a - 1, b);
//                        char chars[] = case1Part1.toCharArray();
//                        for (int j = 0; j < chars.length; j++) {
//                            chars[j] = replaceChar(chars[j]);
//                        }
//                        case1Part1 = new String(chars);
//                        pw = new StringBuilder(case2Part1).append(case1Part1).append(case2Part2).toString();
////                        pw = case2Part1 + case1Part1 + case2Part2;
//                        break;
//                    default:
//                        break;
//                }
//            }
//
//        } catch (Exception e) {
//        }
//    }
//
//    public static char replaceChar(char value) {
//        if (value == 'z') {
//            return (char) 97;
//        }
//        return (char) ((int) value + 1);
//    }
//}
