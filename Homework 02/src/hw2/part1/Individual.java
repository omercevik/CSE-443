package hw2.part1;

/**
 * Individual public class to keep fitness, x1 and x2 values.
 */
public class Individual
{
    private double fitness;
    private double x1;
    private double x2;

    /**
     * Computes fitness values and set using f(x1,x2) method.
     */
    void computeFitness()
    {
        setFitness(f(x1,x2));
    }

    /**
     * Computes fitness value.
     * @param x1 Gets x1 value.
     * @param x2 Gets x2 value.
     * @return Returns fitness result.
     */
    private double f(double x1,double x2)
    {
        return 20*x1*x2 + 16*x2 - 2*x1*x1 - x2*x2 - (x1*x1 + 2*x1*x2 + x2*x2);
    }

    /**
     * Getter method for fitness.
     * @return Returns fitness.
     */
    public double getFitness(){
        return this.fitness;
    }

    /**
     * Setter method for fitness.
     * @param fitness Gets fitness to set.
     */
    public void setFitness(double fitness){
        this.fitness = fitness;
    }

    /**
     * Getter method for x1.
     * @return Returns x1.
     */
    public double getX1() {
        return x1;
    }

    /**
     * Setter method for x1.
     * @param x1 Gets x1 to set.
     */
    public void setX1(double x1) {
        this.x1 = x1;
    }

    /**
     * Getter method for x2.
     * @return Returns x2.
     */
    public double getX2() {
        return x2;
    }

    /**
     * Setter method for x2.
     * @param x2 Gets x2 to set.
     */
    public void setX2(double x2) {
        this.x2 = x2;
    }
}