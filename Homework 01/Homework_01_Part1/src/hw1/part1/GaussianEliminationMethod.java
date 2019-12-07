package hw1.part1;

/**
 * GaussianEliminationMethod concrete class implements SolvingMethod interface.
 */
public class GaussianEliminationMethod implements SolvingMethod
{
    private final double EPSILON = 1e-10;

    /**
     * Copies A array.
     * @param A Gets double A[][].
     * @return Returns copy of A[][].
     */
    private double[][] copyOfA(double[][] A)
    {
        double[][] copy = new double[A.length][A.length];
        for (int i = 0; i < A.length; ++i) {
            System.arraycopy(A[i], 0, copy[i], 0, A[i].length);
        }
        return copy;
    }

    /**
     * Copies B array.
     * @param B Gets double B[].
     * @return Returns copy of B[].
     */
    private double[] copyOfB(double[] B)
    {
        double[] copy = new double[B.length];
        System.arraycopy(B, 0, copy, 0, B.length);
        return copy;
    }

    /**
     * Overrides SolvingMethod solve method.
     * @param OriginalA Gets double[][] A matrix.
     * @param OriginalB Gets double[] B array.
     * @return Returns solved double[] result for GaussianEliminationMethod.
     */
    @Override
    public double[] solve(double[][] OriginalA, double[] OriginalB)
    {
        int n = OriginalB.length;
        double[][] A = copyOfA(OriginalA);
        double[] B = copyOfB(OriginalB);

        for (int p = 0; p < n; ++p)
        {
            int max = p;
            for (int i = p + 1; i < n; ++i)
            {
                if (Math.abs(A[i][p]) > Math.abs(A[max][p]))
                {
                    max = i;
                }
            }

            double[] temp = A[p];
            A[p] = A[max];
            A[max] = temp;

            double t = B[p];
            B[p] = B[max];
            B[max] = t;

            if (Math.abs(A[p][p]) <= EPSILON)
            {
                throw new ArithmeticException("Matrix is singular or nearly singular");
            }

            for (int i = p + 1; i < n; ++i)
            {
                double alpha = A[i][p] / A[p][p];

                B[i] -= alpha * B[p];
                for (int j = p; j < n; ++j)
                {
                    A[i][j] -= alpha * A[p][j];
                }
            }
        }

        double[] x = new double[n];
        for (int i = n - 1; i >= 0; --i)
        {
            double sum = 0.0;
            for (int j = i + 1; j < n; ++j)
            {
                sum += A[i][j] * x[j];
            }
            x[i] = (B[i] - sum) / A[i][i];
        }

        System.out.println("Gaussian Elimination");
        return x;
    }
}
