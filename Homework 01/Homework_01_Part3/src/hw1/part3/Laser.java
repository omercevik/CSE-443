package hw1.part3;

/**
 * Laser public class extends Accessories.
 */
public class Laser extends Accessories
{
    private Suit suit;

    /**
     * Constructor of Laser.
     * @param suit Gets Suit to decorate.
     */
    public Laser(Suit suit)
    {
        this.suit = suit;
    }

    /**
     * Overrides description getter of Accessories class.
     * @return Returns Laser's description.
     */
    @Override
    public String getDescription() {
        return suit.getDescription() + ", Laser";
    }

    /**
     * Overrides cost method of Accessories class.
     * @return Returns cost of total suit and Laser.
     */
    @Override
    public double cost() {
        return suit.cost() + 200;
    }

    /**
     * Overrides weight method of Accessories class.
     * @return Returns weight of total suit and Laser.
     */
    @Override
    public double weight() {
        return suit.weight() + 5.5;
    }
}
