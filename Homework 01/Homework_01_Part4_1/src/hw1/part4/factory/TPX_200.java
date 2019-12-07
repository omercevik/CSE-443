package hw1.part4.factory;

/**
 * TPX_200 public concrete class implements TPX interface.
 */
public class TPX_200 implements TPX
{
    /**
     * Overrides constructSkeleton method of TPX interface.
     * @return Returns TPX_200 construct skeleton as String.
     */
    @Override
    public String constructSkeleton()
    {
        return "Nickel alloy";
    }

    /**
     * Overrides placeEngines method of TPX interface.
     * @return Returns TPX_200 place engines as String.
     */
    @Override
    public String placeEngines()
    {
        return "Twin jet engines";
    }

    /**
     * Overrides placeSeats method of TPX interface.
     * @return Returns TPX_200 place seats as int.
     */
    @Override
    public int placeSeats()
    {
        return 100;
    }

    /**
     * Overrides toString method.
     * @return Returns String of TPX_200 information.
     */
    @Override
    public String toString()
    {
        String purpose = "Domestic and short international flights";
        return "TPX 200 :" + "\nPurpose : " + purpose + "\nSkeleton : " + constructSkeleton() +
                "\nEngines : " + placeEngines() + "\nSeats : " + placeSeats() + "\n";
    }
}
