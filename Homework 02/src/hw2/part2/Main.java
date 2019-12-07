package hw2.part2;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import javax.swing.*;
import java.awt.*;

import hw2.part1.Version1;
import hw2.part1.Version2;
import hw2.part1.Version3;
import static hw2.part1.Main.createX1andX2;

/**
 * CSE 443
 * Object Oriented Analysis and Design
 * Homework 02
 * Part 2
 * 161044004
 * @author Omer CEVIK
 */
public class Main extends ApplicationFrame
{
    /**
     * Main class constructor as ApplicationFrame.
     * @param applicationTitle Gets Application title.
     * @param chartTitle Gets chart title.
     */
    private Main(String applicationTitle, String chartTitle)
    {
        super(applicationTitle);
        JFreeChart xylineChart = ChartFactory.createXYLineChart(
                chartTitle ,
                "Generations" ,
                "Fits" ,
                createDataset() ,
                PlotOrientation.VERTICAL ,
                true , true , false);

        ChartPanel chartPanel = new ChartPanel( xylineChart );
        chartPanel.setPreferredSize( new java.awt.Dimension( 800 , 600 ) );
        final XYPlot plot = xylineChart.getXYPlot( );

        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer( );
        renderer.setSeriesPaint( 0 , Color.RED );
        renderer.setSeriesPaint( 1 , Color.GREEN );
        renderer.setSeriesPaint( 2 , Color.YELLOW );
        JPanel buttonPanel = new JPanel();
        JButton startButton = new JButton("START");
        JButton pauseButton = new JButton("PAUSE");
        JButton stopButton = new JButton("STOP");
        JButton continueButton = new JButton("CONTINUE");
        buttonPanel.add(startButton);
        buttonPanel.add(pauseButton);
        buttonPanel.add(stopButton);
        buttonPanel.add(continueButton);
        chartPanel.add(buttonPanel);
        plot.setRenderer( renderer );
        setContentPane( chartPanel );
    }

    /**
     * Creates dataset of genetic algorithm.
     * @return Returns data set.
     */
    private XYDataset createDataset()
    {
        final XYSeries v1 = new XYSeries( "Roulette Wheel" );
        final XYSeries v2 = new XYSeries( "Rank" );
        final XYSeries v3 = new XYSeries( "Tournament" );

        int populationSize = 10;

        double[] valuesX1 = new double[populationSize];
        double[] valuesX2 = new double[populationSize];

        createX1andX2(valuesX1,valuesX2);

        Version1 roulette_wheel_selection_version = new Version1(populationSize,valuesX1,valuesX2);
        Version2 rank_selection_version = new Version2(populationSize,valuesX1,valuesX2);
        Version3 tournament_selection_version = new Version3(populationSize,valuesX1,valuesX2);

        roulette_wheel_selection_version.geneticAlgorithm(v1);
        rank_selection_version.geneticAlgorithm(v2);
        tournament_selection_version.geneticAlgorithm(v3);

        final XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries( v1 );
        dataset.addSeries( v2 );
        dataset.addSeries( v3 );

        return dataset;
    }

    /**
     * Main method to test.
     * @param args No args.
     */
    public static void main( String[] args )
    {
        Main chart = new Main("Genetic Algorithms", "");
        chart.pack();
        RefineryUtilities.centerFrameOnScreen(chart);
        chart.setVisible(true);
    }
}
