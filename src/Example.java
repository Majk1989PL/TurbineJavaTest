/**
 * Created by Robert on 2017-12-03.
 */
import java.awt.Dimension;
/**
 * Example class. The x and y values should never
 * be negative.
 */
public class Example
{
    private Dimension d = new Dimension (0, 0);
    public Example () {}
    /**
     * Set height and width. Both height and width must be nonnegative
     * or an exception is thrown.
     */
    public synchronized void setValues (int height, int width)
            throws IllegalArgumentException
    {
        if (height < 0 || width < 0)
            throw new IllegalArgumentException();
        d.height = height;
        d.width = width;
    }
    public synchronized Dimension getValues()
    {
// Passing member content by reference
        return d;
    }
}