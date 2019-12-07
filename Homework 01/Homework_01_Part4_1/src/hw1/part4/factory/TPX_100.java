package hw1.part4.factory;

/**
 * TPX_100 public concrete class implements TPX interface.
 */
public class TPX_100 implements TPX
{
    /**
     * Overrides constructSkeleton method of TPX interface.
     * @return Returns TPX_100 construct skeleton as String.
     */
    @Override
    public String constructSkeleton()
    {
        return "Aluminum alloy";
    }

    /**
     * Overrides placeEngines method of TPX interface.
     * @return Returns TPX_100 place engines as String.
     */
    @Override
    public String placeEngines() { return "Single jet engine"; }

    /**
     * Overrides placeSeats method of TPX interface.
     * @return Returns TPX_100 place seats as int.
     */
    @Override
    public int placeSeats() { return 50; }

    /**
     * Overrides toString method.
     * @return Returns String of TPX_100 information.
     */
    @Override
    public String toString()
    {
        String purpose = "Domestic flights";
        return "TPX 100 :" + "\nPurpose : " + purpose + "\nSkeleton : " + constructSkeleton() +
                "\nEngines : " + placeEngines() + "\nSeats : " + placeSeats() + "\n";
    }
}
