package hw1.part4.abstractfactory;

/**
 * Eurasia TPX_100 public concrete class implements TPX interface extends TPX_100.
 */
public class EurasiaTPX100 extends TPX_100 implements TPX
{
    private String EngineInjectionType = "Turbofan";
    private String SeatingCover = "Linen";

    /**
     * Overrides toString method.
     * @return Returns String of Eurasia TPX 100 information.
     */
    @Override
    public String toString()
    {
        return "Eurasia TPX 100 :" + "\nPurpose : " + purpose + "\nSkeleton : " + constructSkeleton() +
                "\nEngines : " + placeEngines() + "\nSeats : " + placeSeats() +
                "\nEngine Injection Type : " + EngineInjectionType + "\nSeating Cover : " + SeatingCover + "\n";
    }
}
