
//Int Field Tester class from the book
//Basically takes in the number than if it's in the bounds, its says its all good
import java.awt.*; 
import java.awt.event.*;
 import javax.swing.*; 
 public class IntFieldTester extends JPanel implements ActionListener { 
    
    
    public static final int WIDTH = 300, HEIGHT = 300; 
    private JLabel prompt = new JLabel("Input an integer <= 100: ");  

    private IntFieldExtra intField = new IntFieldExtra(12,10,50);  
    private int userInt;   
    private String message = "Hello";   
            public IntFieldTester() {    
                add(prompt);     
                intField.addActionListener(this);     
                add(intField);    
                setSize(WIDTH, HEIGHT); } 
            
            
            public void paintComponent( Graphics g ) {
                g.setColor(getBackground());
                g.fillRect(0, 0, WIDTH, HEIGHT);    
                g.setColor(getForeground());     
                g.drawString(message, 10, 70);   }   
            
            
            public void actionPerformed(ActionEvent evt) {  
                try {userInt = intField.getInt();  
                    message = "You input " + userInt + " Thank you.";} 
                 catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this,"The input must be an integer. Please reenter.");} 
                catch (IntOutOfRangeException e) {
                    JOptionPane.showMessageDialog(this, e.getMessage());} 
                finally {repaint(); }  } 
            
            public static void main(String args[]) {
                JFrame f = new JFrame("IntField Tester");  
                IntFieldTester panel = new IntFieldTester(); 
                f.getContentPane().add(panel);   
                f.setSize(panel.WIDTH, panel.HEIGHT);    
                f.setVisible(true);    
                f.addWindowListener(new WindowAdapter() {      
                public void windowClosing(WindowEvent e) {        
                System.exit(0);      }});}}             
        
        
        
    