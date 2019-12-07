package hw1.part1;

/**
 * Solver concrete class.
 */
public class Solver
{
    SolvingMethod solvingMethod;

    /**
     * Solver constructor.
     * @param solvingMethod Gets SolvingMethod abstract object.
     */
    public Solver(SolvingMethod solvingMethod)
    {
        this.solvingMethod = solvingMethod;
    }

    /**
     * Setter for SolvingMethod.
     * @param solvingMethod Gets a SolvingMethod object to set.
     */
    public void setSolvingMethod(SolvingMethod solvingMethod)
    {
        System.out.println("Setter called in run time!\n");
        this.solvingMethod = solvingMethod;
    }

    /**
     * Solver methods to solve linear equations.
     * @param A Gets double[][] A matrix.
     * @param B Gets double[] B matrix.
     * @return Returns double[] result.
     */
    public double[] solve(double[][] A, double[] B)
    {
        return solvingMethod.solve(A,B);
    }
}
