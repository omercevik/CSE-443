package hw1.part2;

/**
 * Observer interface.
 */
public interface Observer
{
    /**
     * Updates the news of observer.
     * @param message Gets a new message to update.
     */
    void update(String message);

    /**
     * Getter id of subscriber.
     * @return Returns id of subscriber.
     */
    String getId();
}
