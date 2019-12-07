package hw1.part3;

/**
 * AutoRifle public class extends Accessories.
 */
public class AutoRifle extends Accessories
{
    private Suit suit;

    /**
     * Constructor of AutoRifle.
     * @param suit Gets Suit to decorate.
     */
    public AutoRifle(Suit suit)
    {
        this.suit = suit;
    }

    /**
     * Overrides description getter of Accessories class.
     * @return Returns AutoRifle's description.
     */
    @Override
    public String getDescription() {
        return suit.getDescription() + ", AutoRifle";
    }

    /**
     * Overrides cost method of Accessories class.
     * @return Returns cost of total suit and AutoRifle.
     */
    @Override
    public double cost() {
        return suit.cost() + 30;
    }

    /**
     * Overrides weight method of Accessories class.
     * @return Returns weight of total suit and AutoRifle.
     */
    @Override
    public double weight() {
        return suit.weight() + 1.5;
    }
}
