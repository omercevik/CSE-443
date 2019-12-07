package hw1.part4.abstractfactory;

/**
 * Domestic TPX_100 public concrete class implements TPX interface extends TPX_100.
 */
public class DomesticTPX100 extends TPX_100 implements TPX
{
    private String EngineInjectionType = "Turbojet";
    private String SeatingCover = "Velvet";

    /**
     * Overrides toString method.
     * @return Returns String of Domestic TPX 100 information.
     */
    @Override
    public String toString()
    {
        return "Domestic TPX 100 :" + "\nPurpose : " + purpose + "\nSkeleton : " + constructSkeleton() +
                "\nEngines : " + placeEngines() + "\nSeats : " + placeSeats() +
                "\nEngine Injection Type : " + EngineInjectionType + "\nSeating Cover : " + SeatingCover + "\n";
    }
}
