import java.awt.*;

public abstract class Line extends Drawing{

    
    protected int startX, startY, currentX, currentY, font;
    public Line(int X, int Y, Color color, int font){
        super(X,Y, color);
    this.font = font;
    }
public abstract void draw(Graphics g);

}
