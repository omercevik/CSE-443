package hw3.part1;

import java.util.LinkedList;

/**
 * BestDSEverClass concrete class unsafe thread.
 */
class BestDSEverClass implements BestDSEver
{
    private LinkedList<Object> objects;

    /**
     * Constructor of BestDSEverClass initialize objects.
     */
    BestDSEverClass()
    {
        this.objects = new LinkedList<>();
    }

    /**
     * Insert method.
     * @param o Gets Object to insert.
     */
    @Override
    public void insert(Object o) {
        this.objects.add(o);
    }

    /**
     * Remove method.
     * @param o Gets Object to remove.
     */
    @Override
    public void remove(Object o) {
        this.objects.remove(this.objects.get((int)o));
    }

    /**
     * Get method.
     * @param index Gets index to return.
     * @return Returns the element in index.
     */
    @Override
    public Object get(int index) {
        return this.objects.get(index);
    }

    /**
     * toString method of BestDSEverClass class.
     * @return Returns the BestDSEver objects as String.
     */
    @Override
    public String toString()
    {
        return "BestDSEver { objects = " + objects + " }";
    }
}