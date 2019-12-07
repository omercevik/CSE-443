package hw1.part4.abstractfactory;

/**
 * Other TPX_300 public concrete class implements TPX interface extends TPX_300.
 */
public class OtherTPX300 extends TPX_300 implements TPX
{
    private String EngineInjectionType = "Geared turbofan";
    private String SeatingCover = "Leather";

    /**
     * Overrides toString method.
     * @return Returns String of Other TPX 300 information.
     */
    @Override
    public String toString()
    {
        return "Other TPX 300 :" + "\nPurpose : " + purpose + "\nSkeleton : " + constructSkeleton() +
                "\nEngines : " + placeEngines() + "\nSeats : " + placeSeats() +
                "\nEngine Injection Type : " + EngineInjectionType + "\nSeating Cover : " + SeatingCover + "\n";
    }
}
