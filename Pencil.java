import java.awt.*;
import java.util.ArrayList;

public class Pencil extends Drawing {

    private ArrayList<Point> pencilPoints;
    private static ArrayList<ArrayList<Point>> pencilLines;
    int font;

    public Pencil(ArrayList<Point> pencilPoints, ArrayList<ArrayList<Point>> pencilLinesy, int font, Color color){
        super(color);
        this.font = font;
        this.pencilPoints = pencilPoints;
        pencilLines = pencilLinesy;
    }

    public void draw(Graphics g){
        g.setColor(color);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setStroke(new BasicStroke(font));
        
        for(ArrayList<Point> thePoint : pencilLines){
       for (int i = 1; i < thePoint.size(); i++) {
        Point p1 = thePoint.get(i - 1);
        Point p2 = thePoint.get(i);
        g2d.drawLine(p1.x, p1.y, p2.x, p2.y);
    }}


    }

    public void addPoints(Point p){
pencilPoints.add(p);
    }

    public static void setPencilLines(ArrayList<ArrayList<Point>> pencilLinesy){
            pencilLines = pencilLinesy;
    }
}
