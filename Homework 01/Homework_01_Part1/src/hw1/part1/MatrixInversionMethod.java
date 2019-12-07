package hw1.part1;

/**
 * MatrixInversionMethod concrete class implements SolvingMethod interface.
 */
public class MatrixInversionMethod implements SolvingMethod
{
    /**
     * Multiplies a matrix by a constant value.
     * @param mult The constant value.
     * @param matrix double[][] matrix to multiply.
     * @return Returns multiplied matrix.
     */
    private double[][] multiplyByConstant(double mult, double[][] matrix)
    {
        double[][] multiplicand = new double[matrix.length][matrix.length];

        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[i].length; ++j) {
                multiplicand[i][j] = matrix[i][j] * mult;
            }
        }
        return multiplicand;
    }

    /**
     * Used for change the sign of values while multiplication becomes.
     * @param i Gets index to change sign.
     * @return Returns changed sign.
     */
    private int changeSign(int i)
    {
        return i % 2 == 0 ? 1 : -1;
    }

    /**
     * Creates sub matrix.
     * @param matrix Gets complete matrix.
     * @param excluding_row Gets excluding row index.
     * @param excluding_col Gets excluding col index.
     * @return Returns sub matrix.
     */
    private double[][] createSubMatrix(double[][] matrix, int excluding_row, int excluding_col)
    {
        double[][] sub = new double[matrix.length-1][matrix.length-1];
        int r = -1;

        for (int i = 0; i < matrix.length; ++i) {
            if (i == excluding_row)
                continue;
            ++r;
            int c = -1;

            for (int j = 0;j < matrix.length; ++j) {
                if (j == excluding_col)
                    continue;
                sub[r][++c] = matrix[i][j];
            }
        }
        return sub;
    }

    /**
     * Creates transpose of matrix.
     * @param matrix Gets double[][] matrix to get transpose.
     * @return Returns transposed matrix.
     */
    private double[][] transpose(double[][] matrix)
    {
        double[][] transposedMatrix = new double[matrix.length][matrix.length];

        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[i].length; ++j) {
                transposedMatrix[j][i] = matrix[i][j];
            }
        }
        return transposedMatrix;
    }

    /**
     * Evaluates determinant of matrix.
     * @param matrix Gets double[][] matrix to get determinant.
     * @return Returns determinant of given matrix.
     */
    private double determinant(double[][] matrix)
    {
        if (matrix.length == 1) {
            return matrix[0][0];
        }
        else if (matrix.length == 2) {
            return (matrix[0][0] * matrix[1][1]) - (matrix[0][1] * matrix[1][0]);
        }
        double sum = 0.0;
        for (int i = 0; i < matrix.length; ++i) {
            sum += changeSign(i) * matrix[0][i] * determinant(createSubMatrix(matrix, 0, i));
        }
        return sum;
    }

    /**
     * Creates cofactor matrix of given matrix.
     * @param matrix Gets double[][] matrix to create cofactors.
     * @return Returns cofactor double[][] matrix.
     */
    private double[][] cofactorMatrix(double[][] matrix)
    {
        double[][] mat = new double[matrix.length][matrix.length];

        for (int i=0;i<matrix.length;i++) {
            for (int j=0; j<matrix[i].length;j++) {
                mat[i][j] = changeSign(i) * changeSign(j) * determinant(createSubMatrix(matrix, i, j));
            }
        }

        return mat;
    }

    /**
     * Creates inverse of given matrix.
     * @param matrix Gets double[][] matrix to create inverse of it.
     * @return Returns inverse of matrix.
     */
    private double[][] inverseMatrix(double[][] matrix)
    {
        return multiplyByConstant(1.0/determinant(matrix),transpose(cofactorMatrix(matrix)));
    }

    /**
     * Overrides SolvingMethod solve method.
     * @param OriginalA Gets double[][] A matrix.
     * @param OriginalB Gets double[] B array.
     * @return Returns solved double[] result for MatrixInversionMethod.
     */
    @Override
    public double[] solve(double[][] OriginalA, double[] OriginalB)
    {
        double[][] inversedMatrix = inverseMatrix(OriginalA);
        double[] result = new double[OriginalB.length];

        for (int i = 0; i < inversedMatrix.length; ++i)
        {
            double res = 0f;
            for (int j = 0; j < inversedMatrix[i].length; ++j)
            {
                res += inversedMatrix[i][j] * OriginalB[j];
            }
            result[i] = res;
        }

        System.out.println("Matrix Inversion");
        return result;
    }
}
