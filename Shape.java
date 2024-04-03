/**
 * This class extends drawing and further classifies the Drawing class.
 * @author Gibson Adema, Nick Wiley
 * @version 1.1
 * "We did not copy code from anything or anyone other than the CIS-172 textbook. We did not use AI to aid in the making of our code."
 */
import java.awt.*;

public abstract class Shape extends Drawing {
    /**
     * fill is what determines whether or not to draw or fill the shapes. 
     */
    protected boolean fill;

    /**
     * Constructor for Shape thatallows for better organization and more distinct constructor parameters.
     * @param x location of the shape
     * @param y location of the shape
     * @param color color of the shape
     * @param fill fill or draw the shape. 
     */
    public Shape(int x, int y, Color color, boolean fill) {
        super(x, y, color);
        this.fill = fill;
    }

    public boolean getFill() { return fill; }
    public void setFill(boolean fill) { this.fill = fill; }

    /**
     * Abstract class of draw that will be implemented later into code. 
     * @param g is what makes the drawing possible on the canvas.
     */
    public abstract void draw(Graphics g);
}
