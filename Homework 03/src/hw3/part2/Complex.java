package hw3.part2;

/**
 * Concrete Complex class.
 */
class Complex
{
    private double real, img;

    /**
     * Setter for real part.
     * @param real Gets real.
     */
    void setReal(final double real)
    {
        this.real = real;
    }

    /**
     * Setter for img part.
     * @param img Gets img.
     */
    void setImg(final double img)
    {
        this.img = img;
    }

    /**
     * Getter for real part.
     * @return Returns real.
     */
    final double getReal()
    {
        return this.real;
    }


    /**
     * Getter for img part.
     * @return Returns img.
     */
    final double getImg()
    {
        return this.img;
    }
}