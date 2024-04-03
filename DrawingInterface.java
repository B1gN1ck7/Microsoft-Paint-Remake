import java.awt.*;

public interface DrawingInterface {
    int getX();
    int getY();
    Color getColor();
    void setX(int x);
    void setY(int y);
    void setColor(Color color);

    void draw(Graphics g);
}
