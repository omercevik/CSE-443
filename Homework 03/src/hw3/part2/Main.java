package hw3.part2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * CSE 443
 * Object Oriented Analysis and Design
 * Homework 03
 * Part 2
 * 161044004
 * @author Omer CEVIK
 */
public class Main extends JFrame implements ActionListener
{
    static JTextField imageSize;

    static JFrame f;
    static JButton submitButton;
    static JButton startButton;
    static JLabel l;
    static JLabel setValue;
    static JLabel mainThreadTime;
    static JLabel otherThreadTime;
    static JCheckBox mutexCheck;
    static String[] items = new String[] {"Not Set    ", "4", "9", "16", "25", "36"};
    static final JComboBox<String> gradeCombo = new JComboBox<>(items);
    static boolean isMutex = false;

    /**
     * Test main and GUI driver.
     * @param args No args.
     */
    public static void main(String[] args)
    {
        f = new JFrame("DFT Calculator");
        f.setLayout(new CardLayout());

        l = new JLabel("No Entry!");
        setValue = new JLabel();
        mainThreadTime = new JLabel("Single Thread Time : 0 milliseconds.");
        otherThreadTime = new JLabel("Multiple Thread Time : 0 milliseconds.");

        submitButton = new JButton("SET");
        startButton = new JButton("START");
        mutexCheck = new JCheckBox("Mutex?");

        Main te = new Main();

        submitButton.addActionListener(te);

        startButton.addActionListener(te);
        mutexCheck.addActionListener(te);

        imageSize = new JTextField(5);

        JPanel p = new JPanel();

        p.add(startButton);
        p.add(imageSize);

        JPanel p1 = new JPanel();
        p1.add(new JLabel("Enter the NxN Image Size : "));
        p1.add(imageSize);
        p1.add(l);
        p1.add(submitButton);

        JPanel p2 = new JPanel();
        p2.add(new JLabel("Set the Thread Size : "));
        p2.add(gradeCombo);
        p2.add(mutexCheck);

        JPanel p3 = new JPanel();
        p3.add(mainThreadTime);

        JPanel p4 = new JPanel();
        p4.add(otherThreadTime);

        JPanel all = new JPanel();

        all.add(p1,BorderLayout.CENTER);
        all.add(p2,BorderLayout.CENTER);
        all.add(p,BorderLayout.CENTER);
        all.add(p3,BorderLayout.CENTER);
        all.add(p4,BorderLayout.CENTER);

        f.add(all);

        f.setSize(450, 250);
        f.setVisible(true);
        f.setResizable(false);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    /**
     * Button and checkbox jobs.
     * @param e Gets action event.
     */
    @Override
    public void actionPerformed(ActionEvent e)
    {
        String s = e.getActionCommand();

        switch (s)
        {
            case "SET":
                if (!imageSize.getText().equals("") && !imageSize.getText().equals("0") &&
                        Integer.parseInt(imageSize.getText()) % 2 == 0 && Integer.parseInt(imageSize.getText()) <= 1250)
                {
                    l.setText(imageSize.getText() + " is set!");
                    setValue.setText(imageSize.getText());
                } else
                {
                    if (imageSize.getText().equals(""))
                        JOptionPane.showMessageDialog(f, "Set The NxN!", "Error", JOptionPane.ERROR_MESSAGE);
                    else if (imageSize.getText().equals("0"))
                        JOptionPane.showMessageDialog(f, "NxN can not be 0!", "Error", JOptionPane.ERROR_MESSAGE);
                    else if (Integer.parseInt(imageSize.getText()) % 2 != 0)
                        JOptionPane.showMessageDialog(f, "NxN must be even!", "Error", JOptionPane.ERROR_MESSAGE);
                    else
                        JOptionPane.showMessageDialog(f, "NxN must be less than 1250!", "Error", JOptionPane.ERROR_MESSAGE);
                }

                break;
            case "START":
                if (gradeCombo.getSelectedIndex() == 0)
                    JOptionPane.showMessageDialog(f, "Set The Thread Size!", "Error", JOptionPane.ERROR_MESSAGE);
                else {
                    int NxN = Integer.parseInt(setValue.getText());
                    int threadSize = Integer.parseInt(items[gradeCombo.getSelectedIndex()]);

                    ComplexMatrix cm = isMutex ? new MutexComplexMatrix(NxN) : new SynchComplexMatrix(NxN);

                    cm.createForMainThread();

                    mainThreadTime.setText("Single Thread Time : " + cm.getMainThreadTime() + " milliseconds.");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }

                    cm = isMutex ? new MutexComplexMatrix(NxN, threadSize) : new SynchComplexMatrix(NxN, threadSize);

                    Thread[] threads = new Thread[threadSize];

                    for (int i = 0; i < threadSize; ++i)
                        threads[i] = new Thread(cm::createResult);

                    for (Thread thread : threads)
                        thread.start();


                    try {
                        for (Thread thread : threads)
                            thread.join();

                    } catch (InterruptedException exception) {
                        System.out.println(exception.toString());
                    }
                    otherThreadTime.setText("Multiple Thread Time : " + cm.getOtherThreadTime() + " milliseconds.");
                }
                break;
            case "Mutex?":
                isMutex = !isMutex;
                break;
        }
    }
}
