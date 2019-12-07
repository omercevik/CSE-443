package hw1.part4.abstractfactory;

/**
 * Eurasia TPX_300 public concrete class implements TPX interface extends TPX_300.
 */
public class EurasiaTPX300 extends TPX_300 implements TPX
{
    private String EngineInjectionType = "Turbofan";
    private String SeatingCover = "Linen";

    /**
     * Overrides toString method.
     * @return Returns String of Eurasia TPX 300 information.
     */
    @Override
    public String toString()
    {
        return "Eurasia TPX 300 :" + "\nPurpose : " + purpose + "\nSkeleton : " + constructSkeleton() +
                "\nEngines : " + placeEngines() + "\nSeats : " + placeSeats() +
                "\nEngine Injection Type : " + EngineInjectionType + "\nSeating Cover : " + SeatingCover + "\n";
    }
}
