/**
 * This class launches the GUI and handles anything within the toolbar and sets variabales in the Canvas1 class.
 * @author Gibson Adema, Nick Wiley
 * @version 1.1
 * "We did not copy code from anything or anyone other than the CIS-172 textbook. We did not use AI to aid in the making of our code."
 */
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.awt.image.*;
import javax.swing.*;

public class GUI extends JFrame {
    public static void main(String[] args) {
        new GUI();
    }
    /**
     * Toolbar that holds all of the buttons and panels. 
     */
    private JToolBar toolbar;
    /**
     * Array of buttons that is going into be in the Toolbar.
     */
    private JButton[][] button;
    /**
     * Array of panels used to store the buttons and keep organization within the toolbar.
     */
    private JPanel[] panel;
    /**
     * This box is what is used to change the font size. 
     */
    private JComboBox<String> fontsizeBox;
    /**
     * This button is what is used to undo the last thing on the canvas.
     */
    private JButton undoButton;
    /**
     * This label is what shows when there is an error with the undo and when the file is saved. 
     */
    private JLabel undoError;
    
    /**
     * all of the vaiables for the Color selection box. 
     */
    protected int x, y, width, height;
    protected Color color;
    protected boolean fill;
    /**
     * Object for the Canvas1 to refrence changing variables. 
     */
    private Canvas1 mainCanvas = new Canvas1();

    /**
     * Constructor for the class. This is what launches the GUI and starts all of the ActionListeners to work with the Toolbar. 
     */
    public GUI() {
        int w = 1250;
        int h = 700;
        setTitle("Paint");
        setSize(w, h);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        toolbar = new JToolBar();

        panel = new JPanel[7];     //Instantiate the panels and buttons 
        button = new JButton[2][5];

        for (int col = 0; col < 5; col++) {
            panel[col] = new JPanel();
            button[0][col] = new JButton();
            button[1][col] = new JButton();

            panel[col].setLayout(new GridLayout(2, 1)); //add Buttons to panels
            panel[col].add(button[0][col]);
            panel[col].add(button[1][col]);

            toolbar.add(panel[col]); //add panels to toolbar
        }
        
        String imagePath = "images//filledCircle.png"; //add images to the buttons
        ImageIcon icon = new ImageIcon(imagePath);
        ImageIcon resizedIcon = new ImageIcon(icon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
        button[0][0].setIcon(resizedIcon);

        imagePath = "images//drawCircle.png"; //add images to the buttons
        icon = new ImageIcon(imagePath);
        resizedIcon = new ImageIcon(icon.getImage().getScaledInstance(60, 40, Image.SCALE_SMOOTH));
        button[1][0].setIcon(resizedIcon);

        imagePath = "images//filledSquare.png"; //add images to the buttons
        icon = new ImageIcon(imagePath);
        resizedIcon = new ImageIcon(icon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
        button[0][1].setIcon(resizedIcon);

        imagePath = "images//drawSquare.png"; //add images to the buttons
        icon = new ImageIcon(imagePath);
        resizedIcon = new ImageIcon(icon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
        button[1][1].setIcon(resizedIcon);

        imagePath = "images//filledTriangle.png"; //add images to the buttons
        icon = new ImageIcon(imagePath);
        resizedIcon = new ImageIcon(icon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
        button[0][2].setIcon(resizedIcon);

        imagePath = "images//drawtriangle.png"; //add images to the buttons
        icon = new ImageIcon(imagePath);
        resizedIcon = new ImageIcon(icon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
        button[1][2].setIcon(resizedIcon);

        imagePath = "images//line.png"; //add images to the buttons
        icon = new ImageIcon(imagePath);
        resizedIcon = new ImageIcon(icon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
        button[0][3].setIcon(resizedIcon);

        imagePath = "images//dashedLine.png"; //add images to the buttons
        icon = new ImageIcon(imagePath);
        resizedIcon = new ImageIcon(icon.getImage().getScaledInstance(80, 40, Image.SCALE_SMOOTH));
        button[1][3].setIcon(resizedIcon);

        imagePath = "images//pencil.png"; //add images to the buttons
        icon = new ImageIcon(imagePath);
        resizedIcon = new ImageIcon(icon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
        button[0][4].setIcon(resizedIcon);

        imagePath = "images//eraser.png"; //add images to the buttons
        icon = new ImageIcon(imagePath);
        resizedIcon = new ImageIcon(icon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
        button[1][4].setIcon(resizedIcon);

        button[0][0].addActionListener(new ActionListener() { //add actioons listener to the button and changed the fill and currentshape in Canvas1.
            public void actionPerformed(ActionEvent e) {
                resetUndoErrorLabel();
                mainCanvas.setFill(true);
                mainCanvas.setCurrentShape("oval");
            }
        });
        button[1][0].addActionListener(new ActionListener() {  //add actioons listener to the button and changed the fill and currentshape in Canvas1.
            public void actionPerformed(ActionEvent e) {
                resetUndoErrorLabel();
                mainCanvas.setFill(false);
                mainCanvas.setCurrentShape("oval");
            }
        });
        button[0][1].addActionListener(new ActionListener() {  //add actioons listener to the button and changed the fill and currentshape in Canvas1.
            public void actionPerformed(ActionEvent e) {
                resetUndoErrorLabel();
                mainCanvas.setFill(true);
                mainCanvas.setCurrentShape("rectangle");
            }
        });
        button[1][1].addActionListener(new ActionListener() {  //add actioons listener to the button and changed the fill and currentshape in Canvas1.
            public void actionPerformed(ActionEvent e) {
                resetUndoErrorLabel();
                mainCanvas.setFill(false);
                mainCanvas.setCurrentShape("rectangle");
            }
        });
        button[0][2].addActionListener(new ActionListener() {  //add actioons listener to the button and changed the fill and currentshape in Canvas1.
            public void actionPerformed(ActionEvent e) {
                resetUndoErrorLabel();
                mainCanvas.setFill(true);
                mainCanvas.setCurrentShape("triangle");
            }
        });
        button[1][2].addActionListener(new ActionListener() {  //add actioons listener to the button and changed the fill and currentshape in Canvas1.
            public void actionPerformed(ActionEvent e) {
                resetUndoErrorLabel();
                mainCanvas.setFill(false);
                mainCanvas.setCurrentShape("triangle");
            }
        });
        button[0][3].addActionListener(new ActionListener() {  //add action listener and set currentShape in Canvas1
            public void actionPerformed(ActionEvent e) {
                resetUndoErrorLabel();
                mainCanvas.setCurrentShape("SolidLine");
            }
        });
        button[1][3].addActionListener(new ActionListener() {  //add action listener and set currentShape in Canvas1
            public void actionPerformed(ActionEvent e) {
                resetUndoErrorLabel();
                mainCanvas.setCurrentShape("DashedLine");
            }
        });
        button[0][4].addActionListener(new ActionListener() {  //add action listener and set currentShape in Canvas1
            public void actionPerformed(ActionEvent e) {
                resetUndoErrorLabel();
                mainCanvas.setCurrentShape("Pencil");
            }
        });
        button[1][4].addActionListener(new ActionListener() {  //add action listener and set currentShape in Canvas1
            public void actionPerformed(ActionEvent e) { 
                resetUndoErrorLabel();
                mainCanvas.setCurrentShape("Eraser");
            }
        });
        

        panel[5] = new JPanel();
        String[] options = {"Select line size", "2", "4", "6", "8", "10"};  //Options for the drop box for the fontsize.
        fontsizeBox = new JComboBox<>(options);
        fontsizeBox.addActionListener(new ActionListener() {  //add Action Listener to the drop box to update the fontsize. 
            public void actionPerformed(ActionEvent e) {
                int fontsize;
                if(fontsizeBox.getSelectedItem().toString().equals("Select line size")){
                    fontsize = 1;
                } else{
                fontsize = Integer.parseInt(fontsizeBox.getSelectedItem().toString());}
                mainCanvas.setFontSize(fontsize);
            }
        });

        JPanel panelUndo = new JPanel();
        undoButton = new JButton();

        imagePath = "images//undo.png"; //add images to the buttons
        icon = new ImageIcon(imagePath);
        resizedIcon = new ImageIcon(icon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
        undoButton.setIcon(resizedIcon);

        undoError = new JLabel();
        undoError.setHorizontalAlignment(JLabel.CENTER);
        undoButton.addActionListener(new ActionListener() {  //add Action Listener to the undo Button and then call the undoPressed function for Canvas1.
            public void actionPerformed(ActionEvent e){
                Drawing drawing = mainCanvas.getFirstDrawing();
                if(drawing == null){
                    try{
                        throw new IndexOutOfBoundsException();
                    } catch (IndexOutOfBoundsException n) { //n is used in place of e because e is already being used.
                        undoError.setText("There is nothing to Undo!");
                    }
                } else {mainCanvas.undoPressed();}
            }
        });

        panelUndo.setLayout(new GridLayout(2,1)); //add buttons to the panelUndo
        panelUndo.add(undoButton);
        panelUndo.add(undoError);

        panel[5].setLayout(new GridLayout(2, 1)); //add panelUndo to the panel
        panel[5].add(fontsizeBox);
        panel[5].add(panelUndo);

        toolbar.add(panel[5]); //add panel to toolbar

        panel[6] = new JPanel();
        JButton colorButton = new JButton();
        x = 50; 
        y = 0; 
        width = 25; 
        height = 25; 
        color = Color.RED;
        fill = true;

        Rectangle button00 = new Rectangle(x, y, width, height, color, fill); //create Rectangle for the Color selection box. 

        JPanel drawingPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {  //Paint the rectangle onto the canvas.
                super.paintComponent(g);
                button00.draw(g); 
            }
        };
        drawingPanel.setPreferredSize(new Dimension(25, 25));
        colorButton.setLayout(new BorderLayout());
        colorButton.add(drawingPanel, BorderLayout.CENTER);
        colorButton.addActionListener(new ActionListener() {  //add ActionListener to the Color Chooser button. And Launch the Color Chooser Pallet. 
            public void actionPerformed(ActionEvent e){
                Color selectedColor = JColorChooser.showDialog(GUI.this, "Choose a Color", Color.RED);
                button00.setColor(selectedColor); //set Color
                mainCanvas.setColor(selectedColor);
            }
        });

        JButton resetButton = new JButton();

        imagePath = "images//resets.png"; //add images to the buttons
        icon = new ImageIcon(imagePath);
        resizedIcon = new ImageIcon(icon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
        resetButton.setIcon(resizedIcon);

        resetButton.addActionListener(new ActionListener() { //add ActionListener to the reset button and then make the canvas reset by calling the function to reset the canvas. 
            public void actionPerformed(ActionEvent e){
                mainCanvas.resetCanvas();
            }
        });

        JButton saveButton = new JButton();

        imagePath = "images//save.png"; //add images to the buttons
        icon = new ImageIcon(imagePath);
        resizedIcon = new ImageIcon(icon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
        saveButton.setIcon(resizedIcon);

        saveButton.addActionListener(new ActionListener() { //add ActionListener to the save button to start the saving process.
            public void actionPerformed(ActionEvent e){
                    JFrame fileNameAsk = new JFrame();
                    JTextField name = new JTextField(10);
                    JLabel prompt = new JLabel("Enter the file name you want");
                    JButton saveReal = new JButton("Save");
                    fileNameAsk.setLayout(new FlowLayout());
                    fileNameAsk.setBounds(200,200,200,200);
                    fileNameAsk.add(name);
                    fileNameAsk.add(prompt);
                    fileNameAsk.add(saveReal);
                    saveReal.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e){
                        try {
                            BufferedImage bimage = new BufferedImage(mainCanvas.getWidth(), mainCanvas.getHeight(), BufferedImage.TYPE_INT_RGB);            
                            Graphics2D bGr = bimage.createGraphics();
                            mainCanvas.paint(bGr);
                            javax.imageio.ImageIO.write(bimage, "png", new File(name.getText() + ".png"));
                            bGr.dispose();
                            undoError.setText("File saved");
                            fileNameAsk.dispose();
                        } 
                        catch (Exception ex) {
                            undoError.setText("Error saving file");
                        }
            }});
                    fileNameAsk.setVisible(true);
            }
        });

        panel[6].setLayout(new GridLayout(3, 1)); // add the buttons to the panel.
        panel[6].add(colorButton);
        panel[6].add(resetButton);
        panel[6].add(saveButton);

        toolbar.add(panel[6]);  // add panel to the toolbar

        setLayout(new BorderLayout());
        add(toolbar, BorderLayout.NORTH);

        add(mainCanvas, BorderLayout.CENTER);

        setVisible(true);
    }
    public void resetUndoErrorLabel() {undoError.setText("");} //resets error label.
}
