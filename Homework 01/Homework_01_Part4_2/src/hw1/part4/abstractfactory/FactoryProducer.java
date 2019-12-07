package hw1.part4.abstractfactory;

/**
 * FactoryProducer concrete class.
 */
class FactoryProducer
{
    /**
     * To create factories.
     * @param marketType Gets Factory market type.
     * @return Returns Factory.
     */
    static AbstractFactory getFactory(int marketType)
    {
        switch (marketType)
        {
            case 0: return new DomesticFactory();

            case 1: return new EurasiaFactory();

            case 2: return new OtherFactory();

            default: return null;
        }
    }
}
