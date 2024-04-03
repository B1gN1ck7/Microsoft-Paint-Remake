/**
 * This is the top class and what is used to store all of the other classes under it. It is used in Canvas to keep track of all of the drawings in the class.
 * @author Gibson Adema, Nick Wiley
 * @version 1.1
 * "We did not copy code from anything or anyone other than the CIS-172 textbook. We did not use AI to aid in the making of our code."
 */
import java.awt.*;

public abstract class Drawing implements DrawingInterface {
    /**
     * sets the location of the drawing
     */
    protected int x, y;
    /**
     * Sets the color of the drawing
     */
    protected Color color;

    /**
     * First constructor of the Drawing class. This is used for the lines and shapes classes and everything that is used from there. 
     * @param x location of the drawing
     * @param y location of the drawing 
     * @param color color of the drawing 
     */
    public Drawing(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    /**
     * Second constructor of the Drawing class. This is used for the pencil and eraser classes and is used to make it of object type Drawing. 
     * @param color color of the drawing 
     */
    public Drawing(Color color) {
        this.color = color;
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public Color getColor() { return color; }
    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }
    public void setColor(Color color) { this.color = color; }

    /**
     * Abstract drawing function that will be implemented later in another class.
     */
    public abstract void draw(Graphics g);
}
