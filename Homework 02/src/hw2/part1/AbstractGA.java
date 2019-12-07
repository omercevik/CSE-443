package hw2.part1;

import org.jfree.data.xy.XYSeries;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Random;

/**
 * AbstractGA abstract class to compute genetic algorithm.
 */
abstract class AbstractGA
{
    Population population;
    Individual parent1;
    Individual parent2;
    Individual child;
    private int generationCount = 0;

    /**
     * AbstractGA constructor.
     * @param populationSize Gets population size to set.
     * @param x1 Gets x1 array to set x1s.
     * @param x2 Gets x2 array to set x2s.
     */
    AbstractGA(int populationSize, double[] x1, double[] x2)
    {
        this.population = new Population(populationSize);
        for (int i = 0; i < populationSize; ++i)
        {
            this.population.getIndividuals(i).setX1(x1[i]);
            this.population.getIndividuals(i).setX2(x2[i]);
        }
    }

    /**
     * Genetic Algorithm template method.
     */
    final void geneticAlgorithm()
    {
        computeFitness();

        while (populationConverge())
        {
            selection();

            crossover();

            mutation();

            computeFitness();

            ++generationCount;

            NumberFormat formatter = new DecimalFormat("#0.00");
            for (Individual individual : population.getIndividuals())
                System.out.println("x1 : [ " + formatter.format(individual.getX1())+" ]  " + " x2 : [ "+ formatter.format(individual.getX2())+" ]" + "   Fitness : " + formatter.format(individual.getFitness()));
            System.out.println();
            System.out.println("Generation value : [ " + generationCount + " ]");
            System.out.println();
        }
    }

    /**
     * Genetic algorithm template method.
     * @param version Gets version for GUI.
     */
    public void geneticAlgorithm(XYSeries version)
    {
        computeFitness();

        while (populationConverge())
        {
            selection();

            crossover();

            mutation();

            computeFitness();

            ++generationCount;

            double avrFitness = 0.0f;
            NumberFormat formatter = new DecimalFormat("#0.00");
            for (Individual individual : population.getIndividuals()) {
                avrFitness += individual.getFitness();
                System.out.println("x1 : [ " + formatter.format(individual.getX1())+" ]  " + " x2 : [ "+ formatter.format(individual.getX2())+" ]" + "   Fitness : " + formatter.format(individual.getFitness()));
            }
            avrFitness /= population.getIndividuals().length;
            System.out.println();
            version.add(generationCount,avrFitness);
            System.out.println("Generation value : [ " + generationCount + " ]");
            System.out.println();
        }
    }

    /**
     * Mutation to child x1 or x2 values and place it in individuals.
     */
    private void mutation()
    {
        Random rn = new Random();
        boolean randomSelectorMutation = rn.nextBoolean();
        if (randomSelectorMutation)
        {
            boolean randomSelectorX = rn.nextBoolean();
            child.setX1(child.getX1() + (randomSelectorX ? .02f : 0f));
            child.setX2(child.getX2() + (!randomSelectorX ? .02f : 0f));
        }
        for (int i = population.getIndividuals().length-1; i > 0; --i)
        {
            population.setIndividuals(i,population.getIndividuals(i-1));
        }
        population.setIndividuals(0, child);
    }

    /**
     * Computes fitness values of all individuals.
     */
    private void computeFitness()
    {
        for (Individual individual : population.getIndividuals())
            individual.computeFitness();
    }

    /**
     * Computes is population converged.
     * @return Returns if population has converged.
     */
    private boolean populationConverge()
    {
        double avr = 0.0f;
        for (Individual individual : population.getIndividuals()) {
            avr += individual.getFitness();
        }
        return avr/population.getIndividuals().length < 126;
    }

    /**
     * Selection for versions.
     */
    protected abstract void selection();

    /**
     * Crossover for versions.
     */
    protected abstract void crossover();
}