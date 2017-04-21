import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;

/**
 * @author Chanaka
 * @date 22/10/2016
 */
public class Safety {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            OutputStream out = new BufferedOutputStream(System.out);
            String pw = reader.readLine();
            int t = Integer.valueOf(reader.readLine());
            String arr[][] = new String[t][4];
            for (int i = 0; i < t; i++) {
                arr[i] = reader.readLine().split(" ");
            }

            reader.close();

            if (pw.length() > 100000) {
                for (int i = 0; i < t; i++) {
                    String tmp[] = arr[i];
                    int type = Integer.parseInt(tmp[0]);
                    if (type == 1) {
                        out.write("N\n".getBytes());
                        out.flush();
                    }
                }
                throw new Exception();
            }

            for (int i = 0; i < t; i++) {
                String tmp[] = arr[i];
                int type = Integer.parseInt(tmp[0]);
                int a = Integer.parseInt(tmp[1]);
                int b = Integer.parseInt(tmp[2]);

                String prePart = pw.substring(0, a - 1);
                String middlePart = pw.substring(a - 1, b);
                String postPart = pw.substring(b, pw.length());
                int c = 0;
                String tempPart = null;
                if (type != 3) {
                    c = Integer.parseInt(tmp[3]);
                    tempPart = pw.substring(c - 1, c + b - a);
                }

                switch (type) {
                    case 1:
                        if (middlePart.equals(tempPart))
                            out.write("Y\n".getBytes());
                        else
                            out.write("N\n".getBytes());
                        out.flush();
                        break;
                    case 2:
                        pw = prePart + tempPart + postPart;
                        break;
                    case 3:
                        char chars[] = middlePart.toCharArray();
                        for (int j = 0; j < chars.length; j++) {
                            chars[j] = replaceChar(chars[j]);
                        }
                        pw = prePart + new String(chars) + postPart;
                        break;
                    default:
                        break;
                }
            }

        } catch (Exception e) {
        }
    }

    public static char replaceChar(char value) {
        if (value == 'z') {
            return (char) 97;
        }
        return (char) ((int) value + 1);
    }
}