package hw1.part3;

/**
 * RocketLauncher public class extends Accessories.
 */
public class RocketLauncher extends Accessories
{
    private Suit suit;

    /**
     * Constructor of RocketLauncher.
     * @param suit Gets Suit to decorate.
     */
    public RocketLauncher(Suit suit)
    {
        this.suit = suit;
    }

    /**
     * Overrides description getter of Accessories class.
     * @return Returns RocketLauncher's description.
     */
    @Override
    public String getDescription() {
        return suit.getDescription() + ", RocketLauncher";
    }

    /**
     * Overrides cost method of Accessories class.
     * @return Returns cost of total suit and RocketLauncher.
     */
    @Override
    public double cost() {
        return suit.cost() + 150;
    }

    /**
     * Overrides weight method of Accessories class.
     * @return Returns weight of total suit and RocketLauncher.
     */
    @Override
    public double weight() {
        return suit.weight() + 7.5;
    }
}
