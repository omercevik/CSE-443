package hw1.part4.abstractfactory;

/**
 * Other TPX_200 public concrete class implements TPX interface extends TPX_200.
 */
public class OtherTPX200 extends TPX_200 implements TPX
{
    private String EngineInjectionType = "Geared turbofan";
    private String SeatingCover = "Leather";

    /**
     * Overrides toString method.
     * @return Returns String of Other TPX 200 information.
     */
    @Override
    public String toString()
    {
        return "Other TPX 200 :" + "\nPurpose : " + purpose + "\nSkeleton : " + constructSkeleton() +
                "\nEngines : " + placeEngines() + "\nSeats : " + placeSeats() +
                "\nEngine Injection Type : " + EngineInjectionType + "\nSeating Cover : " + SeatingCover + "\n";
    }
}
