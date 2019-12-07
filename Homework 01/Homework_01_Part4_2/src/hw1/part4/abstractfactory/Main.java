package hw1.part4.abstractfactory;

/**
 * CSE 443 Object Oriented Analysis and Design
 * Homework 01
 * Part 4 - 2 Abstract Factory
 * 161044004
 * @author Omer CEVIK
 */
public class Main
{
    /**
     * Driver method main.
     * @param args No args.
     */
    public static void main(String[] args)
    {
        AbstractFactory TPX = FactoryProducer.getFactory(0);

        TPX TPX100 = TPX.getTPX("TPX100");
        System.out.println(TPX100);

        TPX TPX200 = TPX.getTPX("TPX200");
        System.out.println(TPX200);

        TPX TPX300 = TPX.getTPX("TPX300");
        System.out.println(TPX300);


        TPX = FactoryProducer.getFactory(1);

        TPX100 = TPX.getTPX("TPX100");
        System.out.println(TPX100);

        TPX200 = TPX.getTPX("TPX200");
        System.out.println(TPX200);

        TPX300 = TPX.getTPX("TPX300");
        System.out.println(TPX300);


        TPX = FactoryProducer.getFactory(2);

        TPX100 = TPX.getTPX("TPX100");
        System.out.println(TPX100);

        TPX200 = TPX.getTPX("TPX200");
        System.out.println(TPX200);

        TPX300 = TPX.getTPX("TPX300");
        System.out.println(TPX300);
    }
}
