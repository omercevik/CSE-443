package hw1.part1;

/**
 * SolvingMethod interface.
 */
public interface SolvingMethod
{
    /**
     * SolvingMethod solve method.
     * @param OriginalA Gets double[][] A matrix.
     * @param OriginalB Gets double[] B array.
     * @return Returns solved double[] result for method.
     */
    public double[] solve(double[][] OriginalA, double[] OriginalB);
}
