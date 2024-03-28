import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.util.List;

public class Canvas1 extends JPanel implements MouseListener, MouseMotionListener {
    private int startX, startY; 
    private int currentX, currentY; 
    private int fontsize;
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
        for (int i = 0; i < drawing.size(); i++) {
            Drawing currentDrawing = drawing.get(i);
            currentDrawing.draw(g);
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
        } else if(currentShape.equals("SolidLine")){
            int X = (startX);
            int Y = (startY);
            SolidLine solid = new SolidLine(X,Y,currentX, currentY, fontsize, drawColor);
            solid.draw(g);
        } else if(currentShape.equals("DashedLine")){
            int X = (startX);
            int Y = (startY);
            DashedLine dashed = new DashedLine(X,Y,currentX, currentY, fontsize, drawColor);
            dashed.draw(g);
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
        }else if(currentShape.equals("SolidLine")){
            SolidLine solid = new SolidLine(startX, startY, currentX, currentY, fontsize, drawColor);
            drawing.add(solid);
        } else if(currentShape.equals("DashedLine")){
            DashedLine dashed = new DashedLine(startX, startY, currentX, currentY, fontsize,  drawColor);
            drawing.add(dashed);
        } 
        repaint(); 
    }

    public void undoPressed() {
        currentShape = "";
        drawing.remove(drawing.size()-1);
        repaint();
    }

    public void resetCanvas(){
        currentShape = "";
        for (int i = drawing.size()-1; i > -1; i--) {
            drawing.remove(i);
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
    public Drawing getFirstDrawing() {
        if (!drawing.isEmpty()) {
            return drawing.get(0);
        } else {
            return null;
        }
    }
    public void setFill(boolean fill) {this.fill = fill;}
    public void setCurrentShape(String currentShape) {this.currentShape = currentShape;}
    public void setColor(Color drawColor) {this.drawColor = drawColor;}
    public void setFontSize(int fontsize) {this.fontsize = fontsize;}

}
