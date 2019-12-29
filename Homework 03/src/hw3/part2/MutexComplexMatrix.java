package hw3.part2;

import java.util.concurrent.Semaphore;

/**
 * Mutex Complex Matrix concrete class.
 */
public class MutexComplexMatrix extends ComplexMatrix
{
    private Semaphore mutex = new Semaphore(0);

    /**
     * MutexComplexMatrix constructor for single thread.
     * @param N Gets NxN.
     */
    MutexComplexMatrix(int N)
    {
        super(N);
    }

    /**
     * MutexComplexMatrix constructor for multiple threads.
     * @param N Gets NxN.
     * @param threadSize Gets threads size.
     */
    MutexComplexMatrix(int N, int threadSize)
    {
        super(N, threadSize);
    }

    /**
     * Creates sum of A and B arrays using mutex.
     * And waits all threads to sum.
     */
    @Override
    protected void createSumArray()
    {
        ++threadCounter;

        if (threadCounter < this.threadSize) {
            try {
                mutex.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else
            for (int i = 0; i < this.threadSize; ++i)
                mutex.release();
    }
}
