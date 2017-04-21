import java.util.Scanner;

/**
 * @author Chanaka
 * @date 22/10/2016
 */
public class CountingMolecules {

    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            double c = sc.nextDouble();
            double h = sc.nextDouble();
            double o = sc.nextDouble();

            char[] var = {'x', 'y', 'z', 'w'};
            Scanner input = new Scanner(System.in);
            int n = 3;
            double[][] mat = new double[][]{{0, 1, 6}, {2, 0, 12}, {1, 2, 6}};
            double[][] constants = new double[][]{{c}, {h}, {o}};

            double inverted_mat[][] = invert(mat);

            double result[][] = new double[n][1];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 1; j++) {
                    for (int k = 0; k < n; k++) {
                        result[i][j] = result[i][j] + inverted_mat[i][k] * constants[k][j];
                    }
                }
            }

            Double d = new Double(result[0][0]);
            int H2O = d.intValue();
            if (d - H2O > 0) {
                throw new Exception();
            }
            d = new Double(result[1][0]);
            int CO2 = d.intValue();
            if (d - CO2 > 0) {
                throw new Exception();
            }
            d = new Double(result[2][0]);
            int C6H12O6 = d.intValue();
            if (d - C6H12O6 > 0) {
                throw new Exception();
            }

            if (H2O < 0 || CO2 < 0 || C6H12O6 < 0) {
                System.out.println("Error");
            } else {
                System.out.println(H2O + " " + CO2 + " " + C6H12O6);
            }

        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    public static double[][] invert(double a[][]) {
        int n = a.length;
        double x[][] = new double[n][n];
        double b[][] = new double[n][n];
        int index[] = new int[n];
        for (int i = 0; i < n; ++i)
            b[i][i] = 1;

        gaussian(a, index);

        for (int i = 0; i < n - 1; ++i)
            for (int j = i + 1; j < n; ++j)
                for (int k = 0; k < n; ++k)
                    b[index[j]][k]
                            -= a[index[j]][i] * b[index[i]][k];

        for (int i = 0; i < n; ++i) {
            x[n - 1][i] = b[index[n - 1]][i] / a[index[n - 1]][n - 1];
            for (int j = n - 2; j >= 0; --j) {
                x[j][i] = b[index[j]][i];
                for (int k = j + 1; k < n; ++k) {
                    x[j][i] -= a[index[j]][k] * x[k][i];
                }
                x[j][i] /= a[index[j]][j];
            }
        }
        return x;
    }

    public static void gaussian(double a[][], int index[]) {
        int n = index.length;
        double c[] = new double[n];

        for (int i = 0; i < n; ++i)
            index[i] = i;

        for (int i = 0; i < n; ++i) {
            double c1 = 0;
            for (int j = 0; j < n; ++j) {
                double c0 = Math.abs(a[i][j]);
                if (c0 > c1) c1 = c0;
            }
            c[i] = c1;
        }

        int k = 0;
        for (int j = 0; j < n - 1; ++j) {
            double pi1 = 0;
            for (int i = j; i < n; ++i) {
                double pi0 = Math.abs(a[index[i]][j]);
                pi0 /= c[index[i]];
                if (pi0 > pi1) {
                    pi1 = pi0;
                    k = i;
                }
            }

            int itmp = index[j];
            index[j] = index[k];
            index[k] = itmp;
            for (int i = j + 1; i < n; ++i) {
                double pj = a[index[i]][j] / a[index[j]][j];

                a[index[i]][j] = pj;

                for (int l = j + 1; l < n; ++l)
                    a[index[i]][l] -= pj * a[index[j]][l];
            }
        }
    }
}
