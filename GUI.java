import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.*;

public class GUI extends JFrame {
    public static void main(String[] args) {
        new GUI();
    }

    private JToolBar toolbar;
    private JButton[][] button;
    private JPanel[] panel;
    private JComboBox<String> fontsizeBox;
    private JButton undoButton;
    private JLabel undoError;
    
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected Color color;
    protected boolean fill;
    private Canvas1 mainCanvas = new Canvas1();


    public GUI() {
        int w = 1250;
        int h = 700;
        setTitle("Paint");
        setSize(w, h);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        toolbar = new JToolBar();

        panel = new JPanel[7];
        button = new JButton[2][5];

        for (int col = 0; col < 5; col++) {
            panel[col] = new JPanel();
            button[0][col] = new JButton();
            button[1][col] = new JButton();

            panel[col].setLayout(new GridLayout(2, 1));
            panel[col].add(button[0][col]);
            panel[col].add(button[1][col]);

            toolbar.add(panel[col]);
        }
        
        String imagePath = "filledCircle.png"; //add images to the buttons
        ImageIcon icon = new ImageIcon(imagePath);
        ImageIcon resizedIcon = new ImageIcon(icon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
        button[0][0].setIcon(resizedIcon);

        imagePath = "drawCircle.png"; //add images to the buttons
        icon = new ImageIcon(imagePath);
        resizedIcon = new ImageIcon(icon.getImage().getScaledInstance(60, 40, Image.SCALE_SMOOTH));
        button[1][0].setIcon(resizedIcon);

        imagePath = "filledSquare.png"; //add images to the buttons
        icon = new ImageIcon(imagePath);
        resizedIcon = new ImageIcon(icon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
        button[0][1].setIcon(resizedIcon);

        imagePath = "drawSquare.png"; //add images to the buttons
        icon = new ImageIcon(imagePath);
        resizedIcon = new ImageIcon(icon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
        button[1][1].setIcon(resizedIcon);

        imagePath = "filledTriangle.png"; //add images to the buttons
        icon = new ImageIcon(imagePath);
        resizedIcon = new ImageIcon(icon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
        button[0][2].setIcon(resizedIcon);

        imagePath = "drawtriangle.jpg"; //add images to the buttons
        icon = new ImageIcon(imagePath);
        resizedIcon = new ImageIcon(icon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
        button[1][2].setIcon(resizedIcon);

        imagePath = "line.jpg"; //add images to the buttons
        icon = new ImageIcon(imagePath);
        resizedIcon = new ImageIcon(icon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
        button[0][3].setIcon(resizedIcon);

        imagePath = "dashedLine.png"; //add images to the buttons
        icon = new ImageIcon(imagePath);
        resizedIcon = new ImageIcon(icon.getImage().getScaledInstance(80, 40, Image.SCALE_SMOOTH));
        button[1][3].setIcon(resizedIcon);

        imagePath = "pencil.jpg"; //add images to the buttons
        icon = new ImageIcon(imagePath);
        resizedIcon = new ImageIcon(icon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
        button[0][4].setIcon(resizedIcon);

        imagePath = "eraser.jpg"; //add images to the buttons
        icon = new ImageIcon(imagePath);
        resizedIcon = new ImageIcon(icon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
        button[1][4].setIcon(resizedIcon);

        button[0][0].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetUndoErrorLabel();
                mainCanvas.setFill(true);
                mainCanvas.setCurrentShape("oval");
            }
        });
        button[1][0].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetUndoErrorLabel();
                mainCanvas.setFill(false);
                mainCanvas.setCurrentShape("oval");
            }
        });
        button[0][1].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetUndoErrorLabel();
                mainCanvas.setFill(true);
                mainCanvas.setCurrentShape("rectangle");
            }
        });
        button[1][1].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetUndoErrorLabel();
                mainCanvas.setFill(false);
                mainCanvas.setCurrentShape("rectangle");
            }
        });
        button[0][2].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetUndoErrorLabel();
                mainCanvas.setFill(true);
                mainCanvas.setCurrentShape("triangle");
            }
        });
        button[1][2].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetUndoErrorLabel();
                mainCanvas.setFill(false);
                mainCanvas.setCurrentShape("triangle");
            }
        });
        button[0][4].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetUndoErrorLabel();
                mainCanvas.setCurrentShape("pencil");
            }
        });

        panel[5] = new JPanel();
        String[] options = {"", "2 pt", "4 pt", "6 pt", "8 pt", "10 pt"};
        fontsizeBox = new JComboBox<>(options);
        fontsizeBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int fontsize = Integer.parseInt(fontsizeBox.getSelectedItem().toString());
                mainCanvas.setFontSize(fontsize);
            }
        });

        JPanel panelUndo = new JPanel();
        undoButton = new JButton();

        imagePath = "undo.png"; //add images to the buttons
        icon = new ImageIcon(imagePath);
        resizedIcon = new ImageIcon(icon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
        undoButton.setIcon(resizedIcon);

        undoError = new JLabel();
        undoError.setHorizontalAlignment(JLabel.CENTER);
        undoButton.addActionListener(new ActionListener() {
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

        panelUndo.setLayout(new GridLayout(2,1));
        panelUndo.add(undoButton);
        panelUndo.add(undoError);

        panel[5].setLayout(new GridLayout(2, 1));
        panel[5].add(fontsizeBox);
        panel[5].add(panelUndo);

        toolbar.add(panel[5]);

        panel[6] = new JPanel();
        JButton colorButton = new JButton();
        x = 50; 
        y = 0; 
        width = 25; 
        height = 25; 
        color = Color.RED;
        fill = true;

        Rectangle button00 = new Rectangle(x, y, width, height, color, fill);

        JPanel drawingPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                button00.draw(g); 
            }
        };
        drawingPanel.setPreferredSize(new Dimension(25, 25));
        colorButton.setLayout(new BorderLayout());
        colorButton.add(drawingPanel, BorderLayout.CENTER);
        colorButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                Color selectedColor = JColorChooser.showDialog(GUI.this, "Choose a Color", Color.RED);
                button00.setColor(selectedColor);
                mainCanvas.setColor(selectedColor);
            }
        });

        JButton resetButton = new JButton();

        imagePath = "reset.jpg"; //add images to the buttons
        icon = new ImageIcon(imagePath);
        resizedIcon = new ImageIcon(icon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
        resetButton.setIcon(resizedIcon);

        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                mainCanvas.resetCanvas();
            }
        });

        JButton saveButton = new JButton();

        imagePath = "save.jpeg"; //add images to the buttons
        icon = new ImageIcon(imagePath);
        resizedIcon = new ImageIcon(icon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
        saveButton.setIcon(resizedIcon);

        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                try {
                    BufferedImage bimage = new BufferedImage(mainCanvas.getWidth(), mainCanvas.getHeight(), BufferedImage.TYPE_INT_RGB);            
                    Graphics2D bGr = bimage.createGraphics();
                    mainCanvas.paint(bGr);
                    javax.imageio.ImageIO.write(bimage, "png", new File("test.png"));
                    bGr.dispose();
                    undoError.setText("File saved");
                } 
                catch (Exception ex) {
                    undoError.setText("Error saving file");
                }
            }
        });

        panel[6].setLayout(new GridLayout(3, 1));
        panel[6].add(colorButton);
        panel[6].add(resetButton);
        panel[6].add(saveButton);

        toolbar.add(panel[6]);

        setLayout(new BorderLayout());
        add(toolbar, BorderLayout.NORTH);

        add(mainCanvas, BorderLayout.CENTER);

        setVisible(true);
    }
    public void resetUndoErrorLabel() {undoError.setText("");}
}
