import java.awt.*;

public class DashedLine extends Line{
    public DashedLine(int X, int Y, int currentX, int currentY, Color color){
        super(X,Y,color);
        this.currentX = currentX;
        this.currentY = currentY;
    }
    @Override
    public void draw(Graphics g) {
        
            g.setColor(color);
            Graphics2D g2d = (Graphics2D) g;
            Stroke dashed = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL,
                                  0, new float[]{9}, 0);
            g2d.setStroke(dashed);
           g2d.drawLine(x, y, currentX, currentY);
    }
}
