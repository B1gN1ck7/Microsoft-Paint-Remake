import java.awt.*;

public class SolidLine extends Line{


    public SolidLine(int X, int Y, int currentX, int currentY, int font, Color color){
        super(X,Y,color,font);
        this.currentX = currentX;
        this.currentY = currentY;
    }
    @Override
    public void draw(Graphics g) {
        
            g.setColor(color);
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setStroke(new BasicStroke(font));
           g2d.drawLine(x, y, currentX, currentY);
    }
}
