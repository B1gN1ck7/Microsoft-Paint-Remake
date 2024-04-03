/**
 * Draws the shapes/ lines/ pencils and holds everything todo with the Canvas
 * @author Gibson Adema, Nick Wiley
 * @version 1.1
 * "We did not copy code from anything or anyone other than the CIS-172 textbook. We did not use AI to aid in the making of our code."
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.util.List;

public class Canvas1 extends JPanel implements MouseListener, MouseMotionListener {
    /**
     * When the mouse is clicked startX and startY is created. 
     */
    private int startX, startY; 
    /**
     * When the mouse is dragged startX and startY is created. 
     */
    private int currentX, currentY; 
    /**
     * Chenges the size of the pencil/eraser/ line thickness. 
     */
    private int fontsize;
    /**
     * Drawing Color
     */
    private Color drawColor = Color.RED;
    /**
     *  Set by the buttons and used to differentiate the different draw or fill commands.
     */
    private boolean fill;
    /**
     *  Checks if the mouse was dragged or just pressed.
     */
    private boolean dragging;
    /**
     * Saves what the current shape is to know what to paint on the canvas. 
     */
    private String currentShape = "";
    /**
     *  
     */
    private ArrayList<ArrayList<Point>> pencilLines = new ArrayList<>();
    /**
     *  
     */
    private ArrayList<Point> currentLine = new ArrayList<>();
    /**
     *  
     */
    private ArrayList<Point> nullLine = new ArrayList<>();
    /**
     *  Array List of drawings to reprint 
     */
    private List<Drawing> drawing = new ArrayList<>();
    
    /**
     *  Constructor sets the size, background color and actionlisteners for the class.
     */
    public Canvas1() {
        setPreferredSize(new Dimension(800, 600)); 
        setBackground(Color.WHITE);
        nullLine.add(new Point(0,0));
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    /**
     *  Paints the components onto the canvas.
     * @param Graphics g is the painting component that makes it works. 
     */
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
            SolidLine solid = new SolidLine(startX,startY,currentX, currentY, fontsize, drawColor);
            solid.draw(g);
        } else if(currentShape.equals("DashedLine")){
            DashedLine dashed = new DashedLine(startX,startY,currentX, currentY, fontsize, drawColor);
            dashed.draw(g);
        }else if(currentShape.equals("Pencil")){
            Pencil pencil = new Pencil(currentLine, pencilLines, fontsize, drawColor);
            pencil.draw(g);
        }else if(currentShape.equals("Eraser")){
            Pencil pencil = new Pencil(currentLine, pencilLines, fontsize, Color.WHITE);
            pencil.draw(g);
        }

        
    }

    /**
     *  ActionListener for the mousePressedEvent. start X and Y are set and dragging is set to false and if pencil or eraser is choosen then it is intantiated to work. 
     * @param MouseEvent e is what is happenign with the mouse.
     */
    @Override
    public void mousePressed(MouseEvent e) {
        startX = e.getX();
        startY = e.getY();
        dragging = false;
        if(currentShape.equals("Pencil")){
            currentLine = new ArrayList<>();
            currentLine.add(e.getPoint());
            pencilLines.add(currentLine);}
        else if(currentShape.equals("Eraser")){
            currentLine = new ArrayList<>();
            currentLine.add(e.getPoint());
            pencilLines.add(currentLine);}
    }

    /**
     *  Listens for mouse dragged and sets current X and Y is set and dragging is set to true and the canvas is repainted. 
     */
    @Override
    public void mouseDragged(MouseEvent e) {
        currentX = e.getX();
        currentY = e.getY();
        dragging = true;
        if(currentShape.equals("Pencil")){
            currentLine.add(e.getPoint());}
        else if(currentShape.equals("Eraser")){
            currentLine.add(e.getPoint());}
        repaint(); 
       
    }

    /**
     *  This listens for the mouse to be released and then when it is released it checks if the mouse was dragged vs just clicked and then the current shape is added to shapes to then be repainted everytime.
     * @param MouseEvent e is the input of the mouse and how to get all of the variables.
     */
    public void mouseReleased(MouseEvent e) {
        if(!dragging){}
        else if (currentShape.equals("oval")) {
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
        } else if(currentShape.equals("Pencil")){
            Pencil pencil = new Pencil(currentLine, pencilLines, fontsize, drawColor);
            drawing.add(pencil);
        }  else if(currentShape.equals("Eraser")){
            Pencil pencil = new Pencil(currentLine, pencilLines, fontsize, Color.WHITE);
            drawing.add(pencil);
        } 
        
        if(dragging){repaint();}
    }

    /**
     *  Undopressed takes the last painted thing off of the canvas
     */
    public void undoPressed() {
        if(drawing.get(drawing.size()-1) instanceof Pencil)
        {pencilLines.get(pencilLines.size()-1).clear();}
        currentShape = "";
        drawing.remove(drawing.size()-1);
        repaint();
    }

    /**
     *  Clears Canvas
     */
    public void resetCanvas(){
        currentShape = "";
        pencilLines.clear();
        for (int i = drawing.size()-1; i > -1; i--) {
            drawing.remove(i);
        }
        repaint();
    }

    /**
     * Entered just to not make runtime error.
     */
    @Override
    public void mouseClicked(MouseEvent e) {}
    /**
     * Entered just to not make runtime error.
     */
    @Override
    public void mouseEntered(MouseEvent e) {}
    /**
     * Entered just to not make runtime error.
     */
    @Override
    public void mouseExited(MouseEvent e) {}
    /**
     * Entered just to not make runtime error.
     */
    @Override
    public void mouseMoved(MouseEvent e) {}

    
    public void setDrawColor(Color color) {this.drawColor = color;}
    public boolean getFill() {return fill;}
    public String getCurrentShape() {return currentShape;}
    public Color getColor() {return drawColor;}

    /**
     * returns the first drawing unless there is none in which case it returns null
     * @returns first drawing or null
     */
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
    /**
     * 
     */ 
    public ArrayList<ArrayList<Point>> getLines(){
        return pencilLines;
    }
}
