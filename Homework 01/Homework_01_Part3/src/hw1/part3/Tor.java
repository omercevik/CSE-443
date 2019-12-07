package hw1.part3;

/**
 * Tor public concrete class extends Suit abstract class.
 */
public class Tor extends Suit
{
    /**
     * Tor constructor.
     */
    public Tor()
    {
        this.description = "Tor";
    }

    /**
     * Overrides Suit abstract class method cost.
     * @return Returns cost as double.
     */
    @Override
    public double cost()
    {
        return 5000;
    }

    /**
     * Overrides Suit abstract class method weight.
     * @return Returns weight as double.
     */
    @Override
    public double weight() {
        return 50;
    }
}
