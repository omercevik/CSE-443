package hw1.part2;

import java.util.ArrayList;

/**
 * Audio subject concrete class implements Subject interface.
 */
public class Audio implements Subject
{
    private ArrayList<Observer> observers;
    private String message;

    /**
     * Audio constructor.
     */
    public Audio()
    {
        this.observers = new ArrayList<>();
        this.message = "First message of Audio!";
    }

    /**
     * Registers an observer to Audio subject.
     * @param o Gets an observer to add.
     */
    @Override
    public void registerObserver(Observer o)
    {
        int i = observers.indexOf(o);
        if (i < 0) {
            System.out.println("Audio has a new member id : " + o.getId());
            observers.add(o);
        }
    }

    /**
     * Removes an observer from Audio subject.
     * @param o Gets an observer to remove.
     */
    @Override
    public void removeObserver(Observer o)
    {
        System.out.println("Subscriber ID : "+ o.getId() + " subscriber left us! - Audio");
        int i = observers.indexOf(o);
        if (i >= 0) {
            observers.remove(i);
        }
    }

    /**
     * Notifies to update all observers of Audio subject.
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
     * Changes the news of Audio subject.
     * @param message Gets a message to change.
     */
    @Override
    public void changeNews(String message)
    {
        System.out.println("Audio message changed as -> " + message);
        this.message = message;
    }
}
