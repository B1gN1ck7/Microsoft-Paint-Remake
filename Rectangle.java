// Rectangle.java -- draws a rectangle

import java.awt.*;

public class Rectangle extends Shape {

    public Rectangle(int x, int y, int width, int height, Color color) {
        super(x, y, width, height, color);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x,y,width,height);
    }
}
