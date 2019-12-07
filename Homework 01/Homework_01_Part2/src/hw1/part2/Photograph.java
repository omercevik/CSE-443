package hw1.part2;

import java.util.ArrayList;

/**
 * Photograph subject concrete class implements Subject interface.
 */
public class Photograph implements Subject
{
    private ArrayList<Observer> observers;
    private String message;

    /**
     * Photograph constructor.
     */
    public Photograph()
    {
        this.observers = new ArrayList<>();
        this.message = "First message of Photograph!";
    }

    /**
     * Registers an observer to Photograph subject.
     * @param o Gets an observer to add.
     */
    @Override
    public void registerObserver(Observer o)
    {
        int i = observers.indexOf(o);
        if (i < 0) {
            System.out.println("Photograph has a new member id : " + o.getId());
            observers.add(o);
        }
    }

    /**
     * Removes an observer from Photograph subject.
     * @param o Gets an observer to remove.
     */
    @Override
    public void removeObserver(Observer o)
    {
        System.out.println("Subscriber ID : "+ o.getId() + " subscriber left us! - Photograph");
        int i = observers.indexOf(o);
        if (i >= 0) {
            observers.remove(i);
        }
    }

    /**
     * Notifies to update all observers of Photograph subject.
     */
    @Override
    public void notifyObservers()
    {
        for (Observer observer : observers)
        {
            observer.update(message);
        }
    }

    /**
     * Changes the news of Photograph subject.
     * @param message Gets a message to change.
     */
    @Override
    public void changeNews(String message)
    {
        System.out.println("Photograph message changed as -> " + message);
        this.message = message;
    }
}
