package hw1.part1;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * CSE 443 Object Oriented Analysis and Design
 * Homework 01
 * Part 1
 * 161044004
 * @author Omer CEVIK
 */
public class Main
{
    /**
     * Reads A[][] double array from user console input.
     * @param in Gets Scanner input object.
     * @return Returns read A[][] double array.
     */
    private static double[][] readA(Scanner in)
    {
        int n;

        do {
            System.out.print("Enter the n x n size of matrix : ");
            n = in.nextInt();
        }while(n <= 0);

        double[][] A = new double[n][n];

        for (int i = 0; i < n; ++i)
        {
            System.out.println("Enter the " + (i+1) + ". row elements of A matrix :");
            for (int j = 0; j < n; ++j)
            {
                A[i][j] = in.nextDouble();
            }
        }

        System.out.println();
        System.out.println("A matrix is :");
        for (double[] arrayA : A) {
            for (double a : arrayA) {
                System.out.print(a + " ");
            }
            System.out.println();
        }
        System.out.println();
        return A;
    }

    /**
     * Reads B[] double array from user console input.
     * @param in Gets Scanner input object.
     * @return Returns read B[] double array.
     */
    private static double[] readB(Scanner in, int n)
    {
        double[] B = new double[n];
        System.out.println("Enter the column elements of B matrix :");

        for (int i = 0; i < n; ++i)
        {
            B[i] = in.nextDouble();
        }

        System.out.println();
        System.out.println("B matrix is :");
        for (double b : B)
        {
            System.out.println(b);
        }
        System.out.println();

        return B;
    }

    /**
     * Prints linear equations results.
     * @param result Gets result double array.
     */
    private static void printResults(double[] result)
    {
        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println("Results are :");
        for (int i = 0; i < result.length; ++i)
        {
            System.out.println("x"+(i+1) + " = " + df.format(result[i]));
        }
        System.out.println();
    }

    /**
     * Driver method main.
     * @param args No args.
     */
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        double[][] A = readA(in);
        double[] B = readB(in,A.length);
        in.close();

        Solver solver = new Solver(new GaussianEliminationMethod());

        double[] resultGE = solver.solve(A,B);
        printResults(resultGE);

        solver.setSolvingMethod(new MatrixInversionMethod());
        double[] resultMI = solver.solve(A,B);
        printResults(resultMI);

    }
}
