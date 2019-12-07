package hw1.part3;

/**
 * Ora public concrete class extends Suit abstract class.
 */
public class Ora extends Suit
{
    /**
     * Ora constructor.
     */
    public Ora()
    {
        this.description = "Ora";
    }

    /**
     * Overrides Suit abstract class method cost.
     * @return Returns cost as double.
     */
    @Override
    public double cost()
    {
        return 1500;
    }

    /**
     * Overrides Suit abstract class method weight.
     * @return Returns weight as double.
     */
    @Override
    public double weight() {
        return 30;
    }
}
