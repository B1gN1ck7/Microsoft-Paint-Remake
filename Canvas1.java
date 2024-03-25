import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Canvas1 extends JPanel implements MouseListener, MouseMotionListener {
    // Instance variables for drawing
    private int startX, startY; // Initial mouse position
    private int currentX, currentY; // Current mouse position
    private Color drawColor = Color.BLACK; // Default drawing color
    private boolean fill;

    public Canvas1() {
        // Set up JPanel
        setPreferredSize(new Dimension(800, 600)); // Set preferred size
        setBackground(Color.WHITE); // Set background color

        // Add mouse event listeners
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(drawColor); 
        Oval oval = new Oval(startX, startY, currentX - startX, currentY - startY, drawColor, fill);
        oval.draw(g);
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

    // Optional: Provide methods for setting drawing color, clearing canvas, etc.
    public void setDrawColor(Color color) {
        this.drawColor = color;
    }
    public boolean getFill(){return fill;}
    public void setFill(boolean fill){this.fill = fill;}

}
