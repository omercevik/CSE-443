package hw2.part1;

import java.util.Random;

/**
 * CSE 443
 * Object Oriented Analysis and Design
 * Homework 02
 * Part 1
 * 161044004
 * @author Omer CEVIK
 */
public class Main
{
    /**
     * Creates randomly x1 and x2 values.
     * @param valuesX1 To return x1 values.
     * @param valuesX2 To return x2 values.
     */
    public static void createX1andX2(double[] valuesX1, double[] valuesX2)
    {
        Random rn = new Random();

        for (int i = 0; i < valuesX1.length; ++i)
        {
            double x1 = Math.abs(rn.nextDouble());
            double x2 = Math.abs(rn.nextDouble());
            while(!((x1 + x2) <= 5))
            {
                x1 = Math.abs(rn.nextDouble());
                x2 = Math.abs(rn.nextDouble());
            }
            valuesX1[i] = x1;
            valuesX2[i] = x2;
        }
    }

    /**
     * Main method to test.
     * @param args No args.
     */
    public static void main(String[] args)
    {
        int populationSize = 10;

        double[] valuesX1 = new double[populationSize];
        double[] valuesX2 = new double[populationSize];

        createX1andX2(valuesX1,valuesX2);

        System.out.println("Roulette Wheel Selection Genetic Algorithm");
        System.out.println();
        Version1 roulette_wheel_selection_version = new Version1(populationSize,valuesX1,valuesX2);
        roulette_wheel_selection_version.geneticAlgorithm();


        System.out.println("Rank Selection Genetic Algorithm");
        System.out.println();
        Version2 rank_selection_version = new Version2(populationSize,valuesX1,valuesX2);
        rank_selection_version.geneticAlgorithm();


        System.out.println("Tournament Selection Genetic Algorithm");
        System.out.println();
        Version3 tournament_selection_version = new Version3(populationSize,valuesX1,valuesX2);
        tournament_selection_version.geneticAlgorithm();
    }
}
