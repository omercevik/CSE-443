package hw1.part4.abstractfactory;

/**
 * Domestic TPX_300 public concrete class implements TPX interface extends TPX_300.
 */
public class DomesticTPX300 extends TPX_300 implements TPX
{
    private String EngineInjectionType = "Turbojet";
    private String SeatingCover = "Velvet";

    /**
     * Overrides toString method.
     * @return Returns String of Domestic TPX 300 information.
     */
    @Override
    public String toString()
    {
        return "Domestic TPX 300 :" + "\nPurpose : " + purpose + "\nSkeleton : " + constructSkeleton() +
                "\nEngines : " + placeEngines() + "\nSeats : " + placeSeats() +
                "\nEngine Injection Type : " + EngineInjectionType + "\nSeating Cover : " + SeatingCover + "\n";
    }
}
