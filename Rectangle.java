/**
 * This class is what paints the rectangle and is the constructor that holds the objects to paint the rectangles.
 * @author Gibson Adema, Nick Wiley
 * @version 1.1
 * "We did not copy code from anything or anyone other than the CIS-172 textbook. We did not use AI to aid in the making of our code."
 */
import java.awt.*;

public class Rectangle extends Shape {

    /**
     * width of the rectangle
     */
    private int width;
    /**
     * height of the rectangle
     */
    private int height;
    /**
     * Constructor for the Rectangle class.
     * @param x sets the location  
     * @param y sets the location
     * @param width sets the width
     * @param height sets the height
     * @param color sets the color 
     * @param fill determines whether to draw or fill the rectangle
     */
    public Rectangle(int x, int y, int width, int height, Color color, boolean fill) {
        super(x, y, color, fill);
        this.width = width;
        this.height = height;
    }

    /**
     * This is what draws the rectangle
     * @param g is what makes the drawing on the canvas work
     */
    @Override
    public void draw(Graphics g) {
        if(fill) {
            g.setColor(color);
            g.fillRect(x,y,width,height); 
        } else {
            g.setColor(color);
            g.drawRect(x,y,width,height);
        }
    }
}
