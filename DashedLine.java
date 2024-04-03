/**
 * DESCRIPTION OF THE CLASS
 * @author Gibson Adema, Nick Wiley
 * @version 1.1
 * "We did not copy code from anything or anyone other than the CIS-172 textbook. We did not use AI to aid in the making of our code."
 */
import java.awt.*;

public class DashedLine extends Line{
    public DashedLine(int X, int Y, int currentX, int currentY, int font, Color color){
        super(X,Y,color, font);
        this.currentX = currentX;
        this.currentY = currentY;
    }
    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        Graphics2D g2d = (Graphics2D) g.create();
        Stroke dashed = new BasicStroke(font, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
        g2d.setStroke(dashed);
        g2d.drawLine(x, y, currentX, currentY);
        g2d.dispose();
    }
}
