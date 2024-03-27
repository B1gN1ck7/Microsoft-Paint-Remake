import java.awt.*;

public abstract class Line extends Drawing{


    protected int startX, startY, currentX, currentY;
    public Line(int X, int Y, Color color){
        super(X,Y, color);
    
    }
public abstract void draw(Graphics g);

}
