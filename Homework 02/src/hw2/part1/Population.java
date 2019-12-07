package hw2.part1;

/**
 * Public Population class to keep individuals.
 */
public class Population
{
    private Individual[] individuals;

    /**
     * Population constructor to set individuals.
     * @param populationSize Gets population size.
     */
    public Population(int populationSize)
    {
        this.individuals = new Individual[populationSize];
        for (int i = 0; i < individuals.length; ++i)
            this.individuals[i] = new Individual();
    }

    /**
     * Getter for individuals.
     * @param index Gets index to return.
     * @return Returns individual at given index.
     */
    public Individual getIndividuals(int index)
    {
        return this.individuals[index];
    }

    /**
     * Getter for individuals.
     * @return Returns individuals.
     */
    public Individual[] getIndividuals()
    {
        return this.individuals;
    }

    /**
     * Setter for individuals.
     * @param index Gets index to set at given index.
     * @param individual Gets setting individual.
     */
    public void setIndividuals(int index, Individual individual)
    {
        this.individuals[index] = individual;
    }
}