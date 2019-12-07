package hw1.part4.abstractfactory;

/**
 * TPX_300 public concrete class implements TPX interface.
 */
public class TPX_300 implements TPX
{
    String purpose = "Transatlantic flights";

    /**
     * Overrides constructSkeleton method of TPX interface.
     * @return Returns TPX_300 construct skeleton as String.
     */
    @Override
    public String constructSkeleton()
    {
        return "Titanium alloy";
    }

    /**
     * Overrides placeEngines method of TPX interface.
     * @return Returns TPX_300 place engines as String.
     */
    @Override
    public String placeEngines()
    {
        return "Quadro jet engines";
    }

    /**
     * Overrides placeSeats method of TPX interface.
     * @return Returns TPX_300 place seats as int.
     */
    @Override
    public int placeSeats()
    {
        return 250;
    }

    /**
     * Overrides toString method.
     * @return Returns String of TPX_300 information.
     */
    @Override
    public String toString()
    {
        return "TPX 300 :" + "\nPurpose : " + purpose + "\nSkeleton : " + constructSkeleton() +
                "\nEngines : " + placeEngines() + "\nSeats : " + placeSeats() + "\n";
    }
}
