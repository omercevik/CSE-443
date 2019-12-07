package hw2.part1;

import java.util.Random;

/**
 * Version2 public class extends AbstractGA.
 */
public class Version2 extends AbstractGA
{
    /**
     * Version2 constructor for Rank Selection.
     * @param populationSize Gets population size.
     * @param x1 Gets x1 array.
     * @param x2 Gets x2 array.
     */
    public Version2(int populationSize, double[] x1, double[] x2)
    {
        super(populationSize,x1,x2);
    }

    /**
     * Selection is selecting the Individual parents using Rank Selection algorithm.
     * Firstly sorting individuals looking at their fitness values.
     * Secondly selecting two parents with random method which selects randomly but probability of random is fitness higher based.
     */
    @Override
    protected void selection()
    {
        for (Individual individual : population.getIndividuals())
            for (Individual populationIndividual : population.getIndividuals())
                if (individual.getFitness() > populationIndividual.getFitness()) {
                    double tempF = individual.getFitness();
                    individual.setFitness(populationIndividual.getFitness());
                    populationIndividual.setFitness(tempF);
                }

        Random rn = new Random();
        int indexForParent1;
        int indexForParent2;
        if (rn.nextDouble() > 0.7f)
        {
            indexForParent1 = Math.abs(rn.nextInt(population.getIndividuals().length/2));
            indexForParent2 = Math.abs(rn.nextInt(population.getIndividuals().length/2));
            while(indexForParent1 == indexForParent2)
                indexForParent2 = Math.abs(rn.nextInt(population.getIndividuals().length/2));
        }
        else
        {
            indexForParent1 = Math.abs(rn.nextInt(population.getIndividuals().length/2)+population.getIndividuals().length/2);
            indexForParent2 = Math.abs(rn.nextInt(population.getIndividuals().length/2)+population.getIndividuals().length/2);
            while(indexForParent1 == indexForParent2)
                indexForParent2 = Math.abs(rn.nextInt(population.getIndividuals().length/2)+population.getIndividuals().length/2);
        }

        parent1 = population.getIndividuals(indexForParent1);
        parent2 = population.getIndividuals(indexForParent2);
    }

    /**
     * Crossing over is creating child Individual using parents' x1 and x2 values multiplying by 0.55.
     * And adds child into population of Individual array's last position.
     */
    @Override
    protected void crossover()
    {
        child = new Individual();
        child.setX1((parent1.getX1() + parent2.getX1())*0.55);
        child.setX2((parent1.getX2() + parent2.getX2())*0.55);
    }
}
