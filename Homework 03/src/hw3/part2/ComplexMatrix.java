package hw3.part2;

import java.util.Arrays;

/**
 * Abstract class for Template Design.
 */
abstract class ComplexMatrix
{
    protected Complex[][] dftSum;
    protected Complex[] sum;
    protected final int N;
    protected int threadSize;
    protected int threadCounter = 0;
    protected int columnMax = 0;
    protected int rowMax = 0;
    protected int columnIndex = 0;
    protected int rowIndex = 0;
    protected int threadArraySize = 0;
    protected int mainThreadTime;
    protected int otherThreadTime = 0;
    protected int totalThreadTime = 0;

    /**
     * ComplexMatrix constructor for main thread.
     * @param N Gets NxN size.
     */
    ComplexMatrix(final int N)
    {
        this.threadCounter = 0;
        this.mainThreadTime = (int) System.currentTimeMillis();
        this.N = N;
        this.dftSum = new Complex[N][N];
        for (int i = 0; i < N; ++i)
            this.dftSum[i] = new Complex[N];
    }

    /**
     * ComplexMatrix constructor for multiple threads.
     * @param N Gets NxN size.
     * @param threadSize Gets threads size.
     */
    ComplexMatrix(final int N, final int threadSize)
    {
        this.threadCounter = 0;
        this.mainThreadTime = (int) System.currentTimeMillis();
        this.otherThreadTime = (int) System.currentTimeMillis();
        this.threadSize = threadSize;
        this.N = N;
        this.columnMax = (int) Math.sqrt(threadSize);
        this.rowMax = (int) Math.sqrt(threadSize);
        this.threadArraySize = N / this.rowMax;
        this.dftSum = new Complex[N][N];
        for (int i = 0; i < N; ++i)
        {
            this.dftSum[i] = new Complex[N];
            for (int j = 0; j < this.dftSum[i].length; ++j)
                dftSum[i][j] = new Complex();
        }
        this.sum = new Complex[this.threadArraySize];
        for (int i = 0; i < sum.length; ++i)
            sum[i] = new Complex();
    }

    /**
     * Creates and evaluates for single thread.
     */
    void createForMainThread()
    {
        Complex[] sum = new Complex[N];

        for (int i = 0; i < N; ++i)
        {
            sum[i] = new Complex();
            sum[i].setReal(Math.random() * 20 - 10 + Math.random() * 20 - 10);
            sum[i].setImg(Math.random() * 20 - 10 + Math.random() * 20 - 10);
        }

        for (int i = 0; i < N; ++i)
        {
            sum = calculateDFT(sum);

            for (int j = 0; j < N; ++j)
            {
                dftSum[i][j] = new Complex();
                dftSum[i][j].setReal(sum[j].getReal());
                dftSum[i][j].setImg(sum[j].getImg());
            }
        }
        mainThreadTime = (int) (System.currentTimeMillis() - mainThreadTime);
    }

    /**
     * Template method to create results.
     */
    void createResult()
    {
        try {
            for (Complex complex : this.sum)
            {
                complex.setReal(Math.random() * 20 - 10 + Math.random() * 20 - 10);
                complex.setImg(Math.random() * 20 - 10 + Math.random() * 20 - 10);
            }
            createSumArray();
            createDFTArray();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Creates DFT arrays.
     */
    protected void createDFTArray()
    {
        if (this.rowIndex >= this.rowMax)
            this.rowIndex = 0;

        for (int i = 0; i < this.threadArraySize; ++i)
        {
            this.sum = calculateDFT(this.sum);

            for (int j = 0; j < this.threadArraySize; ++j)
            {
                dftSum[i + rowIndex * this.threadArraySize][j + this.columnIndex * this.threadArraySize].setReal(this.sum[j].getReal());
                dftSum[i + rowIndex * this.threadArraySize][j + this.columnIndex * this.threadArraySize].setImg(this.sum[j].getImg());
            }
        }

        ++this.columnIndex;

        if (this.columnIndex >= this.columnMax)
        {
            ++this.rowIndex;
            this.columnIndex = 0;
        }

        this.totalThreadTime += (int) (System.currentTimeMillis() - this.otherThreadTime);
    }

    /**
     * Abstract creates sum of A B arrays.
     * @throws InterruptedException Throws for threads.
     */
    protected abstract void createSumArray() throws InterruptedException;

    /**
     * Evaluates DFT for each array.
     * @param inputs Gets input array.
     * @return Returns the DFT result.
     */
    protected Complex[] calculateDFT(Complex[] inputs)
    {
        Complex[] results = new Complex[inputs.length];
        Arrays.setAll(results, i -> new Complex());

        for (int i = 0; i < this.threadArraySize; ++i)
        {
            double sumReal = 0;
            double sumImg = 0;

            for (int j = 0; j < this.threadArraySize; ++j)
            {
                double angle = 2 * Math.PI * j * i / this.threadArraySize;
                sumReal += inputs[j].getReal() * Math.cos(angle) + inputs[j].getImg() * Math.sin(angle);
                sumImg += -inputs[j].getReal() * Math.sin(angle) + inputs[j].getImg() * Math.cos(angle);
            }
            results[i].setReal((int) sumReal);
            results[i].setImg((int) sumImg);
        }

        return results;
    }

    /**
     * Single Thread time.
     * @return Returns single thread time.
     */
    final int getMainThreadTime()
    {
        return this.mainThreadTime;
    }

    /**
     * Multiple Thread time.
     * @return Returns multiple threads time.
     */
    final int getOtherThreadTime()
    {
        return this.totalThreadTime/threadSize;
    }
}
