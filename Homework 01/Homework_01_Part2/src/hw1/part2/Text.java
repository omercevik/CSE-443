package hw1.part2;

import java.util.ArrayList;

/**
 * Text subject concrete class implements Subject interface.
 */
public class Text implements Subject
{
    private ArrayList<Observer> observers;
    private String message;

    /**
     * Text constructor.
     */
    public Text()
    {
        this.observers = new ArrayList<>();
        this.message = "First message of Text!";
    }

    /**
     * Registers an observer to Text subject.
     * @param o Gets an observer to add.
     */
    @Override
    public void registerObserver(Observer o)
    {
        int i = observers.indexOf(o);
        if (i < 0) {
            System.out.println("Text has a new member id : " + o.getId());
            observers.add(o);
        }
    }

    /**
     * Removes an observer from Text subject.
     * @param o Gets an observer to remove.
     */
    @Override
    public void removeObserver(Observer o)
    {
        System.out.println("Subscriber ID : "+ o.getId() + " subscriber left us! - Text");
        int i = observers.indexOf(o);
        if (i >= 0) {
            observers.remove(i);
        }
    }

    /**
     * Notifies to update all observers of Text subject.
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
     * Changes the news of Text subject.
     * @param message Gets a message to change.
     */
    @Override
    public void changeNews(String message)
    {
        System.out.println("Text message changed as -> " + message);
        this.message = message;
    }
}
