import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Canvas1 extends JPanel implements MouseListener, MouseMotionListener {
    private int startX, startY; 
    private int currentX, currentY; 
    private Color drawColor = Color.RED;
    private boolean fill;
    private String currentShape = "";

    public Canvas1() {
        setPreferredSize(new Dimension(800, 600)); 
        setBackground(Color.WHITE);

        addMouseListener(this);
        addMouseMotionListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(drawColor); 
        if(currentShape.equals("")){}
        else if(currentShape.equals("oval")){
            if(currentX>startX){
                if(currentY>startY) {
                    Oval oval = new Oval(startX, startY, currentX - startX, currentY - startY, drawColor, fill);
                    oval.draw(g);
                } else {
                    Oval oval = new Oval(startX, currentY, currentX - startX, startY - currentY, drawColor, fill);
                    oval.draw(g);
                }
            } else {
                if(currentY>startY) {
                    Oval oval = new Oval(currentX, startY, startX - currentX, currentY - startY, drawColor, fill);
                    oval.draw(g);
                } else {
                    Oval oval = new Oval(currentX, currentY, startX - currentX, startY - currentY, drawColor, fill);
                    oval.draw(g);
                }
            }
        } else if (currentShape.equals("rectangle")) {
            if(currentX>startX){
                if(currentY>startY) {
                    Rectangle rectangle = new Rectangle(startX, startY, currentX - startX, currentY - startY, drawColor, fill);
                    rectangle.draw(g);
                } else {
                    Rectangle rectangle = new Rectangle(startX, currentY, currentX - startX, startY - currentY, drawColor, fill);
                    rectangle.draw(g);
                }
            } else {
                if(currentY>startY) {
                    Rectangle rectangle = new Rectangle(currentX, startY, startX - currentX, currentY - startY, drawColor, fill);
                    rectangle.draw(g);
                } else {
                    Rectangle rectangle = new Rectangle(currentX, currentY, startX - currentX, startY - currentY, drawColor, fill);
                    rectangle.draw(g);
                }
            }
        } else if (currentShape.equals("triangle")){
            if(currentY > startY) {
                int[] x = {startX, currentX, (startX+currentX)/2};
                int[] y = {currentY, currentY, startY};
                int numPoints = 3;
                Triangle triangle = new Triangle(x, y, numPoints, drawColor, fill);
                triangle.draw(g);
            } else {
                int[] x = {startX, currentX, (startX+currentX)/2};
                int[] y = {startY, startY, currentY};
                int numPoints = 3;
                Triangle triangle = new Triangle(x, y, numPoints, drawColor, fill);
                triangle.draw(g);
            }
        }
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
    public void mouseReleased(MouseEvent e) {}

    public void setDrawColor(Color color) {
        this.drawColor = color;
    }
    public boolean getFill() {return fill;}
    public String getCurrentShape() {return currentShape;}
    public Color getColor() {return drawColor;}
    public void setFill(boolean fill) {this.fill = fill;}
    public void setCurrentShape(String currentShape) {this.currentShape = currentShape;}
    public void setColor(Color drawColor) {this.drawColor = drawColor;}
}
