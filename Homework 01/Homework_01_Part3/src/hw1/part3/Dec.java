package hw1.part3;

/**
 * Dec public concrete class extends Suit abstract class.
 */
public class Dec extends Suit
{
    /**
     * Dec constructor.
     */
    public Dec()
    {
        this.description = "Dec";
    }

    /**
     * Overrides Suit abstract class method cost.
     * @return Returns cost as double.
     */
    @Override
    public double cost()
    {
        return 500;
    }

    /**
     * Overrides Suit abstract class method weight.
     * @return Returns weight as double.
     */
    @Override
    public double weight() {
        return 25;
    }
}
