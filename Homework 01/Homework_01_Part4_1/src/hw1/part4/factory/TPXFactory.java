package hw1.part4.factory;

/**
 * TPXFactory concrete class.
 */
class TPXFactory
{
    /**
     * getTPX method to create TPX object.
     * @param TPX_type Gets TPX_type to create TPX object.
     * @return Returns TPX object.
     */
    TPX getTPX(String TPX_type)
    {
        if (TPX_type == null)
            return null;
        else if (TPX_type.equalsIgnoreCase("TPX100"))
            return new TPX_100();
        else if (TPX_type.equalsIgnoreCase("TPX200"))
            return new TPX_200();
        else if (TPX_type.equalsIgnoreCase("TPX300"))
            return new TPX_300();
        return null;
    }
}
