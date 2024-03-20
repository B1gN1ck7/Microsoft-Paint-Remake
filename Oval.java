// Oval.java -- draws a circle

import java.awt.*;

public class Oval extends Shape {

    public Oval(int x, int y, int width, int height, Color color) {
        super(x, y, width, height, color);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x,y,width,height);
    }
    
}
