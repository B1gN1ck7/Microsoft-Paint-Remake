import java.awt.*;

public class Triangle implements TriangleInterface {
    private int[] x;
    private int[] y;
    private int numPoints;
    private Color color;
    private boolean fill;

    public Triangle(int[] x, int[] y, int numPoints, Color color, boolean fill) {
        this.x = x;
        this.y = y;
        this.numPoints = numPoints;
        this.color = color;
        this.fill = fill;
    }


    @Override
    public void draw(Graphics g) {
        if (fill) {
            g.setColor(color);
            g.fillPolygon(x, y, numPoints);
        } else {
            g.setColor(color);
            g.drawPolygon(x, y, numPoints);
        }
    }
}