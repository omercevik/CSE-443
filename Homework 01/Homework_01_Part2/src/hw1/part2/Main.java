package hw1.part2;

/**
 * CSE 443 Object Oriented Analysis and Design
 * Homework 01
 * Part 2
 * 161044004
 * @author Omer CEVIK
 */
public class Main
{
    /**
     * Driver method main.
     * @param args No args.
     */
    public static void main(String[] args)
    {
        Audio audio = new Audio();
        Text text = new Text();
        Photograph photograph = new Photograph();

        Subscriber subscriber1 = new Subscriber("1");
        Subscriber subscriber2 = new Subscriber("2");
        Subscriber subscriber3 = new Subscriber("3");
        Subscriber subscriber4 = new Subscriber("4");
        Subscriber subscriber5 = new Subscriber("5");

        audio.registerObserver(subscriber1);
        audio.registerObserver(subscriber1);
        text.registerObserver(subscriber1);
        text.registerObserver(subscriber2);
        photograph.registerObserver(subscriber1);
        photograph.registerObserver(subscriber2);
        photograph.registerObserver(subscriber3);
        photograph.registerObserver(subscriber4);
        photograph.registerObserver(subscriber5);
        System.out.println();

        audio.notifyObservers();
        System.out.println();

        text.notifyObservers();
        System.out.println();

        photograph.notifyObservers();
        System.out.println();

        photograph.removeObserver(subscriber4);
        System.out.println();

        photograph.notifyObservers();
        System.out.println();

        photograph.changeNews("Second message of hw1.part2.Photograph!");
        photograph.notifyObservers();
        System.out.println();

        text.changeNews("Second message of hw1.part2.Text");
        text.registerObserver(subscriber3);
        System.out.println();
        text.notifyObservers();
        System.out.println();

        audio.changeNews("Second message of hw1.part2.Audio");
        audio.notifyObservers();
        System.out.println();

        audio.registerObserver(subscriber3);
        System.out.println();

        audio.changeNews("Third message of hw1.part2.Audio");
        audio.notifyObservers();
    }
}
