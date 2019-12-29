package hw3.part1;

/**
 * SynchProxy concrete class of synchronized version BestDSEver.
 */
class SynchProxy implements BestDSEver
{
    private BestDSEverClass synchBestDSEver = new BestDSEverClass();

    /**
     * Synchronized insert method.
     * @param o Gets Object to insert.
     */
    @Override
    public void insert(Object o)
    {
        synchronized (SynchProxy.class)
        {
            synchronized (BestDSEverClass.class)
            {
                synchBestDSEver.insert(o);
            }
        }
    }

    /**
     * Synchronized remove method.
     * @param o Gets Object to remove.
     */
    @Override
    public void remove(Object o)
    {
        synchronized (SynchProxy.class)
        {
            synchronized (BestDSEverClass.class)
            {
                synchBestDSEver.remove(o);
            }
        }
    }

    /**
     * Synchronized get method.
     * @param index Gets index to return.
     * @return Returns the element in index.
     */
    @Override
    public Object get(int index)
    {
        synchronized (SynchProxy.class)
        {
            synchronized (BestDSEverClass.class)
            {
                return synchBestDSEver.get(index);
            }
        }
    }

    /**
     * toString method of SynchProxy class.
     * @return Returns the BestDSEverClass toString method.
     */
    @Override
    public String toString()
    {
        synchronized (SynchProxy.class)
        {
            synchronized (BestDSEverClass.class)
            {
                return "SynchProxy { synchBestDSEver = " + synchBestDSEver + " }";
            }
        }
    }
}
