import java.awt.*;

public class Oval extends Shape {

    public Oval(int x, int y, int width, int height, Color color, boolean fill) {
        super(x, y, width, height, color, fill);
    }

    // Override the draw method to perform drawing operations
    @Override
    public void draw(Graphics g) {
        if (fill) {
            g.setColor(color);
            g.fillOval(x, y, width, height);
        } else {
            g.setColor(color);
            g.drawOval(x, y, width, height);
        }
    }
}

