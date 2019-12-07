package hw1.part2;

/**
 * Subject interface.
 */
public interface Subject
{
    /**
     * Adds new observer to subject.
     * @param o Gets an observer to add.
     */
    void registerObserver(Observer o);

    /**
     * Removes observer from subject.
     * @param o Gets an observer to remove.
     */
    void removeObserver(Observer o);

    /**
     * Notifies all observers to update.
     */
    void notifyObservers();

    /**
     * Changes the news of subject.
     * @param message Gets a message to change.
     */
    void changeNews(String message);
}
