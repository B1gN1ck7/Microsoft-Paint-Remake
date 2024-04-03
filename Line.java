/**
 * DESCRIPTION OF THE CLASS
 * @author Gibson Adema, Nick Wiley
 * @version 1.1
 * "We did not copy code from anything or anyone other than the CIS-172 textbook. We did not use AI to aid in the making of our code."
 */
import java.awt.*;

public abstract class Line extends Drawing{
    protected int startX, startY, currentX, currentY, font;

    public Line(int X, int Y, Color color, int font){
        super(X,Y, color);
        this.font = font;
    }

    public abstract void draw(Graphics g);
}
