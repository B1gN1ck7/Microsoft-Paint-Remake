

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.util.List;

public class Canvas1 extends JPanel implements MouseListener, MouseMotionListener {
    private int startX, startY; 
    private int currentX, currentY; 
    private Color drawColor = Color.RED;
    private boolean fill;
    private String currentShape = "";
    private List<Drawing> drawing = new ArrayList<>();

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
        for (Drawing drawing : drawing) {
            drawing.draw(g);
        }
        g.setColor(drawColor);
    if (currentShape.equals("oval")) {
        int x = Math.min(startX, currentX);
        int y = Math.min(startY, currentY);
        int width = Math.abs(currentX - startX);
        int height = Math.abs(currentY - startY);
        Oval oval = new Oval(x, y, width, height, drawColor, fill);
        oval.draw(g);
    } else if (currentShape.equals("rectangle")) {
        int x = Math.min(startX, currentX);
        int y = Math.min(startY, currentY);
        int width = Math.abs(currentX - startX);
        int height = Math.abs(currentY - startY);
        Rectangle rectangle = new Rectangle(x, y, width, height, drawColor, fill);
        rectangle.draw(g);
    } else if (currentShape.equals("triangle")) {
        int[] x = {startX, currentX, (startX + currentX) / 2};
        int[] y = {currentY, currentY, startY};
        if (currentY <= startY) {
            y = new int[] {startY, startY, currentY};
        }
        Triangle triangle = new Triangle(x, y, 3, drawColor, fill);
        triangle.draw(g);
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

    public void mouseReleased(MouseEvent e) {
        if (currentShape.equals("oval")) {
            int x = Math.min(startX, currentX);
            int y = Math.min(startY, currentY); 
            int width = Math.abs(currentX - startX);
            int height = Math.abs(currentY - startY);
            
            Oval oval = new Oval(x, y, width, height, drawColor, fill);
            drawing.add(oval);
        } else if (currentShape.equals("rectangle")) {
            int x = Math.min(startX, currentX);
            int y = Math.min(startY, currentY);
            int width = Math.abs(currentX - startX);
            int height = Math.abs(currentY - startY);
            
            Rectangle rectangle = new Rectangle(x, y, width, height, drawColor, fill);
            drawing.add(rectangle);
        } else if (currentShape.equals("triangle")) {
            int[] x = {startX, currentX, (startX + currentX) / 2};
            int[] y = {currentY, currentY, startY};
            if (currentY <= startY) {
                y = new int[] {startY, startY, currentY};
            }
            Triangle triangle = new Triangle(x, y, 3, drawColor, fill);
            drawing.add(triangle);
        } 
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

    public void setDrawColor(Color color) {this.drawColor = color;}
    public boolean getFill() {return fill;}
    public String getCurrentShape() {return currentShape;}
    public Color getColor() {return drawColor;}
    public void setFill(boolean fill) {this.fill = fill;}
    public void setCurrentShape(String currentShape) {this.currentShape = currentShape;}
    public void setColor(Color drawColor) {this.drawColor = drawColor;}
}
