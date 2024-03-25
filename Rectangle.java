// Rectangle.java -- draws a rectangle

import java.awt.*;

public class Rectangle extends Shape {

    public Rectangle(int x, int y, int width, int height, Color color, boolean fill) {
        super(x, y, width, height, color, fill);
    }

    @Override
    public void draw(Graphics g) {
        if(fill) {
            g.setColor(color);
            g.fillRect(x,y,width,height); 
        } else {
            g.setColor(color);
            g.drawRect(x,y,width,height);
        }
    }
}
