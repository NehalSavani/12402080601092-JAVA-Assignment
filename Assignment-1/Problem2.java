import java.util.*;

class Matrix {
    int a[][];
    int r, c;

    Matrix(int r, int c) {
        this.r = r;
        this.c = c;
        a = new int[r][c];
    }

    void input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter elements:");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                a[i][j] = sc.nextInt();
            }
        }
    }

    void display() {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    void transpose() {
        System.out.println("Transpose:");
        for (int i = 0; i < c; i++) {
            for (int j = 0; j < r; j++) {
                System.out.print(a[j][i] + " ");
            }
            System.out.println();
        }
    }

    static Matrix multiply(Matrix m1, Matrix m2) {
        Matrix result = new Matrix(m1.r, m2.c);

        for (int i = 0; i < m1.r; i++) {
            for (int j = 0; j < m2.c; j++) {
                result.a[i][j] = 0;
                for (int k = 0; k < m1.c; k++) {
                    result.a[i][j] += m1.a[i][k] * m2.a[k][j];
                }
            }
        }
        return result;
    }

    public int[][] getA() {
        return a;
    }

    public int getR() {
        return r;
    }

    public int getC() {
        return c;
    }
}

public class Problem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter rows and columns of Matrix 1: ");
        int r1 = sc.nextInt();
        int c1 = sc.nextInt();

        Matrix m1 = new Matrix(r1, c1);
        m1.input();

        System.out.print("Enter rows and columns of Matrix 2: ");
        int r2 = sc.nextInt();
        int c2 = sc.nextInt();

        Matrix m2 = new Matrix(r2, c2);
        m2.input();

        System.out.println("Matrix 1:");
        m1.display();

        System.out.println("Matrix 2:");
        m2.display();

        if (c1 == r2) {
            Matrix result = Matrix.multiply(m1, m2);
            System.out.println("Multiplication Result:");
            result.display();
        } else {
            System.out.println("Matrix multiplication not possible.");
        }

        System.out.println("Transpose of Matrix 1:");
        m1.transpose();
    }
}