/**
 * This is the Interface for the drawing class and hold all of he stuff that the drawing class needs to implement. 
 * @author Gibson Adema, Nick Wiley
 * @version 1.1
 * "We did not copy code from anything or anyone other than the CIS-172 textbook. We did not use AI to aid in the making of our code."
 */
import java.awt.*;

public interface DrawingInterface {
    int getX();
    int getY();
    Color getColor();
    void setX(int x);
    void setY(int y);
    void setColor(Color color);

    /**
     * This is the draw fuction that will draw on the canvas. Will be coded in in later classes
     * @param g is what will make th drawing on a canvas availble. 
     */
    void draw(Graphics g);
}
