package hw1.part3;

/**
 * CSE 443 Object Oriented Analysis and Design
 * Homework 01
 * Part 3
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
        Suit suit = new Dec();
        System.out.println(suit.getDescription() + " has " + suit.cost() + " TL cost and " + suit.weight() + " weight.");

        suit = new Flamethrower(suit);
        System.out.println(suit.getDescription() + " has " + suit.cost() + " TL cost and " + suit.weight() + " weight.");

        suit = new AutoRifle(suit);
        System.out.println(suit.getDescription() + " has " + suit.cost() + " TL cost and " + suit.weight() + " weight.");

        suit = new AutoRifle(suit);
        System.out.println(suit.getDescription() + " has " + suit.cost() + " TL cost and " + suit.weight() + " weight.");

        suit = new RocketLauncher(suit);
        System.out.println(suit.getDescription() + " has " + suit.cost() + " TL cost and " + suit.weight() + " weight.");
    }
}
