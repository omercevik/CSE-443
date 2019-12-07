package hw1.part4.abstractfactory;

/**
 * AbstractFactory abstract class.
 */
public abstract class AbstractFactory
{
    /**
     * getTPX method to override.
     * @param TPX_type Gets TPX type to create factory.
     * @return Returns TPX factory.
     */
    public abstract TPX getTPX(String TPX_type);
}
