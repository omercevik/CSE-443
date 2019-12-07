package hw1.part4.abstractfactory;

/**
 * Domestic TPX_200 public concrete class implements TPX interface extends TPX_200.
 */
public class DomesticTPX200 extends TPX_200 implements TPX
{
    private String EngineInjectionType = "Turbojet";
    private String SeatingCover = "Velvet";

    /**
     * Overrides toString method.
     * @return Returns String of Domestic TPX 200 information.
     */
    @Override
    public String toString()
    {
        return "Domestic TPX 200 :" + "\nPurpose : " + purpose + "\nSkeleton : " + constructSkeleton() +
                "\nEngines : " + placeEngines() + "\nSeats : " + placeSeats() +
                "\nEngine Injection Type : " + EngineInjectionType + "\nSeating Cover : " + SeatingCover + "\n";
    }
}
