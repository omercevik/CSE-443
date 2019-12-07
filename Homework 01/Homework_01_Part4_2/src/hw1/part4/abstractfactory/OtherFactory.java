package hw1.part4.abstractfactory;

/**
 * OtherFactory concrete class extends AbstractFactory.
 */
public class OtherFactory extends AbstractFactory
{
    /**
     * Overrides for TPX.
     * @param TPX_type Gets TPX type to create factory.
     * @return Returns Other TPX.
     */
    @Override
    public TPX getTPX(String TPX_type)
    {
        if (TPX_type == null)
            return null;
        else if (TPX_type.equalsIgnoreCase("TPX100"))
            return new OtherTPX100();
        else if (TPX_type.equalsIgnoreCase("TPX200"))
            return new OtherTPX200();
        else if (TPX_type.equalsIgnoreCase("TPX300"))
            return new OtherTPX300();
        return null;
    }
}
