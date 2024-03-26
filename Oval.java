import java.awt.*;

public class Oval extends Shape {

    private int width;
    private int height;

    public Oval(int x, int y, int width, int height, Color color, boolean fill) {
        super(x, y, color, fill);
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        if (fill) {
            g.fillOval(x, y, width, height);
        } else {
            g.drawOval(x, y, width, height);
        }
    }
}
