package hw3.part2;

/**
 * Synchronized Complex Matrix concrete class.
 */
public class SynchComplexMatrix extends ComplexMatrix
{
    /**
     * SynchComplexMatrix constructor for single thread.
     * @param NxN Gets NxN size.
     */
    SynchComplexMatrix(int NxN)
    {
        super(NxN);
    }

    /**
     * SynchComplexMatrix constructor for multiple threads.
     * @param N Gets NxN size.
     * @param threadSize Gets threads size.
     */
    SynchComplexMatrix(int N, int threadSize)
    {
        super(N, threadSize);
    }

    /**
     * Creates sum of A and B arrays using synchronized keyword.
     * And waits all threads to sum.
     */
    @Override
    protected synchronized void createSumArray()
    {
        ++threadCounter;

        if (threadCounter < this.threadSize) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else
            notifyAll();
    }
}
