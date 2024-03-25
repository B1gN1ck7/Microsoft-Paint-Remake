import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Canvas1 extends JPanel implements MouseListener, MouseMotionListener {
    private int startX, startY; 
    private int currentX, currentY; 
    private Color drawColor = Color.RED;
    private boolean fill;
    private String currentShape = "";
    private int printListNum = 0;
    private int ovalNum = 0;
    private int rectNum = 0;
    private int triNum = 0;

    public Canvas1() {
        setPreferredSize(new Dimension(800, 600)); 
        setBackground(Color.WHITE);

        addMouseListener(this);
        addMouseMotionListener(this);
    }

    String[] printList = new String[50];
    Oval oval[] = new Oval[10];
    Rectangle rectangle[] = new Rectangle[10];
    Triangle triangle[] = new Triangle[10];

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(currentShape.equals("")){}
        else if(currentShape.equals("oval")){
            if(currentX>startX){
                if(currentY>startY) {
                    oval[ovalNum] = new Oval(startX, startY, currentX - startX, currentY - startY, drawColor, fill);
                } else {
                    oval[ovalNum] = new Oval(startX, currentY, currentX - startX, startY - currentY, drawColor, fill);
                }
            } else {
                if(currentY>startY) {
                    oval[ovalNum] = new Oval(currentX, startY, startX - currentX, currentY - startY, drawColor, fill);
                } else {
                    oval[ovalNum] = new Oval(currentX, currentY, startX - currentX, startY - currentY, drawColor, fill);
                }
            }
        } else if (currentShape.equals("rectangle")) {
            if(currentX>startX){
                if(currentY>startY) {
                    rectangle[rectNum] = new Rectangle(startX, startY, currentX - startX, currentY - startY, drawColor, fill);
                } else {
                    rectangle[rectNum] = new Rectangle(startX, currentY, currentX - startX, startY - currentY, drawColor, fill);
                }
            } else {
                if(currentY>startY) {
                    rectangle[rectNum] = new Rectangle(currentX, startY, startX - currentX, currentY - startY, drawColor, fill);
                } else {
                    rectangle[rectNum] = new Rectangle(currentX, currentY, startX - currentX, startY - currentY, drawColor, fill);
                }
            }
        } else if (currentShape.equals("triangle")){
            if(currentY > startY) {
                int[] x = {startX, currentX, (startX+currentX)/2};
                int[] y = {currentY, currentY, startY};
                int numPoints = 3;
                triangle[triNum] = new Triangle(x, y, numPoints, drawColor, fill);
            } else {
                int[] x = {startX, currentX, (startX+currentX)/2};
                int[] y = {startY, startY, currentY};
                int numPoints = 3;
                triangle[triNum] = new Triangle(x, y, numPoints, drawColor, fill);
            }
        }
        calldraw(g);
    }    

    @Override
    public void mousePressed(MouseEvent e) {
        startX = e.getX();
        startY = e.getY();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        currentX = e.getX();
        currentY = e.getY();
        repaint(); 
    }

   
    @Override
    public void mouseClicked(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
    @Override
    public void mouseMoved(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {
        if(currentShape.equals("oval")){ovalNum++; printList[printListNum] = "oval";}
        else if(currentShape.equals("rectangle")){rectNum++; printList[printListNum] = "rectangle";}
        else if(currentShape.equals("triangle")){triNum++; printList[printListNum] = "triangle";}

        printListNum++;
    }

    public void setDrawColor(Color color) {
        this.drawColor = color;
    }
    public boolean getFill() {return fill;}
    public String getCurrentShape() {return currentShape;}
    public Color getColor() {return drawColor;}
    public void setFill(boolean fill) {this.fill = fill;}
    public void setCurrentShape(String currentShape) {this.currentShape = currentShape;}
    public void setColor(Color drawColor) {this.drawColor = drawColor;}

    
    public void calldraw(Graphics g) {
        int o = 0; // counter for ovals
        int r = 0; // counter for rectangles
        int t = 0; // counter for triangles
    
        for (int n = 0; n < printListNum+1; n++) { //n = the counter to go through all of the shapes in printList
            if (printList[n].equals("oval")) {
                oval[o].draw(g);
                o++;
            } else if (printList[n].equals("rectangle")) {
                rectangle[r].draw(g);
                r++;
            } else if (printList[n].equals("triangle")) {
                triangle[t].draw(g);
                t++;
            } 
        }
    }
}
    
