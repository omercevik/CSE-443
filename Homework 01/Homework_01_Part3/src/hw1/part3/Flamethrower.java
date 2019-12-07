package hw1.part3;

/**
 * Flamethrower public class extends Accessories.
 */
public class Flamethrower extends Accessories
{
    private Suit suit;

    /**
     * Constructor of Flamethrower.
     * @param suit Gets Suit to decorate.
     */
    public Flamethrower(Suit suit)
    {
        this.suit = suit;
    }

    /**
     * Overrides description getter of Accessories class.
     * @return Returns Flamethrower's description.
     */
    @Override
    public String getDescription() {
        return suit.getDescription() + ", Flamethrower";
    }

    /**
     * Overrides cost method of Accessories class.
     * @return Returns cost of total suit and Flamethrower.
     */
    @Override
    public double cost() {
        return suit.cost() + 50;
    }

    /**
     * Overrides weight method of Accessories class.
     * @return Returns weight of total suit and Flamethrower.
     */
    @Override
    public double weight() {
        return suit.weight() + 2;
    }
}
