package hw1.part3;

/**
 * Suit abstract class.
 */
public abstract class Suit
{
    protected String description = "Unknown Suit";

    public String getDescription()
    {
        return this.description;
    }

    public abstract double cost();

    public abstract double weight();
}
