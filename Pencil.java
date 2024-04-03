/**
 * DESCRIPTION OF THE CLASS
 * @author Gibson Adema, Nick Wiley
 * @version 1.1
 * "We did not copy code from anything or anyone other than the CIS-172 textbook. We did not use AI to aid in the making of our code."
 */
import java.awt.*;
import java.util.ArrayList;

public class Pencil extends Drawing {
    private ArrayList<Point> pencilPoints;
    int font;

    public Pencil(ArrayList<Point> pencilPoints, ArrayList<ArrayList<Point>> pencilLinesy, int font, Color color){
        super(color);
        this.font = font;
        this.pencilPoints = pencilPoints;
    }

    public void draw(Graphics g){
        g.setColor(color);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setStroke(new BasicStroke(font));
        
        for (int i = 1; i < pencilPoints.size(); i++) {
            Point p1 = pencilPoints.get(i - 1);
            Point p2 = pencilPoints.get(i);
            g2d.drawLine(p1.x, p1.y, p2.x, p2.y);
        }   
    }

    public void addPoints(Point p){
        pencilPoints.add(p);
    }   
}
