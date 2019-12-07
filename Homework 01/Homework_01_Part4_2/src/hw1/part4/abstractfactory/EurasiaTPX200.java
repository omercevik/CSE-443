package hw1.part4.abstractfactory;

/**
 * Eurasia TPX_200 public concrete class implements TPX interface extends TPX_200.
 */
public class EurasiaTPX200 extends TPX_200 implements TPX
{
    private String EngineInjectionType = "Turbofan";
    private String SeatingCover = "Linen";

    /**
     * Overrides toString method.
     * @return Returns String of Eurasia TPX 200 information.
     */
    @Override
    public String toString()
    {
        return "Eurasia TPX 200 :" + "\nPurpose : " + purpose + "\nSkeleton : " + constructSkeleton() +
                "\nEngines : " + placeEngines() + "\nSeats : " + placeSeats() +
                "\nEngine Injection Type : " + EngineInjectionType + "\nSeating Cover : " + SeatingCover + "\n";
    }
}
