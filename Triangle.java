import java.awt.*;

public class Triangle extends Shape implements TriangleInterface {

    private int[] xPoints;
    private int[] yPoints;
    private int numPoints;

    public Triangle(int[] xPoints, int[] yPoints, int numPoints, Color color, boolean fill) {
        super(xPoints[0], yPoints[0], color, fill);
        this.xPoints = xPoints;
        this.yPoints = yPoints;
        this.numPoints = numPoints;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        if (fill) {
            g.fillPolygon(xPoints, yPoints, numPoints);
        } else {
            g.drawPolygon(xPoints, yPoints, numPoints);
        }
    }
}
