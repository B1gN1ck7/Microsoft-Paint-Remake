// Shape.java -- can be extended as self-drawing rectangle, oval, etc.

import java.awt.*;

public abstract class Shape {

    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected Color color;
    protected boolean fill;

    public Shape(int x, int y, int width, int height, Color color, boolean fill) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
        this.fill = fill;
    }

    public int getX() {return x;}
    public int getY() {return y;}
    public int getWidth() {return width;}
    public int getHeight() {return height;}
    public Color getColor() {return color;}
    public boolean getFill() {return fill;}
    public void setX(int x) {this.x = x;}
    public void setY(int y) {this.y = y;}
    public void setwidth(int width) {this.width = width;}
    public void setheight(int height) {this.height = height;}
    public void setColor(Color color) {this.color = color;}
    public void setFill(boolean fill) {this.fill = fill;}

    public abstract void draw(Graphics g);
}
