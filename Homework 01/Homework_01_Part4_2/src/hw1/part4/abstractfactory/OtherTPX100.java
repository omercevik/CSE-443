package hw1.part4.abstractfactory;

/**
 * Other TPX_100 public concrete class implements TPX interface extends TPX_100.
 */
public class OtherTPX100 extends TPX_100 implements TPX
{
    private String EngineInjectionType = "Geared turbofan";
    private String SeatingCover = "Leather";

    /**
     * Overrides toString method.
     * @return Returns String of Other TPX 100 information.
     */
    @Override
    public String toString()
    {
        return "Other TPX 100 :" + "\nPurpose : " + purpose + "\nSkeleton : " + constructSkeleton() +
                "\nEngines : " + placeEngines() + "\nSeats : " + placeSeats() +
                "\nEngine Injection Type : " + EngineInjectionType + "\nSeating Cover : " + SeatingCover + "\n";
    }
}
