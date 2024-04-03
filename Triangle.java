/**
 * This class is what paints the triangles and is the constructor that holds the objects to paint the triangles.
 * @author Gibson Adema, Nick Wiley
 * @version 1.1
 * "We did not copy code from anything or anyone other than the CIS-172 textbook. We did not use AI to aid in the making of our code."
 */
import java.awt.*;

public class Triangle extends Shape {
    /**
     * Array of the x coordinates of the points of the triangle
     */
    private int[] xPoints;
    /**
     * Array of the y coordinates of the points of the triangle
     */
    private int[] yPoints;
    /**
     * Number of points on the triangle, whill always be 3
     */
    private int numPoints;

    /**
     * Constructor for the Triangle Class
     * @param xPoints array of x cordinates to set as the corners of the triangle
     * @param yPoints array of y coordinates to set as the corners of the trianle
     * @param numPoints number of points on the triangle, 3
     * @param color color of the triangle 
     * @param fill variable to choose whether to fill or not fill the triangles.
     */
    public Triangle(int[] xPoints, int[] yPoints, int numPoints, Color color, boolean fill) {
        super(xPoints[0], yPoints[0], color, fill);
        this.xPoints = xPoints;
        this.yPoints = yPoints;
        this.numPoints = numPoints;
    }

    /**
     * Draws the triangles 
     * @param g is what makes the drawing o nthe canvas possible. 
     */
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
