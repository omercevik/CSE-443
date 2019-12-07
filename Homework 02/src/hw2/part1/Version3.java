package hw2.part1;

import java.util.Random;

/**
 * Version3 public class extends AbstractGA.
 */
public class Version3 extends AbstractGA
{
    /**
     * Version3 constructor for Tournament Selection.
     * @param populationSize Gets population size.
     * @param x1 Gets x1 array.
     * @param x2 Gets x2 array.
     */
    public Version3(int populationSize, double[] x1, double[] x2)
    {
        super(populationSize,x1,x2);
    }

    /**
     * Selection is selecting the Individual parents using Tournament Selection algorithm.
     * Firstly there is a tournament to choose 3 individuals.
     * Secondly there s a tournament to choose parent1 and parent2 between 3 individuals as maxes.
     */
    @Override
    protected void selection()
    {
        Random rn = new Random();

        int[] racerIndexes = new int[3];

        racerIndexes[0] = Math.abs(rn.nextInt(population.getIndividuals().length));
        racerIndexes[1] = Math.abs(rn.nextInt(population.getIndividuals().length));
        racerIndexes[2] = Math.abs(rn.nextInt(population.getIndividuals().length));

        while(racerIndexes[0] == racerIndexes[1])
            racerIndexes[1] = Math.abs(rn.nextInt(population.getIndividuals().length));

        while(racerIndexes[1] == racerIndexes[2] || racerIndexes[0] == racerIndexes[2])
            racerIndexes[2] = Math.abs(rn.nextInt(population.getIndividuals().length));

        if (population.getIndividuals(racerIndexes[0]).getFitness() < population.getIndividuals(racerIndexes[1]).getFitness() &&
                population.getIndividuals(racerIndexes[1]).getFitness() < population.getIndividuals(racerIndexes[2]).getFitness())
        {
            parent1 = population.getIndividuals(2);
            parent2 = population.getIndividuals(1);
        }
        else if (population.getIndividuals(racerIndexes[0]).getFitness() < population.getIndividuals(racerIndexes[2]).getFitness() &&
                population.getIndividuals(racerIndexes[2]).getFitness() < population.getIndividuals(racerIndexes[1]).getFitness())
        {
            parent1 = population.getIndividuals(1);
            parent2 = population.getIndividuals(2);
        }
        else if (population.getIndividuals(racerIndexes[1]).getFitness() < population.getIndividuals(racerIndexes[0]).getFitness() &&
                population.getIndividuals(racerIndexes[0]).getFitness() < population.getIndividuals(racerIndexes[2]).getFitness())
        {
            parent1 = population.getIndividuals(2);
            parent2 = population.getIndividuals(0);
        }
        else if (population.getIndividuals(racerIndexes[1]).getFitness() < population.getIndividuals(racerIndexes[2]).getFitness() &&
                population.getIndividuals(racerIndexes[2]).getFitness() < population.getIndividuals(racerIndexes[0]).getFitness())
        {
            parent1 = population.getIndividuals(0);
            parent2 = population.getIndividuals(2);
        }
        else if (population.getIndividuals(racerIndexes[2]).getFitness() < population.getIndividuals(racerIndexes[0]).getFitness() &&
                population.getIndividuals(racerIndexes[0]).getFitness() < population.getIndividuals(racerIndexes[1]).getFitness())
        {
            parent1 = population.getIndividuals(1);
            parent2 = population.getIndividuals(0);
        }
        else if (population.getIndividuals(racerIndexes[2]).getFitness() < population.getIndividuals(racerIndexes[1]).getFitness() &&
                population.getIndividuals(racerIndexes[1]).getFitness() < population.getIndividuals(racerIndexes[0]).getFitness())
        {
            parent1 = population.getIndividuals(0);
            parent2 = population.getIndividuals(1);
        }
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
