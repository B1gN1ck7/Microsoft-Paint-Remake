import java.awt.*;

public abstract class Shape extends Drawing {

    protected int width;
    protected int height;
    protected boolean fill;

    public Shape(int x, int y, Color color, boolean fill) {
        super(x, y, color);
        this.fill = fill;
    }

    public boolean getFill() { return fill; }
    public void setFill(boolean fill) { this.fill = fill; }

    public abstract void draw(Graphics g);
}
