package hw1.part2;

/**
 * Subscriber observer concrete class implements Observer interface.
 */
public class Subscriber implements Observer
{
    private String message;
    private String id;

    /**
     * Subscriber constructor.
     * @param id Gets String id to set subscriber id.
     */
    public Subscriber(String id)
    {
        this.id = id;
    }

    /**
     * Id of subscriber.
     * @return Returns id of subscriber.
     */
    @Override
    public String getId()
    {
        return this.id;
    }

    /**
     * Updates the news of observer.
     * @param message Gets a new message to update.
     */
    @Override
    public void update(String message)
    {
        this.message = message;
        System.out.println("Subscriber ID : "+ id + " Update : " + message);
    }
}
