package hw3.part1;

/**
 * BestDSEver interface.
 */
interface BestDSEver
{
    /**
     * Insert method of BestDSEver interface.
     * @param o Gets object to insert.
     */
    void insert(Object o);

    /**
     * Remove method of BestDSEver interface.
     * @param o Gets object to remove.
     */
    void remove(Object o);

    /**
     * Get method of BestDSEver interface.
     * @param index Gets index to get.
     * @return Returns object in index.
     */
    Object get(int index);
}
