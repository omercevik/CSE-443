package hw2.part1;

import java.util.Random;

/**
 * Version1 public class extends AbstractGA.
 */
public class Version1 extends AbstractGA
{
    /**
     * Version1 constructor for Roulette Wheel Selection.
     * @param populationSize Gets population size.
     * @param x1 Gets x1 array.
     * @param x2 Gets x2 array.
     */
    public Version1(int populationSize, double[] x1, double[] x2)
    {
        super(populationSize,x1,x2);
    }

    /**
     * Selection is selecting the Individual parents using Roulette Wheel Selection algorithm.
     * Firstly summing individuals fitness values and separating.
     * Secondly selecting two parents randomly.
     */
    @Override
    protected void selection()
    {
        double sumOfFitness = 0.0f;
        double max_fitness = population.getIndividuals(0).getFitness();

        for (Individual individual : population.getIndividuals())
            max_fitness = Math.max(individual.getFitness(), max_fitness);

        for (Individual individual : population.getIndividuals())
            sumOfFitness += (max_fitness - individual.getFitness());

        for (Individual individual : population.getIndividuals())
            individual.setFitness((max_fitness - individual.getFitness())/sumOfFitness);

        Random rn = new Random();
        int randomIndexForParent1 = Math.abs(rn.nextInt(population.getIndividuals().length));
        int randomIndexForParent2 = Math.abs(rn.nextInt(population.getIndividuals().length));

        while(randomIndexForParent1 == randomIndexForParent2)
            randomIndexForParent2 = Math.abs(rn.nextInt(population.getIndividuals().length));

        parent1 = population.getIndividuals(randomIndexForParent1);
        parent2 = population.getIndividuals(randomIndexForParent2);
    }

    /**
     * Crossing over is creating child Individual using parents' x1 and x2 values multiplying by 1/2.
     * And adds child into population of Individual array's last position.
     */
    @Override
    protected void crossover()
    {
        child = new Individual();
        child.setX1((parent1.getX1() + parent2.getX1())/2);
        child.setX2((parent1.getX2() + parent2.getX2())/2);
    }
}
